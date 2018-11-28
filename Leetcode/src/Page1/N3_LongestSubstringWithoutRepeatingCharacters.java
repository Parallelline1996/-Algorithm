package Page1;

import java.util.HashSet;
import java.util.Set;

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
}
