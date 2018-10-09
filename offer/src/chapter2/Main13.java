package chapter2;

/*
* 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
* 每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
* 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
* 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
* */
public class Main13 {

    public static void main(String[] args) {
        System.out.println(movingCount(5, 10, 10));
        System.out.println(movingCount(10, 1, 10));
        System.out.println(movingCount(15, 100, 1));
    }

    private static int movingCount(int threshold, int rows, int cols) {
        if (threshold <= 0 || rows <= 0 || cols <= 0) {
            return 0;
        }
        int[] mark = new int[rows * cols];
        moving(threshold, rows, cols, mark, 0, 0);
        int number = 0;
        for (int a : mark
             ) {
            if (a != 0) {
                number++;
            }
        }
        return number;
    }

    private static void moving(int k, int totalRows, int totalCols, int[] mark, int row, int col) {
        if (row < 0 || row >= totalRows || col < 0 || col >= totalCols) {
            return;
        }
        if (k >= (getValue(row) + getValue(col)) && mark[row * totalCols + col] == 0) {
            mark[row * totalCols + col] = 1;
            moving(k, totalRows, totalCols, mark, row - 1, col);
            moving(k, totalRows, totalCols, mark, row, col - 1);
            moving(k, totalRows, totalCols, mark, row + 1, col);
            moving(k, totalRows, totalCols, mark, row, col + 1);
        }
    }

    private static int getValue(int number) {
        int output = 0;
        while (number > 0) {
            output += (number % 10);
            number /= 10;
        }
        return output;
    }
}
