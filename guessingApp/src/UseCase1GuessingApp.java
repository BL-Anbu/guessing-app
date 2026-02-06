/**
 * GuessingApp Use Case 1: Game Initialization
 *
 * This class serves as the application entry point.
 * It initializes the game configuration and displaysgame rules.
 *
 * No users input or gameplay logic is implemented at this stage.
 *
 * @author Anbu A
 * @version 1.0
 */
public class UseCase1GuessingApp {

    public static void main(String[] args) {

        System.out.println("Welcome to the Guessing App");
        GameConfig gameConfig = new GameConfig();
        gameConfig.showRules();
    }
}