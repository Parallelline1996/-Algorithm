package niuke;

import java.util.ArrayList;

public class Main2 {

    /*
    * 输出所有可能的解 -> 往往是深度优先
    * 输出最优的解 -> 动态递归
    * */

    /*
    * Given a string s, partition s such that every substring of the
    * partition is a palindrome.
    * Return all possible palindrome partitioning of s.
    * For example, given s ="aab",
    * Return
    * [{"aa", "b"}, {"a", "a", "b"}]
    * */


    /*
    * 测试用例:
"cdd"

对应输出应该为:

[["c","d","d"],["c","dd"]]

你的输出为:

[["c","dd"],["c","d","d"]]
    * */
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> output = new ArrayList<>();
        ArrayList<String> arrayList = new ArrayList<>();
        if (s.length() == 1) {
            arrayList.add(s);
            output.add(arrayList);
            return output;
        }
        dfs(s, output, arrayList);
        if (isPalindrome(s)) {
            arrayList.add(s);
            output.add(arrayList);
        }
        return output;
    }

    private static void dfs(String s, ArrayList<ArrayList<String>> output,
                            ArrayList<String> arrayList) {
        for (int i = 1; i < s.length(); i++) {
            String temp = s.substring(0, i);
            if (isPalindrome(temp)) {
                arrayList.add(temp);
                // 重点在这里怎么判断遍历到结尾了
                if (isPalindrome(s.substring(i, s.length()))) {
                    arrayList.add(s.substring(i, s.length()));
                    output.add(new ArrayList<>(arrayList));
                    arrayList.remove(arrayList.size() - 1);
                }
                dfs(s.substring(i, s.length()), output, arrayList);
                arrayList.remove(arrayList.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String data) {
        if (data == null || data.length() == 1) {
            return true;
        }
        StringBuilder stringBuilder = new StringBuilder(data);
        return data.equals(stringBuilder.reverse().toString());
    }
}
