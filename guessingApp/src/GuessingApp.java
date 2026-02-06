import java.io.IOException;
import java.util.Scanner;

/**
 * GuessingApp Use Case 6: Game Result Storage
 * <p>
 * This class coordinates the complete game lifecycle,
 * allowing the player to replay or exit gracefully.
 * <p>
 * Responsibilities:
 * - Start a geme session
 * - Execute the guessing flow
 * - Persist game results
 * - Restart or exit based on user choice
 *
 * @author Anbu A
 * @version 6.0
 */
public class GuessingApp {

    public static final String CORRECT = "CORRECT";

    public static void main(String[] args) throws InvalidInputException, IOException {

        Scanner scanner = new Scanner(System.in);
        boolean restart;

        System.out.println("=========================================");
        System.out.println("Welcome to the Guessing App");
        System.out.println("=========================================");
        /*
         *  Outer loop controls whether
         *  a new game session should start */
        do {
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
                    win=true;
                    break;
                }
            }
            /*
             * Final game result is persisted
             *  after the game loop completes.
             */
            StorageService.saveResult(player, attempts, win);
            /*
             *Player decides whether to restart
             * the game or exit.
             */
            restart = GameController.restartGame(scanner);
        } while (restart);
    }
}