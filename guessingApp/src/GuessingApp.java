import java.util.Scanner;

/**
 * GuessingApp Use Case 1: Game Initialization
 * <p>
 * This class serves as the application entry point.
 * It initializes the game configuration and displaysgame rules.
 * <p>
 * No users input or gameplay logic is implemented at this stage.
 *
 * @author Anbu A
 * @version 2.0
 */
public class GuessingApp {

    public static final String CORRECT = "CORRECT";

    public static void main(String[] args) {

        System.out.println("Welcome to the Guessing App");
        GameConfig gameConfig = new GameConfig();
        gameConfig.showRules();

        Scanner sc = new Scanner(System.in);
        int attempts = 0;

        /*
         * Game loop runs until the player exhausts the
         * maximum attempts
         */
        while (attempts < gameConfig.getMAX_ATTEMPTS()) {
            System.out.println("Enter your guess: ");
            int guess = sc.nextInt();
            attempts++;

            String result = GuessValidator.validateGuess(guess, gameConfig.getTargetNumber());

            System.out.println(result);

            /*
             * Stop the loop immediately
             * if the correct number is guessed.
             */
            if (CORRECT.equals(result)) {
                break;
            }
        }
    }
}