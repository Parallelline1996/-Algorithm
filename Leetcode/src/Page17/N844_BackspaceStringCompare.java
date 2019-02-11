package Page17;

/*
* Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

Example 1:
Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".

Example 2:
Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".

Example 3:
Input: S = "a##c", T = "#a#c"
Output: true
Explanation: Both S and T become "c".

Example 4:
Input: S = "a#c", T = "b"
Output: false
Explanation: S becomes "c" while T becomes "b".
Note:

1 <= S.length <= 200
1 <= T.length <= 200
S and T only contain lowercase letters and '#' characters.
Follow up:

Can you solve it in O(N) time and O(1) space?
* */
public class N844_BackspaceStringCompare {

    public boolean backspaceCompare(String S, String T) {
        if (S == null || T == null) return false;
        // 从后面开始向前遍历
        for (int i = S.length() - 1, j = T.length() - 1; ; i--, j--) {
            // 遍历判断是否有删除键，有删除键则向前走一位，这里注意多个删除键叠在一起的情况
            for (int k = 0; i >= 0 && (k > 0 || S.charAt(i) == '#'); i--) {
                k += S.charAt(i) == '#'? 1: -1;
            }
            for (int k = 0; j >= 0 && (k > 0 || T.charAt(j) == '#'); j--) {
                k += T.charAt(j) == '#'? 1: -1;
            }
            // 如果两个字符串完全相同，最后两个下标都指向 -1
            if (i < 0 || j < 0 || S.charAt(i) != T.charAt(j)) {
                return i == -1 && j == -1;
            }
        }
    }
}
