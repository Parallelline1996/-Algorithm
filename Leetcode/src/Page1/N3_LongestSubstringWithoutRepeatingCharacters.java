package Page1;

import java.util.HashSet;
import java.util.Set;

/*
* Given a string, find the length of the longest substring without repeating characters.

Example 1:
Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:
Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
* */
public class N3_LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("jbpnbwwd"));
    }

    private static int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        int max = 0;
        Set<Character> characters = new HashSet<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length() - max; i++) {
            for (int j = i; j < s.length(); j++) {
                if (!characters.contains(chars[j])) {
                    characters.add(chars[j]);
                } else {
                    if (max < characters.size()) {
                        max = characters.size();
                    }
                    characters.clear();
                    break;
                }
            }
        }
        if (max < characters.size()) {
            max = characters.size();
        }
        return max;
    }

    // 较好的解法
    public int lengthOfLongestSubstring_(String s) {
        int start = 0;
        int result = 0;
        boolean[] map = new boolean[256];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map[c]) {
                map[c] = true;
            } else {
                while (map[c]) {
                    map[s.charAt(start)] = false;
                    start++;
                }
                map[c] = true;
            }
            result = Math.max(result, i - start + 1);
        }
        return result;
    }
}
