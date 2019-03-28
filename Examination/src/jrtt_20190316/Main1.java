package jrtt_20190316;

import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 1024 - scanner.nextInt();
        int[] dp = new int[n + 1];
        int[] coins = new int[]{1, 4, 16, 64};
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0 && dp[i - coins[j]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i- coins[j]] + 1, dp[i]);
                }
            }
        }
        System.out.println(dp[n]);
    }
}
