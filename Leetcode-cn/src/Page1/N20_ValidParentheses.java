package Page1;

import java.util.Stack;

public class N20_ValidParentheses {

    public static void main(String[] args) {
        System.out.println(isValid("{}"));
        System.out.println(isValid("()"));
        System.out.println(isValid("{()}"));
        System.out.println(isValid("}"));
        System.out.println(isValid("["));
    }

    private static boolean isValid(String s) {
        if (s == null) {
            return true;
        }
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char a : chars
             ) {
            if (a == '(' || a == '[' || a == '{') {
                stack.add(a);
            } else {
                if (stack.isEmpty() || stack.pop() != pair(a)) {
                    return false;
                }
            }
        }
        // 这里要判断堆栈是否为空
        return stack.isEmpty();
    }

    private static char pair(char c) {
        if (c == ')') {
            return '(';
        } else if (c == '}') {
            return '{';
        } else {
            return '[';
        }
    }
}
