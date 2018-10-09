package Page1;

/*
* 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。
* */
public class N5_LongestPalindromicSubstring {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome_("babad"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome_("cbbd"));
    }

    private static String longestPalindrome(String s) {
        if (s == null) {
            return null;
        }
        int left = 0, right = 0;
        String oddString = "", evenString = "";
        // 如果回文字串为奇数
        for (int i = 0; i < s.length(); i++) {
            left = i - 1;
            right = i + 1;
            while (check(left, right, s)) {
                left--;
                right++;
            }
            if (oddString.length() < (right - i - 1) * 2 + 1) {
                oddString = s.substring(left + 1, right);
            }
        }

        // 如果回文字串为偶数
        for (int i = 0; i < s.length() - 1; i++) {
            if (!check(i, i + 1, s)) {
                continue;
            }
            left = i - 1;
            right = i + 2;
            while (check(left, right, s)) {
                left--;
                right++;
            }
            if (evenString.length() < (right - i - 1) * 2) {
                evenString = s.substring(left + 1, right);
            }
        }
        return oddString.length() > evenString.length()? oddString: evenString;
    }

    private static boolean check(int i, int j, String s) {
        if (i < 0 || j >= s.length()) {
            return false;
        }
        return s.substring(i , i + 1).equals(s.substring(j, j + 1));
    }

    private static boolean check_(int i, int j, String s) {
        if (i < 0 || j >= s.length()) {
            return false;
        }
        StringBuilder sb = new StringBuilder(s.substring(i, j + 1));
        String temp = sb.reverse().toString();
        return temp.equals(s.substring(i, j + 1));
    }

    private static String longestPalindrome_(String s) {
        if (s == null) {
            return null;
        }
        int left = 0, right = 0;
        String oddString = "", evenString = "";
        // 如果回文字串为奇数
        for (int i = 0; i < s.length(); i++) {
            left = i - oddString.length() / 2;
            right = i + oddString.length() / 2;
            if (!check_(left, right, s)) {
                continue;
            }
            while (check(left, right, s)) {
                left--;
                right++;
            }
            if (oddString.length() < (right - i - 1) * 2 + 1) {
                oddString = s.substring(left + 1, right);
            }
        }

        // 如果回文字串为偶数
        for (int i = 0; i < s.length() - 1; i++) {
            if (!check(i, i + 1, s)) {
                continue;
            }
            left = i - evenString.length() / 2;
            right = i + evenString.length() / 2 + 1;
            if (!check_(left, right, s)) {
                continue;
            }
            while (check(left, right, s)) {
                left--;
                right++;
            }
            if (evenString.length() < (right - i - 1) * 2) {
                evenString = s.substring(left + 1, right);
            }
        }
        return oddString.length() > evenString.length()? oddString: evenString;
    }
}
