package Page1;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
* Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:
Input: "()"
Output: true

Example 2:
Input: "()[]{}"
Output: true

Example 3:
Input: "(]"
Output: false

Example 4:
Input: "([)]"
Output: false

Example 5:
Input: "{[]}"
Output: true


* */
public class N20_ValidParentheses {

    public static void main(String[] args) {
        System.out.println(isValid("{}"));
        System.out.println(isValid("()"));
        System.out.println(isValid("{()}"));
        System.out.println(isValid("}"));
        System.out.println(isValid("["));
    }

    private static boolean isValid(String s) {
        if (s == null) return true;
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char a : chars
                ) {
            // 如果是左边的括号，则压入栈内
            if (a == '(' || a == '[' || a == '{') {
                stack.add(a);
            } else {
                // 如果是右边的括号，则出栈判断是否正确
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

    // 用map的思路，但Leetcode 运行结果不如上面的
    private boolean isValid1(String s) {
        if (s == null) return true;
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : chars
             ) {
            if (!map.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty() || map.get(c) != stack.pop()) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
