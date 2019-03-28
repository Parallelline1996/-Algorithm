package Page12;

/*
* Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1.
* In other words, one of the first string's permutations is the substring of the second string.
Example 1:
Input:s1 = "ab" s2 = "eidbaooo"
Output:True
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:
Input:s1= "ab" s2 = "eidboaoo"
Output: False
Note:
The input strings only contain lower case letters.
The length of both given strings is in range [1, 10,000].
* */
public class N567_PermutationinString {

    public static void main(String[] args) {
//        System.out.println(new N567_PermutationinString().checkInclusion("ab", "eidbaooo"));
//        System.out.println(new N567_PermutationinString().checkInclusion("ab", "eidboaoo"));
//        System.out.println(new N567_PermutationinString().checkInclusion("h", "jrfrspuz"));
        System.out.println(new N567_PermutationinString().checkInclusion("adc", "dcda"));
        System.out.println(new N567_PermutationinString().checkInclusion("ab", "ba"));
    }

    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null) return false;
        if (s1.length() > s2.length()) return false;

        int[] S1 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            S1[s1.charAt(i) - 'a']++;
        }
        int length = 0;
        for (int i = 0; i < s2.length(); i++) {
            if (S1[s2.charAt(i) - 'a'] != 0) {
                S1[s2.charAt(i) - 'a']--;
                length++;
                if (length >= s1.length()) {
                    return true;
                }
            } else {
                for (int k = 1; k <= length; k++) {
                    S1[s2.charAt(i - k) - 'a']++;
                }
                i = i - length;
                length = 0;
            }
        }
        return false;
    }
}
