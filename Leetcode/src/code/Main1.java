package code;


/*
* Given a string s, partition s such that every substring of the partition is
* a palindrome.Return the minimum cuts needed for a palindrome partitioning of s.
* For example, given s ="aab",
* Return1since the palindrome partitioning["aa","b"]could be produced using 1 cut.
* 即，一个字符串，判断最少切几次，可以让每个字串都是回文字符串
* */
public class Main1 {
    public int minCut(String s) {
        if (s == null | isPalindrome(s)) {
            return 0;
        }
        int[] dp = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (!isPalindrome(s.substring(0, i + 1))) {
                dp[i] = i;
            }
            for (int j = 1; j <= i; j++) {
                if (isPalindrome(s.substring(j, i + 1))) {
                    dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                } else {
                    dp[i] = Math.min(dp[i], dp[j - 1] + i + 1 - j);
                }
            }
        }
        return dp[s.length() - 1];
    }

    private static boolean isPalindrome(String data) {
        if (data == null) {
            return true;
        }
        StringBuilder stringBuilder = new StringBuilder(data);
        return data.equals(stringBuilder.reverse().toString());
    }
}
