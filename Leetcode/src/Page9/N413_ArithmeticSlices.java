package Page9;

/**
 * A sequence of number is called arithmetic if it consists of at least three elements and
 * if the difference between any two consecutive elements is the same.

 For example, these are arithmetic sequence:

 1, 3, 5, 7, 9
 7, 7, 7, 7
 3, -1, -5, -9
 The following sequence is not arithmetic.

 1, 1, 2, 5, 7

 A zero-indexed array A consisting of N numbers is given. A slice of that array is any pair of integers (P, Q) such that 0 <= P < Q < N.

 A slice (P, Q) of array A is called arithmetic if the sequence:
 A[P], A[p + 1], ..., A[Q - 1], A[Q] is arithmetic. In particular, this means that P + 1 < Q.

 The function should return the number of arithmetic slices in the array A.


 Example:

 A = [1, 2, 3, 4]

 return: 3, for 3 arithmetic slices in A: [1, 2, 3], [2, 3, 4] and [1, 2, 3, 4] itself.
 * */
public class N413_ArithmeticSlices {

    public static void main(String[] args) {
        System.out.println(new N413_ArithmeticSlices().numberOfArithmeticSlices(new int[]{1,2,3,4}));
    }

    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length < 3) return 0;
        // 状态的定义：遍历整个数组
        int[] dp = new int[A.length];
        int sum = 0;
        for (int i = 2; i < A.length; i++) {
            // 转换的方程：如果当前项可以与前面三项组成等差队列，则意味着：
            // 有一个新的长度为 3的等差数列{[i - 2], [i - 1], i}，以及所有在[i - 1]处成立的等差数列都可以组成新的等差数列
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                dp[i] = dp[i - 1] + 1;
                sum += dp[i];
            }
        }
        return sum;
    }
}
