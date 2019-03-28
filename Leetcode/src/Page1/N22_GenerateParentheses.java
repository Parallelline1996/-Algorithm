package Page1;

import java.util.*;

/*
* 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
* 例如，给出 n = 3，生成结果为：
[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
* */
public class N22_GenerateParentheses {

    public static void main(String[] args) {
        List<String> lists = new N22_GenerateParentheses().generateParenthesis(3);
        for (String a : lists
             ) {
            System.out.print(a + "   ");
        }
    }

    private void backtrack(int max, int left, int right, List<String> lists, String cur) {
        if (cur.length() == max * 2) {
            lists.add(cur);
            return;
        }
        // 能否添加左括号，保证左括号数小于 n
        if (left < max) {
            backtrack(max, left + 1, right, lists, cur + "(");
        }
        // 能否添加右括号
        if (right < left) {
            backtrack(max, left, right + 1, lists, cur + ")");
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backtrack(n, 1, 0, list, "(");
        return list;
    }




    // 超出时间限制
    private static List<String> generateParenthesis_(int n) {
        List<String> lists = new ArrayList<>();
        if (n <= 0){
            return lists;
        }
        if (n == 1) {
            lists.add("()");
            return lists;
        }
        // 获得初始得排序
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            sb.append("()");
        }
        String k = sb.toString();

        // 全排序所有结果
        Set<String> set = new HashSet<>();
        permute(sb.toString().toCharArray(), 1, set);
        // 看看结果是否符合要求
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            k = (String)iterator.next();
//            System.out.println(k + "  dd");
            if (judge(k)) {
                lists.add(k);
//                System.out.println(k);
            }
        }
        return lists;
    }

    private static boolean judge(String a) {
        char[] chars = a.toCharArray();
        int number = 0;
        for (int i = 0; i < a.length(); i++) {
            if (chars[i] == '(') {
                number++;
            } else {
                number--;
                if (number < 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void permute(char[] chars, int start, Set<String> set) {
        if (start == chars.length - 2) {
            String temp = new String(chars);
//            System.out.println(temp);
            if (!set.contains(temp)) {
                set.add(temp);
            }
        } else {
            for (int i = start; i < chars.length; i++) {
                swap(chars, start, i);
                permute(chars, start + 1, set);
                swap(chars, start, i);
            }
        }
    }

    private static void swap(char[] chars, int i, int t) {
        char temp = chars[i];
        chars[i] = chars[t];
        chars[t] = temp;
    }
}
