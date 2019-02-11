package Page17;

/*
* Given a binary matrix A, we want to flip the image horizontally, then invert it, and return the resulting image.

To flip an image horizontally means that each row of the image is reversed.
For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].

To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0. For example,
inverting [0, 1, 1] results in [1, 0, 0].

Example 1:

Input: [[1,1,0],[1,0,1],[0,0,0]]
Output: [[1,0,0],[0,1,0],[1,1,1]]
Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
Example 2:

Input: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
Notes:

1 <= A.length = A[0].length <= 20
0 <= A[i][j] <= 1
* */
public class N832_FlippingAnImage {

    public int[][] flipAndInvertImage(int[][] A) {
        if (A == null) return null;
        int[][] output = new int[A.length][A[0].length];
        int[] array = null, oldArray = null;
        for (int i = 0; i < A.length; i++) {
            array = output[i];
            oldArray = A[i];
            for (int j = 0; j < oldArray.length; j++) {
                if (oldArray[j] == 1) {
                    array[oldArray.length - j - 1] = 0;
                } else {
                    array[oldArray.length - j - 1] = 1;
                }
            }
        }
        return output;
    }

    /*
    * public int[][] flipAndInvertImage(int[][] A) {
        for (int[] row:A){
            int rowlen = row.length;
            for (int j=0;j<(rowlen+1)/2;j++){
                int tmp = row[j] ^1;
                row[j] = row[rowlen-1-j]^1;
                row[rowlen-1-j] = tmp;
            }
        }
    return A;
    }
    * */
}
