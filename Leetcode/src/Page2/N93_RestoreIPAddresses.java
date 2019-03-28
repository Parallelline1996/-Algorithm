package Page2;

import java.util.ArrayList;
import java.util.List;

/*
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

        Example:

        Input: "25525511135"
        Output: ["255.255.11.135", "255.255.111.35"]

      */

public class N93_RestoreIPAddresses {

    public static void main(String[] args) {
        System.out.println(new N93_RestoreIPAddresses().restoreIpAddresses("25525511135").toString());
        System.out.println(new N93_RestoreIPAddresses().restoreIpAddresses("010010").toString());

    }


    public List<String> restoreIpAddresses(String s) {
        List<String> lists = new ArrayList<>();
        if (s == null || s.length() == 0 || s.length() > 12 || s.length() < 4) return lists;
        for (int firstEnd = 0; firstEnd <= s.length() - 4; firstEnd++) {
            if (firstEnd > 2) break;
            for (int secondEnd = firstEnd + 1; secondEnd <= s.length() - 3; secondEnd++) {
                if (secondEnd - firstEnd > 3) break;
                for (int thirdEnd = secondEnd + 1; thirdEnd <= s.length() - 2; thirdEnd++) {
                    if (thirdEnd - secondEnd > 3 || s.length() - thirdEnd > 4) continue;
                    if (helper(s, firstEnd, secondEnd, thirdEnd)) {
                        lists.add(buildString(new StringBuilder(), s, firstEnd, secondEnd, thirdEnd));
                    }
                }
            }
        }
        return lists;
    }

    private String buildString(StringBuilder sb, String s, int firstEnd, int secondEnd, int thirdEnd) {
        sb.append(s.substring(0, firstEnd + 1)).append(".")
                .append(s.substring(firstEnd + 1, secondEnd + 1)).append(".")
                .append(s.substring(secondEnd + 1, thirdEnd + 1)).append(".")
                .append(s.substring(thirdEnd + 1));
        return sb.toString();
    }

    // 这里其实拆分成判断每一段是否合法，代码看起来会容易一些
    private boolean helper(String s, int firstEnd, int secondEnd, int thirdEnd) {
        String first = s.substring(0, firstEnd + 1);
        if (first.length() > 1 && first.charAt(0) == '0') return false;
        String second = s.substring(firstEnd + 1, secondEnd + 1);
        if (second.length() > 1 && second.charAt(0) == '0') return false;
        String third = s.substring(secondEnd + 1, thirdEnd + 1);
        if (third.length() > 1 && third.charAt(0) == '0') return false;
        String forth = s.substring(thirdEnd + 1);
        if (forth.length() > 1 && forth.charAt(0) == '0') return false;
        return Integer.parseInt(first) < 256 &&
                Integer.parseInt(second) < 256 &&
                Integer.parseInt(third) < 256 &&
                Integer.parseInt(forth) < 256;
    }
}
