package Page2;

/*
* 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
* 如果不存在最后一个单词，请返回 0 。
* */
public class N58_LengthOfLastWord {

    public static void main(String[] args) {
        String temp = " hello";
        System.out.println(lengthOfLastWord(temp));
        System.out.println(lengthOfLastWord("h l"));
        System.out.println(lengthOfLastWord("hl "));
        System.out.println(lengthOfLastWord("      "));
        System.out.println(lengthOfLastWord("a"));
        System.out.println(lengthOfLastWord("a "));
    }

    private static int lengthOfLastWord(String s) {
        if (s == null) {
            return 0;
        }
        if (!s.contains(" ")) {
            return s.length();
        }
        String[] temp = s.split(" ");
        return (temp.length < 1)? 0: temp[temp.length - 1].length();
    }
}
