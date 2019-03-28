package Page8;


/*
* Given a positive integer num, write a function which returns True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:
Input: 16
Output: true

Example 2:
Input: 14
Output: false
* */
public class N367_ValidPerfectSquare {

    public static void main(String[] args) {
        System.out.println(new N367_ValidPerfectSquare().isPerfectSquare(14));
        System.out.println(new N367_ValidPerfectSquare().isPerfectSquare(16));
        System.out.println(new N367_ValidPerfectSquare().isPerfectSquare(18));
        System.out.println(new N367_ValidPerfectSquare().isPerfectSquare(144));
        System.out.println(new N367_ValidPerfectSquare().isPerfectSquare(255));
        System.out.println(new N367_ValidPerfectSquare().isPerfectSquare(1));
        System.out.println(new N367_ValidPerfectSquare().isPerfectSquare(2));
    }


    public boolean isPerfectSquare(int num) {
        if (num < 0) return false;
        if (num <= 1) return true;
        int mid, left = 0, right = num;
        while (left < right) {
            mid = (left + right) / 2;
            if (num / mid == mid) {
                if (num == mid * mid) {
                    return true;
                } else {
                    break;
                }
            } else if (num / mid > mid) {
                left = mid;
            } else {
                right = mid;
            }

            if ((left == right || (left == right - 1)) && num / left != left) {
                break;
            }
        }
        return false;
    }
}
