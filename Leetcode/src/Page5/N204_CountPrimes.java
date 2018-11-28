package Page5;

/*
 * Count the number of prime numbers less than a non-negative number, n.
Example:
Input: 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 * */
public class N204_CountPrimes {

    public static void main(String[] args) {
        System.out.println(countPrimes(10));
        System.out.println(countPrimes(2));
    }

    // 注意这里是 less than，没有包括 n值，
    // 从 2开始遍历整个数组，当遇到一个值不为 true时，这个值为质数，将这个数的倍数全部置为 true
    private static int countPrimes(int n) {
        if (n <= 1) {
            return 0;
        }
        boolean[] index = new boolean[n];
        int output = 0;
        for (int i = 2; i < n; i++) {
            if (!index[i]) {
                output++;
                for (int j = 2; j * i < n; j++) {
                    index[j * i] = true;
                }
            }
        }
        return output;
    }
}
