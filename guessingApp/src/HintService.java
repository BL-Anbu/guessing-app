/*
 * Use Case 3: Hint Generation
 *
 * This class is responsible for generating
 * controlled hints based on the number of incorrect
 * attempts made by the player.
 *
 * Hint logic is isolated to avoid cluttering
 * the main game flow
 */

public class HintService {

    /*
     * Generates a hint based on how many hints
     * have already been used
     *
     * Hints provide partial information without
     * revealing the exact number
     */
    public static String generateHint(int guess, int target, int hitCount) {

        if (hitCount == 1) {
            return (target % 2 == 0) ? "Hint : Number is EVEN"
                    : "Hint : Number is ODD";
        } else if (hitCount == 2) {
            return (target > guess)
                    ? "Hint : Number is greater than " + guess
                    : "Hint : Number is lesser than " + guess;
        }
        return "No more hints available";
    }
}