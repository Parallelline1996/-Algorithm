package Page2;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

import java.util.ArrayList;
import java.util.List;

/*
* n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
* 上图为 8 皇后问题的一种解法。
给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。

示例:
输入: 4
输出: [
 [".Q..",  // 解法 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // 解法 2
  "Q...",
  "...Q",
  ".Q.."]
]
解释: 4 皇后问题存在两个不同的解法。
* */
public class N51_N_Queens {

    public static void main(String[] args) {
        List<List<String>> output = solveNQueens(4);
        for (List<String> k : output
             ) {
            for (String a : k) {
                System.out.println(a);
            }
            System.out.println();
        }
        System.out.println(output.size());
    }

    private static List<List<String>> solveNQueens(int n) {
        List<List<String>> output = new ArrayList<>();
        if (n <= 0) {
            return output;
        }
        solveQueens(output, new int[n][n], 1, n);
        return output;
    }

    // n : 第几行
    // total : 总共几行
    private static void solveQueens(List<List<String>> output, int[][] nums, int n, int total) {
        if (n > total) {
            addList(output, nums);
            return;
        }
        for (int i = 1; i <= total; i++) {
            if (placeAQueue(n - 1, i - 1, nums)) {
                nums[n - 1][i - 1] = 1;
                solveQueens(output, nums, n + 1, total);
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

    private static void addList(List<List<String>> output, int[][] nums) {
        List<String> temp = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i][j] == 0) {
                    sb.append(".");
                } else {
                    sb.append("Q");
                }
            }
            temp.add(sb.toString());
            sb = new StringBuilder();
        }
        output.add(temp);
    }
}
