package Page2;

/*
* 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
说明：每次只能向下或者向右移动一步。
示例:
输入:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
输出: 7
解释: 因为路径 1→3→1→1→1 的总和最小。
* */
public class N64_MinimumPathSum {

    public static void main(String[] args) {
        minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}});
        minPathSum(new int[][]{{1, 2}, {1, 1}});
    }

    private static int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < grid[0].length; i++) {
            dp[0][i] = grid[0][i] + dp[0][i - 1];
        }
        for (int i = 1; i < grid.length; i++) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
//        for (int[] l : dp
//             ) {
//            for (int b : l
//                 ) {
//                System.out.print(b + "  ");
//            }
//            System.out.println();
//        }
        return dp[grid.length - 1][grid[0].length - 1];
    }
}
