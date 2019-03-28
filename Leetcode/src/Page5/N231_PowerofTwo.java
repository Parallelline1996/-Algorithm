package Page5;

/*
* Given an integer, write a function to determine if it is a power of two.

Example 1:
Input: 1
Output: true
Explanation: 20 = 1

Example 2:
Input: 16
Output: true
Explanation: 24 = 16

Example 3:
Input: 218
Output: false
* */
public class N231_PowerofTwo {

    public static void main(String[] args) {
        System.out.println(new N231_PowerofTwo().isPowerOfTwo(1));
        System.out.println(new N231_PowerofTwo().isPowerOfTwo(16));
        System.out.println(new N231_PowerofTwo().isPowerOfTwo(218));
    }

    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
