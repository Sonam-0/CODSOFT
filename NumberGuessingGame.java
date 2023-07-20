import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {

    public static int generateRandomNumber(int minNum, int maxNum) {
        Random random = new Random();
        return random.nextInt(maxNum - minNum + 1) + minNum;
    }

    public static int getUserGuess(int minNum, int maxNum) {
        Scanner sc = new Scanner(System.in);
        int guess;
        while (true) {
            try {
                System.out.print("Guess the number (between " + minNum + " and " + maxNum + "): ");
                guess = Integer.parseInt(sc.nextLine());
                if (guess >= minNum && guess <= maxNum) {
                    return guess;
                } else {
                    System.out.println("Please enter a number between " + minNum + " and " + maxNum + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    public static boolean playGame(int minNum, int maxNum, int attempts) {
        int generatedNumber = generateRandomNumber(minNum, maxNum);
        int attemptsLeft = attempts;
        Scanner scanner = new Scanner(System.in);
        while (attemptsLeft > 0) {
            int userGuess = getUserGuess(minNum, maxNum);
            if (userGuess == generatedNumber) {
                System.out.println("Congratulations! You guessed the correct number.");
                return true;
            } else if (userGuess < generatedNumber) {
                System.out.println("Too low. Try again.");
            } else {
                System.out.println("Too high. Try again.");
            }
            attemptsLeft--;
            System.out.println("Attempts left: " + attemptsLeft);
        }
        System.out.println("Sorry, you've run out of attempts. The correct number was " + generatedNumber + ".");
        return false;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Number Guessing Game!");
        int minNum = 1;
        int maxNum = 100;
        int attempts = 10;
        int rounds = 0;
        int score = 0;
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Do you want to play a round? (yes/no): ");
            String playAgain = sc.nextLine().toLowerCase();
            if (!playAgain.equals("yes")) {
                System.out.println("Thanks for playing! Your final score is " + score + ".");
                break;
            }

            System.out.println("\nRound " + (rounds + 1) + ":");
            if (playGame(minNum, maxNum, attempts)) {
                score++;
            }
            rounds++;
        }
    }
}
