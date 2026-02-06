/*
 *Custom exception used when user
 * input fails validation.
 *
 * This allows the game to fail gracefully
 * with a meaningful message
 */

public class InvalidInputException extends Exception {

    public InvalidInputException(String message) {
        super(message);
    }
}
