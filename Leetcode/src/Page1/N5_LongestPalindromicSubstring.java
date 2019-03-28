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
        System.out.println(longestPalindrome_("ccc"));


//        System.out.println(new N5_LongestPalindromicSubstring().longestPalindrome1("babad"));
//        System.out.println(new N5_LongestPalindromicSubstring().longestPalindrome1("babad"));
//        System.out.println(new N5_LongestPalindromicSubstring().longestPalindrome1("cbbd"));
//        System.out.println(new N5_LongestPalindromicSubstring().longestPalindrome1("cbbd"));
//        System.out.println(new N5_LongestPalindromicSubstring().longestPalindrome1("ccc"));
//        System.out.println(new N5_LongestPalindromicSubstring().longestPalindrome1("cccc"));
    }


    private static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
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
        return i >= 0 && j < s.length() && s.substring(i , i + 1).equals(s.substring(j, j + 1));
    }

    private static boolean check_(int i, int j, String s) {
        if (i < 0 || j >= s.length()) {
            return false;
        }
        StringBuilder sb = new StringBuilder(s.substring(i, j + 1));
        String temp = sb.reverse().toString();
        return temp.equals(s.substring(i, j + 1));
    }

    // 稍快的解法
    // 节省代码量，可以将判断的部分提成方法，然后传值是偶数的中间值为 “”即可
    private static String longestPalindrome_(String s) {
        if (s == null || s.length() == 0) return "";
        int left = 0, right = 0;
        String oddString = "", evenString = "";
        // 如果回文字串为奇数
        for (int i = 0; i < s.length(); i++) {
            left = i - oddString.length() / 2;
            right = i + oddString.length() / 2;
            // 判断以当前节点为中心，以当前最长长度为长度的字串是否为回文序列
            // 若不是，则无需再对该点进行判断
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





//    // 尝试用动态规划，但 “ccc” 这种暂时没办法解决
//    private String longestPalindrome1(String s) {
//        if (s == null || s.length() == 0) return "";
//        // 0：代表以第i点为结尾的最长的奇数长度的回文串
//        // 1：代表以第i点位结尾的最长的偶数长度的回文串
//        int[][] dp = new int[s.length()][2];
//        int start = 0, max = 1;
//        dp[0][0] = 1;
//        for (int i = 1; i < s.length(); i++) {
//            dp[i][0] = 1;
//            if (i - dp[i - 1][0] - 1 >= 0 && s.charAt(i) == s.charAt(i - dp[i - 1][0] - 1)) {
//                dp[i][0] = dp[i - 1][0] + 2;
//            }
//            if (i - dp[i - 1][1] - 1 >= 0 && s.charAt(i) == s.charAt(i - dp[i - 1][1] - 1)) {
//                dp[i][1] = dp[i - 1][1] + 2;
//            }
//            if (s.charAt(i) == s.charAt(i - 1) && dp[i][1] == 0) {
//                dp[i][1] = 2;
//            }
//            int iMax = Math.max(dp[i][0], dp[i][1]);
//            if (iMax > max) {
//                max = iMax;
//                start = i - max + 1;
//            }
//        }
////        for (int i = 0; i < s.length(); i++) {
////            System.out.println(dp[i][0] + "  " + dp[i][1]);
////        }
//        return s.substring(start, start + max);
//    }
}
