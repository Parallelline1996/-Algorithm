package Page1;

/*
* 编写一个函数来查找字符串数组中的最长公共前缀。
* 如果不存在公共前缀，返回空字符串 ""。
* */
public class N14_LongestCommonPrefix {

    public static void main(String[] args) {
        String[] a = new String[]{"flower", "flow", "flight"};
        String[] b = new String[]{"dog", "racecar", "car"};
        String[] c = new String[]{};
        String[] d = new String[1];
        System.out.println(longestCommonPrefix(a));
        System.out.println(longestCommonPrefix(b));
        System.out.println(longestCommonPrefix(c));
        System.out.println(longestCommonPrefix(d));
        System.out.println(longestCommonPrefix_(a));
        System.out.println(longestCommonPrefix_(b));
        System.out.println(longestCommonPrefix_(c));
        System.out.println(longestCommonPrefix_(d));
    }

    // 31%
    private static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
//            return strs[0] == null? "": strs[0];
            return strs[0];
        }
        boolean mark = true;
        int length = 0;
        int i = 0;
        for (; i < strs[0].length() && mark; i++) {
            String cur = strs[0].substring(i, i + 1);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() < i + 1 || !strs[j].substring(i, i + 1).equals(cur)) {
                    mark = false;
                    break;
                }
            }
        }
        return mark? strs[0]: strs[0].substring(0, i - 1);
    }

    // 87%
    private static String longestCommonPrefix_(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        int length = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() >= length) {
                if (!strs[i].substring(0, length).equals(strs[0].substring(0, length))) {
                    length--;
                    i--;
                }
            } else {
                length = strs[i].length();
                i--;
            }
        }
        return strs[0].substring(0, length);
    }
}
