/*
 *Handles validation of user input before
 * it is used in game logic
 *
 * All input checks are centralized to keep
 * main() clean and focused.
 */

public class ValidationService {

    /*
     * Validates raw user inputs.
     *
     * Flows:
     * - Convert input to integer
     * - Check allowed range
     * - Throw custom exception if invalid
     */
    public static int validateInput(String input) throws InvalidInputException {
        try {
            int value = Integer.parseInt(input);
            if (value < 1 || value > 100) {
                throw new InvalidInputException("Invalid input." +
                        "Please enter number only.");
            }
            return value;
        }catch (NumberFormatException e){
            throw new InvalidInputException("Invalid input." +
                    "Please enter number only.");
        }
    }
}
