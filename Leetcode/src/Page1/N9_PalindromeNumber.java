package Page1;

/*
* 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
* */
public class N9_PalindromeNumber {

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-105));
        System.out.println(isPalindrome(10));
    }

    private static boolean isPalindrome(int x) {
        StringBuilder stringBuilder = new StringBuilder(Integer.toString(x));
        String string = stringBuilder.toString();
        return string.equals(stringBuilder.reverse().toString());
    }
}
