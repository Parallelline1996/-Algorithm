package Page3;

import java.util.ArrayList;
import java.util.List;

/*
* 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
*
* 找规律，将结果保存到数组，再转为 List 存储
* */
public class N118_PascalsTriangle {

    public static void main(String[] args) {
        int n = 5;
        int[][] array = generate_(n);
        if (array == null) {
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> output = new ArrayList<>();
        if (numRows <= 0) {
            return output;
        }
        int[][] array = new int[numRows][numRows];
        array = generate_(numRows);
        List<Integer> temp = null;
        for (int i = 0; i < numRows; i++) {
            temp = new ArrayList<>(i + 1);
            for (int j = 0; j <= i; j++) {
                temp.add(array[i][j]);
            }
            output.add(temp);
        }
        return output;
    }

    private static int[][] generate_(int n) {
        if (n <= 0) {
            return null;
        }
        int[][] array = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == n - 1) {
                    array[i][j] = 1;
                } else {
                    array[i][j] = array[i - 1][j] + array[i - 1][j - 1];
                }
            }
        }
        return array;
    }
}
