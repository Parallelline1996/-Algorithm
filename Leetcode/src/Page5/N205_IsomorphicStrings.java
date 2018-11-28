package Page5;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

/*
* 给定两个字符串 s 和 t，判断它们是否是同构的。
如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。

示例 1:
输入: s = "egg", t = "add"
输出: true

示例 2:
输入: s = "foo", t = "bar"
输出: false

示例 3:
输入: s = "paper", t = "title"
输出: true

说明:
你可以假设 s 和 t 具有相同的长度
* */
public class N205_IsomorphicStrings {

    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add"));
        System.out.println(isIsomorphic("foo", "bar"));
        System.out.println(isIsomorphic("paper", "title"));
        System.out.println(isIsomorphic("aba", "fff"));
        System.out.println(isIsomorphic_("aba", "fff"));
    }

    private static boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        Hashtable<Character, Character> hashtable = new Hashtable<>();
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (hashtable.containsKey(sChars[i])) {
                if (tChars[i] != hashtable.get(sChars[i])) {
                    return false;
                }
            } else {
                if (set.contains(tChars[i])) {
                    return false;
                }
                set.add(tChars[i]);
                hashtable.put(sChars[i], tChars[i]);
            }
        }
        return true;
    }

    // 取 256 是因为 ASCII 码的长度为256
    private static boolean isIsomorphic_(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        char[] chas1 = s.toCharArray();
        char[] chas2 = t.toCharArray();
        int[] map = new int[512];
        for (int i = 0; i < chas1.length; i++) {
            // 判断对应字符指向的数组下标是否已被修改，判断是否出现a指向b，c也指向b的情况
            if (map[chas1[i]] != map[chas2[i] + 256]) {
                return false;
            }
            map[chas1[i]] = map[chas2[i] + 256] = i + 1;
        }
        return true;
    }
}
