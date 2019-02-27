package Page2;


/*
* 给定一个整数 n，返回 n 皇后不同的解决方案的数量。
* */
public class N52_N_Queens2 {

    public static void main(String[] args) {
        System.out.println(new N52_N_Queens2().solveNQueens(4));
        System.out.println(new N52_N_Queens2().solveNQueens(8));
    }

    private int solveNQueens(int n) {
        if (n <= 0) {
            return 0;
        }
        solveQueens(new int[n][n], 1, n);
        return this.number;
    }

    private int number = 0;

    // n : 第几行
    // total : 总共几行
    private void solveQueens(int[][] nums, int n, int total) {
        // 当 n>total，即已经有足够的符合条件的行数
        if (n > total) {
            this.number++;
            return;
        }
        // 对于第 n行的 n个位置，进行遍历
        for (int i = 1; i <= total; i++) {
            // 判断第 n行的第 i个位置是否符合
            if (placeAQueue(n - 1, i - 1, nums)) {
                nums[n - 1][i - 1] = 1;
                // 判断第 n+1行，即下一行是否符合
                solveQueens(nums, n + 1, total);
                nums[n - 1][i - 1] = 0;
            }
        }
    }

    // 判断横竖斜三个方向
    private boolean placeAQueue (int row, int len, int[][] nums) {
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
