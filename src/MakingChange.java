import java.util.ArrayList;

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

    /**
     * Tabulation
     */
    public static long countWays(int target, int[] coins) {

        // 2D Array for Target as Row & Coins as Col
        long[][] arrCoins = new long[target + 1][coins.length];

        // Base Case: 1 way to make a target of 0
        for (int i = 0; i < coins.length; i++) {
            arrCoins[0][i] = 1;
        }

        // Tabulate through table
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < coins.length; j++) {

                // Include the current coin and subtract that coin's value -> Check to the index Left
                long include = 0;
                if (i >= coins[j]) {
                    include = arrCoins[i - coins[j]][j];
                }

                // Exclude the current coin and move on to the next coin -> Check to the index Above
                long exclude = 0;
                if (j > 0) {
                    exclude = arrCoins[i][j - 1];
                }
                arrCoins[i][j] = include + exclude;
            }
        }

        return arrCoins[target][coins.length - 1];
    }

    /**
     * Recursion w/ Memoization
      */
//    public static long countWays(int target, int[] coins) {
//
//        // 2D Array for Target as Row & Coins as Col
//        long[][] arrCoins = new long[target + 1][coins.length];
//
//        // Begin recursion
//        return count(arrCoins, coins, target, coins.length - 1);
//
//    }
//
//    public static long count(long[][]arrCoins, int[] coins, int sum, int index) {
//
//        // Base Case
//        if (sum == 0) { return 1; }
//        if (sum < 0) { return 0; }
//        if (index < 0 ) { return 0; }
//
//        // Memoization to check if already found value
//        if (arrCoins[sum][index] > 0) {
//            return arrCoins[sum][index];
//        }
//
//        // Include the current coin and subtract that coin's value
//        // Exclude the current coin and move on to the next coin
//        arrCoins[sum][index] = count(arrCoins, coins, sum - coins[index], index) + count(arrCoins, coins, sum, index - 1);
//        return arrCoins[sum][index];
//    }
}
