package Page1;

public class N38_CountAndSay {

    public static void main(String[] args) {

    }

    private static String countAndSay(int n) {
        if (n <= 0) {
            return null;
        }
        String[] strs = new String[n];
        strs[0] = "1";
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        char ch;
        for (int i = 1; i < n; i++) {
            ch = strs[i - 1].charAt(0);
            for (int j = 0; j < strs[i - 1].length(); j++) {
                // 前后不同的情况
                if (strs[i - 1].charAt(j) != ch) {
                    sb.append("" + sum + ch);
                    ch = strs[i - 1].charAt(j);
                    sum = 1;
                } else {
                    sum++;
                }
                // 当遍历到末尾的情况
                if (j == strs[i - 1].length() - 1) {
                    sb.append("" + sum + ch);
                }
            }
            strs[i] = sb.toString();
            sb.delete(0, sb.length());
            sum = 0;
        }
        return strs[n - 1];
    }
}
