package Page5;

import java.util.HashSet;
import java.util.Set;

/*
* Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer,
replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1
(where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy numbers.

Example:

Input: 19
Output: true
Explanation:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
* */
public class N202_HappyNumber {

    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }

    // 用 set 来判断是否成无限循环且不为 1
    private static boolean isHappy(int n) {
        if (n <= 0) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        int k = n;
        while (k != 1) {
            k = calculate(k);
            if (set.contains(k)) {
                return false;
            } else {
                set.add(k);
            }
        }
        return true;
    }

    private static int calculate(int num) {
        int output = 0;
        while (num != 0) {
            int k = num % 10;
            output += k * k;
            num /= 10;
        }
        return output;
    }

    // 相当于后面的无限循环成圈，用两个指针来遍历，一个 2步一个 1步，看什么时候相碰
    public boolean isHappy1(int n) {
        int slow = n, fast = n;
        do {
            slow = sumOfSquares(slow);
            fast = sumOfSquares(fast);
            fast = sumOfSquares(fast);
        } while (slow != fast);
        return slow == 1;
    }

    private int sumOfSquares(int n) {
        int res = 0;
        while (n != 0) {
            res += (n % 10) * (n % 10);
            n /= 10;
        }
        return res;
    }
}
