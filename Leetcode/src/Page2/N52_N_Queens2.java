package Page2;


/*
* 给定一个整数 n，返回 n 皇后不同的解决方案的数量。
* */
public class N52_N_Queens2 {

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
        System.out.println(solveNQueens(8));
    }

    private static int solveNQueens(int n) {
        StringBuilder output = new StringBuilder();
        if (n <= 0) {
            return 0;
        }
        solveQueens(output, new int[n][n], 1, n);
        return output.length();
    }

    // n : 第几行
    // total : 总共几行
    private static void solveQueens(StringBuilder s, int[][] nums, int n, int total) {
        if (n > total) {
            s.append("a");
            return;
        }
        for (int i = 1; i <= total; i++) {
            if (placeAQueue(n - 1, i - 1, nums)) {
                nums[n - 1][i - 1] = 1;
                solveQueens(s, nums, n + 1, total);
                nums[n - 1][i - 1] = 0;
            }
        }
    }

    private static boolean placeAQueue (int row, int len, int[][] nums) {
        for (int i = row; i >= 0; i--) {
            if (nums[i][len] == 1) {
                return false;
            }
        }
        for (int i = row, j = len; i >= 0 && j >= 0; i--, j--) {
            if (nums[i][j] == 1) {
                return false;
            }
        }
        for (int i = row, j = len; j < nums.length && i >= 0; i--, j++) {
            if (nums[i][j] == 1) {
                return false;
            }
        }
        return true;
    }
}
