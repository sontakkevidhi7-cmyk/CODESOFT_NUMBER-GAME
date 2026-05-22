import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int totalScore = 0;
        int round = 1;
        String playAgain;

        System.out.println("===== Welcome to the Number Guessing Game =====");

        do {
            int number = rand.nextInt(100) + 1; // Random number between 1-100
            int attempts = 0;
            int maxAttempts = 5;
            boolean guessedCorrectly = false;

            System.out.println("\nRound " + round);
            System.out.println("Guess the number between 1 and 100");
            System.out.println("You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess = sc.nextInt();

                attempts++;

                if (guess == number) {
                    System.out.println(" Correct! You guessed the number.");
                    guessedCorrectly = true;

                    int score = (maxAttempts - attempts + 1) * 10;
                    totalScore += score;

                    System.out.println("You scored: " + score);
                    break;
                } 
                else if (guess > number) {
                    System.out.println(" Too high!");
                } 
                else {
                    System.out.println(" Too low!");
                }

                System.out.println("Attempts left: " + (maxAttempts - attempts));
            }

            if (!guessedCorrectly) {
                System.out.println(" Game Over! The correct number was: " + number);
            }

            System.out.println("Total Score: " + totalScore);

            System.out.print("\nDo you want to play again? (yes/no): ");
            playAgain = sc.next();

            round++;

        } while (playAgain.equalsIgnoreCase("yes"));

        System.out.println("\n===== Thanks for Playing! =====");
        System.out.println("Final Score: " + totalScore);

        sc.close();
    }
}