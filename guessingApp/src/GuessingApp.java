import java.io.IOException;
import java.util.Scanner;

/**
 * GuessingApp Use Case 5: Game Result Storage
 * <p>
 * This class coordinates the complete game flow
 * and persists the final result after completion.
 * <p>
 * Responsibilities:
 * - Initialize game configuration
 * - Accept and validate user guesses
 * - Generate hints when applicable
 * - Store game result at the end
 *
 * @author Anbu A
 * @version 5.0
 */
public class GuessingApp {

    public static final String CORRECT = "CORRECT";

    public static void main(String[] args) throws InvalidInputException, IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("=========================================");
        System.out.println("Welcome to the Guessing App");
        System.out.println("=========================================");
        /*
         * Player name is captured once
         * and stored along with game results.
         */
        System.out.print("Enter Player Name: ");
        String player = scanner.nextLine();

        GameConfig gameConfig = new GameConfig();
        gameConfig.showRules();

        int attempts = 0;
        int hintsUsed = 0;

        /*
         * Tracks whether the player successfully guessed the number.
         */
        boolean win = false;

        /*
         * Game loop runs until the player exhausts the
         * maximum attempts
         */
        while (attempts < gameConfig.getMAX_ATTEMPTS()) {
            System.out.println("Enter your guess: ");
            int guess = ValidationService.validateInput(scanner.nextLine());
            attempts++;

            String result = GuessValidator.validateGuess(guess, gameConfig.getTargetNumber());

            /*
             * A hint is generated only after
             * an incorrect guess and within
             * the allowed hint limit.
             */
            if (!CORRECT.equals(result) && hintsUsed < gameConfig.getMAX_HINTS()) {
                hintsUsed++;
                System.out.println(
                        HintService.generateHint(guess, gameConfig.getTargetNumber(), hintsUsed)
                );
            }
            System.out.println(result);

            /*
             * Stop the loop immediately
             * if the correct number is guessed.
             */
            if (CORRECT.equals(result)) {
                break;
            }
        }
        /*
         * Final game result is persisted
         *  after the game loop completes.
         */
        StorageService.saveResult(player, attempts, win);
    }
}