package Page1;

import java.util.ArrayList;
import java.util.List;

/*
* 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
2：abc 3：def
4：ghi 5：jkl 6：mno
7：pqrs 8：tuv 9：wxyz
输入："23"
输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
* */
public class N17_LetterCombinationsOfAPhoneNumber {

    public static void main(String[] args) {
        List<String> a = letterCombinations("23");
        for (String d : a
             ) {
            System.out.print(d + " ");
        }
    }

    private static List<String> letterCombinations(String digits) {
        List<String> lists = new ArrayList<>();
        if (digits == null || digits.length() == 0) return lists;
        char[] chars = new char[digits.length()];
        letterCombinations(lists, chars, digits);
        return lists;
    }

    private static void letterCombinations(List<String> strings, char[] chars, String digits) {
        if (digits.length() == 0) {
            strings.add(new String(chars));
            return;
        }
        char[] values = change(digits.substring(0, 1));
        for (char v : values
             ) {
            chars[chars.length - digits.length()] = v;
            letterCombinations(strings, chars, digits.substring(1));
        }
    }

    // 数字转成对应的字母
    private static char[] change(String s) {
        switch (s) {
            case "2" : return new char[]{'a', 'b', 'c'};
            case "3" : return new char[]{'d', 'e', 'f'};
            case "4" : return new char[]{'g', 'h', 'i'};
            case "5" : return new char[]{'j', 'k', 'l'};
            case "6" : return new char[]{'m', 'n', 'o'};
            case "7" : return new char[]{'p', 'q', 'r', 's'};
            case "8" : return new char[]{'t', 'u', 'v'};
            default : return new char[]{'w', 'x', 'y', 'z'};
        }
    }
}
