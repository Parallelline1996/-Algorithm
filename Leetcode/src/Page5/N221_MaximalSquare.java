package Page5;

/*
*
Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
Example:
Input:
1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Output: 4
* */
public class N221_MaximalSquare {

    public static void main(String[] args) {

//        char[][] a = new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
//        System.out.println(maximalSquare(a));

        char[][] b = new char[][]{{'1','1','1','1'},{'1','1','1','1'},{'1','1','1','1'}};
        System.out.println(maximalSquare(b));
    }

    private static int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        // 初始化最左边跟最上面的两排
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            dp[i][0] = matrix[i][0] - '0';
        }
        for (int j = 0; j < matrix[0].length; j++) {
            dp[0][j] = matrix[0][j] - '0';
        }

        int output = 0;
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    if (matrix[i - 1][j - 1] == 0 || matrix[i][j - 1] == 0 || matrix[i - 1][j] == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
                    }
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                output = output > dp[i][j] ? output : dp[i][j];
            }
        }
        return output * output;
    }
}
