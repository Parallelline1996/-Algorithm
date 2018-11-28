package Page15;

/*
* 实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串
* */
public class N709_ToLowerCase {

    public static void main(String[] args) {
        System.out.println(toLowerCase("fff"));
        System.out.println(toLowerCase("SDFIjfidD"));
        System.out.println(toLowerCase("DdffdD"));
    }
    /*
    * A : 65
    * a : 97
    * */
    private static String toLowerCase(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] <= 'Z' && chars[i] >= 'A') {
                chars[i] = (char)(chars[i] + 32);
            }
        }
        return new String(chars);
    }
}
