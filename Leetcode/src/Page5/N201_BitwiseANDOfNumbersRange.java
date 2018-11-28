package Page5;

import static java.lang.StrictMath.log;

/*
* Given a range [m, n] where 0 <= m <= n <= 2147483647,
* return the bitwise AND of all numbers in this range, inclusive.

Example 1:
Input: [5,7]
Output: 4

Example 2:
Input: [0,1]
Output: 0
* */
public class N201_BitwiseANDOfNumbersRange {

    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd(5, 7));
        System.out.println(rangeBitwiseAnd(0, 1));
        System.out.println(rangeBitwiseAnd(0, 0));
    }

    // 思路：算出范围的第一个数和最后一个数，是否在同一个2的倍数下，如果是，则说明 2的x次方那个位全部为1
    // 然后减去那个位，继续往下进行判断
    private static int rangeBitwiseAnd(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }
        int num = (int)(Math.log(n) / Math.log(2));
        int k = (int)Math.pow(2, num);
        if (m < k) {
            return 0;
        }
        return k + rangeBitwiseAnd(m - k, n - k);
    }
}
