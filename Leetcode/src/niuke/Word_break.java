package niuke;

import java.util.HashSet;
import java.util.Set;

/*
* Given a string s and a dictionary of words dict, determine if s can be segmented into
* a space-separated sequence of one or more dictionary words.
* For example, given
* s ="leetcode",
* dict =["leet", "code"].
* Return true because"leetcode"can be segmented as"leet code"
* */
public class Word_break {

    public static void main(String[] args) {
        String s = "leetcode";
        Set<String> strings = new HashSet<>();
        strings.add("leet");
        strings.add("code");
        System.out.println(wordBreak(s, strings));
    }

    private static boolean wordBreak(String s, Set<String> dict) {
        if (s == null || dict == null) {
            return false;
        }
        boolean[] arrays = new boolean[s.length() + 1];
        arrays[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (arrays[j] && dict.contains(s.substring(j, i))) {
                    arrays[i] = true;
                    break;
                }
            }
        }
        return arrays[s.length()];
    }
}
