/**
 * The class Making Change solves a classic problem:
 * given a set of coins, how many ways can you make change for a target amount?
 *
 * @author Zach Blick
 * @author Jacob Lowe
 */

public class MakingChange {
    /**
     * TODO: Complete this function, countWays(), to return the number of ways to make change
     *  for any given total with any given set of coins.
     */
    public static long countWays(int target, int[] coins) {

        // Only 1 way to get 0 coins
        long ways[] = new long[target + 1];
        ways[0] = 1;

        // Go through each coin type and find the total number of ways
        // to get there by adding the previous amount of ways to the current

        // Target 4: [1,2]
        // Goes through J from 1-4, ways[j] become 1
        // Goes through J from 2-4,
        //  ways[2] = ways[0] + ways[2], 2
        //  ways[3] = ways[1] + ways[3], 2
        //  ways[4] = ways[2] + ways[4], 3
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= target; j++) {
                ways[j] += ways[j - coins[i]];
            }
        }
        return ways[target];
    }
}
