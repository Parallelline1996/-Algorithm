package Page1;

/*
* Implement pow(x, n), which calculates x raised to the power n (xn).

Example 1:

Input: 2.00000, 10
Output: 1024.00000
Example 2:

Input: 2.10000, 3
Output: 9.26100
Example 3:

Input: 2.00000, -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25
Note:

-100.0 < x < 100.0
n is a 32-bit signed integer, within the range [−231, 231 − 1]
* */
public class N50_Pow {

    public static void main(String[] args) {
        N50_Pow Main = new N50_Pow();
        System.out.println(Main.myPow(2.00000, 10));
        System.out.println(Main.myPow(2.10000, 3));
        System.out.println(Main.myPow(2.00000, -2));
//        System.out.println(Main.myPow(2.00000, 214748364));
        System.out.println(Main.myPow(2.00000, -2147483648));
    }


    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n > 0) {
            return helper(x, n);
        } else if (n == Integer.MIN_VALUE) {
            return myPow(x * x, n / 2);
        } else {
            double temp = helper(x, -n);
//            System.out.println("temp" + temp);
//            System.out.println("1/temp" + 1 / temp);
            return 1 / temp;
        }
    }

    private double helper(double x, int n) {
        if (n == 0) return 1.0;
        if (n == 1) return x;
        double result = helper(x, n >> 1);
        result *= result;
        if (n % 2 == 1) result *= x;
        return result;
    }
}
