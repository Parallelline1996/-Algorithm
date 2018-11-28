package Page2;

/*
* 实现 int sqrt(int x) 函数。
* 计算并返回 x 的平方根，其中 x 是非负整数。
* 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
*
* 思路：用二分法，从 1 ~ x 不断逼进中间的答案
* */
public class N69_Sqrt {

    public static void main(String[] args) {
        System.out.println(mySqrt(11));
        System.out.println(mySqrt(20));
        System.out.println(mySqrt(16));
        System.out.println(mySqrt(2147395599));
        System.out.println(mySqrt(4));
        System.out.println(46339 * 46339);
    }

    private static int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        if (x < 4) {
            return 1;
        }
        int left = 1, right = x, mid;
        // 这里要用除法，用乘法容易超过Integer的范围
        while (x / left > left && x / right < right && right > left + 1) {
            mid = (left + right) / 2;
            if (x / mid == mid) {
                return mid;
            } else if (x / mid < mid) {
                right = mid;

            } else {
                left = mid;
            }
        }
        return left;
    }
}
