import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {

    private int targetNumber;
    private int attempts;

    public GuessTheNumberGame() {
        Random random = new Random();
        this.targetNumber = random.nextInt(100) + 1;
        this.attempts = 0;
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        int userGuess = 0;

        System.out.println("Welcome to the guess the number game!\n" + "Guess the number between 1 and 100.");

        while (userGuess != targetNumber) {
            System.out.print("Your guess: ");
            userGuess = scanner.nextInt();
            attempts++;

            if (userGuess < targetNumber) {
                System.out.println("Your guess is too low, try again!\n");
            } else if (userGuess > targetNumber) {
                System.out.println("Your guess is too high, try again!\n");
            } else {
                System.out.println("CONGRATULATIONS you guessed the number " + targetNumber + " correct!");
                System.out.println("You needed " + attempts + " attempts");
            }
        }
    }
}
