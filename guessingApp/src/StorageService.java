/*
 * Use Case 5 : Game Result Storage
 *
 * This class is responsible for persisting the
 * final game result after the game ends.
 *
 * Results are stored in a file so that game
 * history is not lost after exit.
 */

import java.io.FileWriter;
import java.io.IOException;

public class StorageService {

    /*
     * Saves the final outcome of the game.
     *
     * Each record contains:
     * - Player name
     * - Number of attempts used
     * - Win or loss result
     */
    public static void saveResult(String player, int attemps, boolean win) throws IOException {
        /*
         * Try-wit-resources  ensures that the writer
         * is closed automatically after the
         * operation completes.
         */
        try (FileWriter writer = new FileWriter(
                "game_result.txt", true)) {
            writer.write("Player : " + player +
                    ", Attempts : " + attemps +
                    ", Result : " + (win ? "WIN" : "LOSE"));
            writer.append('\n');
        } catch (IOException e) {
            System.out.println("Unable ti save game result.");
        }
    }
}