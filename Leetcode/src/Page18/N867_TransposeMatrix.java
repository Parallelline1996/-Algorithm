package Page18;

/*
* 给定一个矩阵 A， 返回 A 的转置矩阵。
* 矩阵的转置是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
* */
public class N867_TransposeMatrix {

    public static void main(String[] args) {
        int[][] a = new int[2][1];
        a[0][0] = 5;
        a[1][0] = 8;
        a = transpose(a);
        for (int[] k : a) {
            for (int j : k) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    private static int[][] transpose(int[][] A) {
        int row = A.length, col = A[0].length;
        int[][] output = new int[col][row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                output[j][i] = A[i][j];
            }
        }
        return output;
    }
}
