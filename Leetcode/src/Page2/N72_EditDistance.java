package Page2;

/*
* Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character


Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation:
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
Example 2:

Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation:
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')
* */
public class N72_EditDistance {


    public static void main(String[] args) {
//        System.out.println(new N72_EditDistance().minDistance("horse", "ros"));
        System.out.println(new N72_EditDistance().minDistance("intention", "execution"));
//        System.out.println(new N72_EditDistance().minDistance("inten", "execu"));
//        System.out.println(new N72_EditDistance().minDistance("", ""));
//        System.out.println(new N72_EditDistance().minDistance("sea", "eat"));

    }

    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) return 0;
        if (word1.length() == 0) return word2.length();
        if (word2.length() == 0) return word1.length();
        // 定义dp，初始化数据
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
//        if (word1.charAt(0) != word2.charAt(0)) dp[0][0] = 1;
        for (int j = 1; j <= word2.length(); j++) dp[0][j] = dp[0][j - 1] + 1;
        for (int i = 1; i <= word1.length(); i++) dp[i][0] = dp[i - 1][0] + 1;

        // 状态转换
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                // 当 word1 的第 i个字符与 word2 的第 j个字符相同
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 不同，所以考虑三种方式，增删改，各自看对应所需要的时间
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        for (int i = 0; i <= word1.length(); i++) {
            for (int j = 0; j <= word2.length(); j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[word1.length()][word2.length()];
    }
}
