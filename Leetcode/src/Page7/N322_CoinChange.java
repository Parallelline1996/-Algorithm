package Page7;

/*
* You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up that amount.
  * If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:

Input: coins = [1, 2, 5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Note:
You may assume that you have an infinite number of each kind of coin.
* */
public class N322_CoinChange {

    public static void main(String[] args) {
        System.out.println(new N322_CoinChange().coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(new N322_CoinChange().coinChange(new int[]{2}, 3));
        System.out.println(new N322_CoinChange().coinChange(new int[]{2}, 1));
    }

    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount < 0) return -1;
        int[] dp = new int[amount + 1];
        // 遍历金额数
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0 && dp[i - coins[j]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
                }
            }
        }
//        for (int i = 0; i < dp.length; i++) {
//            System.out.println(i + " " + dp[i]);
//        }
        return dp[amount] == Integer.MAX_VALUE? -1: dp[amount];
    }
}
