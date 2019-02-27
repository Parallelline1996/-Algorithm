package Page5;

import java.util.HashMap;

/*
* Given two strings s and t , write a function to determine if t is an anagram of s.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?
*
* */
public class N242_ValidAnagram {


    public static void main(String[] args) {
        N242_ValidAnagram Main = new N242_ValidAnagram();
        String s = "anagram", t = "nagaram";
        System.out.println(Main.isAnagram(s, t));

        s = "rat";
        t = "car";
        System.out.println(Main.isAnagram(s, t));
    }

    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) return false;
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : sChars
             ) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        for (char c : tChars
             ) {
            if (map.containsKey(c) && map.get(c) > 0) {
                map.put(c, map.get(c) - 1);
            } else {
                return false;
            }
        }
        return true;
    }

    // 针对单纯的小写字母组合，这个方法会快很多
    public boolean isAnagram1(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) return false;
        int[] sArrays = new int[26];
        int[] tArrays = new int[26];
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        for (char c : sChars
             ) {
            sArrays[c - 'a']++;
        }

        for (char c : tChars
                ) {
            tArrays[c - 'a']++;
        }

        for (int i = 0; i < sArrays.length; i++) {
            if (sArrays[i] != tArrays[i]) {
                return false;
            }
        }

        return true;
    }
}
