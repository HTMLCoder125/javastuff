import java.util.Scanner;
import java.util.Random;

public class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    Random rand = new Random();
    List<Integer> randomNumbers = new ArrayList<Integer>();
    int max = 20;

    int number = rand.nextInt(max);
    randomNumbers.add(number);
    String userInput = "";
    int guessCount = 0;

    while(!userInput.equals(number)) {
      System.out.println("Guess a number (You have 5 tries): ");
      guess = input.nextLine();
      guesscount++;
      
      if(guess > randomNumbers.get(0)) {
        System.out.println("Your guess is too high.");
      }
      else if(guess < randomNumbers.get(0)) {
        System.out.println("Your guess is too low.");
      }
      if(guesscount == 5) {
        System.out.println("You fail. Try again next time.");
      }

    }
  }
}s
