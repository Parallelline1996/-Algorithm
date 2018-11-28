package Page7;

/*
* 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
* 示例 1:
* 输入: 2
* 输出: [0,1,1]
* 示例 2:
* 输入: 5
* 输出: [0,1,1,2,1,2]
* */
public class N338_CountingBits {

    public static void main(String[] args) {
        int[] a = countBits(2);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();

        a = countBits(5);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();

        a = countBits(8);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    private static int[] countBits(int num) {
        if (num == 0) {
            return new int[]{0};
        }
        int[] dp = new int[num + 1];
        for (int i = 1, j = 2; i <= j && i <= num; i++) {
            if (i == j) {
                j *= 2;
                dp[i] = 1;
                continue;
            }
            dp[i] = dp[i - (j >> 1)] + 1;
        }
        return dp;
    }
}
