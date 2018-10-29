package Page1;

import java.util.Stack;

/*
* 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
* */
public class N32_LongestValidParentheses {

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(()"));
        System.out.println(longestValidParentheses(")()())"));
        System.out.println(longestValidParentheses("()(()"));
    }

    // 非动态规划解法：
    private static int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int maxTotalLength = 0, localLength = 0, leftNumber = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (chars[i] == '(') {
                leftNumber++;
                localLength++;
            } else {
                leftNumber--;
                if (leftNumber < 0) {
                    maxTotalLength = Math.max(maxTotalLength, localLength);
                    leftNumber = 0;
                    localLength = 0;
                } else {
                    localLength++;
                }
            }
        }
        if (localLength > 0 && leftNumber > 0) {
            return Math.max(maxTotalLength, check(s.substring(s.length() - localLength)));
        }
        return Math.max(maxTotalLength, localLength - leftNumber);
    }

    private static int check(String s) {
        char[] chars = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (chars[i] == '('){
                stack.push(i);
            } else {
                stack.pop();
            }
        }
        int a = stack.pop();
        int max = s.length() - a - 1;
        while (!stack.isEmpty()) {
            max = Math.max(a - stack.peek() - 1, max);
            a = stack.pop();
        }
        return Math.max(max, a);
    }
}
