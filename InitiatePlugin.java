 import java.io.IOException;
    import java.util.ArrayList;

    public class Main extends JavaPlugin implements Listener
    {
            private static Plugin instance;
            public ArrayList<SClass> parkour = new ArrayList<>();


            public void onEnable()
            {
                instance = this;
                getConfig().options().copyDefaults(true);
                saveConfig();
                Server server = getServer();
                ConsoleCommandSender console = server.getConsoleSender();

                if(getConfig().getString("Save").equals("enabled"))
                {
                    try
                    {
                        Metrics metrics = new Metrics(this);
                        metrics.start();
                        console.sendMessage("Metrics is enabled!");
                    } catch(IOException e)
                    {
                        // if it failed to save the stats
                        e.printStackTrace();
                    }
                }
                Bukkit.getPluginManager().registerEvents(this, this);
                getCommand("parkour").setExecutor(new ParkourTeleport());

                Bukkit.getScheduler().runTaskTimer(this, new Runnable()
                {
                    @Override
                    public void run()
                    {
                        for(SClass sClass : parkour)
                        {
                            sClass.removeTime(1);
                        }
                    }
                }, 20);
            }

            public void onDisable()
            {
                getLogger().info("Disabled.");
            }

            public static Plugin getInstance()
            {
                return instance;
            }
    }
