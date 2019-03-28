package Page19;

import easy.Array;

import java.util.Arrays;

/*
* Given a square array of integers A, we want the minimum sum of a falling path through A.
A falling path starts at any element in the first row, and chooses one element from each row.
The next row's choice must be in a column that is different from the previous row's column by at most one.



Example 1:
Input: [[1,2,3],[4,5,6],[7,8,9]]
Output: 12
Explanation:
The possible falling paths are:
[1,4,7], [1,4,8], [1,5,7], [1,5,8], [1,5,9]
[2,4,7], [2,4,8], [2,5,7], [2,5,8], [2,5,9], [2,6,8], [2,6,9]
[3,5,7], [3,5,8], [3,5,9], [3,6,8], [3,6,9]
The falling path with the smallest sum is [1,4,7], so the answer is 12.


Note:
1 <= A.length == A[0].length <= 100
-100 <= A[i][j] <= 100
* */
public class N931_MinimumFallingPathSum {

    public static void main(String[] args) {
        System.out.println(new N931_MinimumFallingPathSum().minFallingPathSum(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
        System.out.println(new N931_MinimumFallingPathSum().minFallingPathSum(new int[][]{{7,8,9}}));

    }

    // 可以用 dfs进一步加快速度

    /*
    * 思路：
    * 这道题并非用贪婪，这道题每一次过行只能偏移一列，因此依旧是动态规划
    * */
    public int minFallingPathSum(int[][] A) {
        if (A == null || A.length == 0) return 0;
        // 对第一行特殊讨论
        if (A.length == 1) {
            Arrays.sort(A);
            return A[0][0];
        }
        int[][] dp = new int[A.length][A[0].length];
        System.arraycopy(A, 0, dp, 0, A[0].length);
        int min = Integer.MAX_VALUE;
        // 其他行正常进行比较
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                dp[i][j] = Math.min(Math.min(helper(dp, i - 1, j - 1), helper(dp, i - 1, j)),
                        helper(dp, i - 1, j + 1)) + A[i][j];
                if (i == A.length - 1)
                    min = Math.min(dp[i][j], min);
            }
        }
        return min;
    }

    private int helper(int[][] dp, int i, int j) {
        if (j < 0 || j >= dp[0].length) return Integer.MAX_VALUE;
        return dp[i][j];
    }
}
