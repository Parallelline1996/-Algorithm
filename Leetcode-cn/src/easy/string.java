package easy;


import java.util.HashMap;

public class string{

    public static void main(String[] args) {
//        System.out.println(reverse(-2141));

//        System.out.println(firstUniqChar("leetcode"));
//        System.out.println(firstUniqChar("loveleetcode"));
//        System.out.println(firstUniqChar("ff"));

        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

    /*
    * 编写一个函数，其作用是将输入的字符串反转过来。
    * */
    public String reverseString(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        return stringBuilder.reverse().toString();
    }

    /*
    * 给定一个 32 位有符号整数，将整数中的数字进行反转
    * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31,  2^31 − 1]。根据这个假设，如果反转后的整数溢出，则返回 0。
    * */
    private static int reverse(int x) {
        StringBuilder stringBuilder = new StringBuilder(Integer.toString(x));
        String temp = null;
        if (x < 0) {
            temp = stringBuilder.reverse().toString().substring(0, stringBuilder.length() - 1);
        } else {
            temp = stringBuilder.reverse().toString();
        }
        int output = 0;
        try {
            output = Integer.parseInt(temp);
        } catch (Exception e) {
            return 0;
        }
        if (x < 0) {
            output = 0 - output;
        }
        return output;
    }

    /*
    * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1
    * */
    private static int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char a : chars
             ) {
            if (map.containsKey(a)) {
                map.put(a, -1);
            } else {
                map.put(a, 1);
            }
        }
        int output = -1;
        for (int i = 0; i < s.length(); i++) {
            if (map.get(chars[i]) != -1) {
                output = i;
                break;
            }
        }
        return output;
    }

    /*
    * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
    * */
    public boolean isAnagram(String s, String t) {
        return false;
    }

    /*
    * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
    * */
    private static boolean isPalindrome(String s) {
        if (s == null) {
            return true;
        }
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = s.toCharArray();
        // 将字符串进行过滤，将符合条件的字符留下
        for (char a : chars
             ) {
            if ((a <= '9' && a >= '0') || (a >= 'a' && a <= 'z') || (a >= 'A' && a <= 'Z')) {
                stringBuilder.append(a);
            }
        }
        String string = stringBuilder.toString().toUpperCase();
        String reverseString = stringBuilder.reverse().toString().toUpperCase();
        return string.equals(reverseString);
    }
}
