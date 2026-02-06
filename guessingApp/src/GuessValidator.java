/*
 * Use Case 2 : User Guess Submission
 *
 * This class is responsible for comparing the
 * user's guess with the target number.
 */
public class GuessValidator {

    public static String validateGuess(int guess, int targetNumber) {

        if (guess == targetNumber) {
            return "CORRECT";
        } else if (guess < targetNumber) {
            return "LOW";
        }
        return "HIGH";
    }
}
