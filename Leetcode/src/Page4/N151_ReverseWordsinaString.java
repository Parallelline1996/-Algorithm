package Page4;

import java.util.ArrayList;

/*
* Given an input string, reverse the string word by word.



Example 1:

Input: "the sky is blue"
Output: "blue is sky the"

Example 2:
Input: "  hello world!  "
Output: "world! hello"
Explanation: Your reversed string should not contain leading or trailing spaces.

Example 3:
Input: "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.

Note:

A word is defined as a sequence of non-space characters.
Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
You need to reduce multiple spaces between two words to a single space in the reversed string.
* */
public class N151_ReverseWordsinaString {

    public static void main(String[] args) {
//        System.out.println(new N151_ReverseWordsinaString().reverseWords("the sky is blue"));
//        System.out.println(new N151_ReverseWordsinaString().reverseWords("  hello world!  "));
//        System.out.println(new N151_ReverseWordsinaString().reverseWords("a good   example"));
        System.out.println(new N151_ReverseWordsinaString().reverseWords("a"));
    }

    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return s;
        int begin = -1;
        ArrayList<String> lists = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (begin == -1 && s.charAt(i) != ' ') {
                begin = i;
            } else if (begin != -1 && s.charAt(i) == ' ') {
                lists.add(s.substring(begin, i));
                begin = -1;
            }
        }
        if (begin != -1) {
            lists.add(s.substring(begin));
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < lists.size(); i++) {
            sb.append(lists.get(lists.size() - i));
            sb.append(" ");
        }
        if (lists.size() > 0) {
            sb.append(lists.get(0));
        }
        return sb.toString();
    }

}
