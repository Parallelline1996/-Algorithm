package Page1;

/*
* The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.

Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.

Note: Each term of the sequence of integers will be represented as a string.



Example 1:

Input: 1
Output: "1"
Example 2:

Input: 4
Output: "1211"
* */
public class N38_CountAndSay {

    public static void main(String[] args) {

    }

    /*
    * 思路：
    * 暴力解法，一点点向后数
    * */
    private static String countAndSay(int n) {
        if (n <= 0) {
            return null;
        }
        String[] strs = new String[n];
        strs[0] = "1";
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        char ch;
        for (int i = 1; i < n; i++) {
            ch = strs[i - 1].charAt(0);
            for (int j = 0; j < strs[i - 1].length(); j++) {
                // 前后不同的情况
                if (strs[i - 1].charAt(j) != ch) {
                    sb.append(sum).append(ch);
                    ch = strs[i - 1].charAt(j);
                    sum = 1;
                } else {
                    sum++;
                }
                // 当遍历到末尾的情况
                if (j == strs[i - 1].length() - 1) {
                    sb.append(sum).append(ch);
                }
            }
            strs[i] = sb.toString();
            sb.delete(0, sb.length());
            sum = 0;
        }
        return strs[n - 1];
    }
}
