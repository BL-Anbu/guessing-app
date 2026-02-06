import java.util.Scanner;

/*
 * Handles game lifecycle decisions.
 *
 * This class is responsible for deciding whether
 * the game should restart or exit based
 * on user choice.
 */
public class GameController {

    /*
     * Asks the player if they want to restart
     * the game after completion.
     *
     * Returns true if the game should restart,
     * false if the application should exit.
     */
    public static boolean restartGame(Scanner scanner){
        System.out.println("Do you want to play again? (Yes/No): ");
        return scanner.nextLine().equalsIgnoreCase("yes");
    }
}
