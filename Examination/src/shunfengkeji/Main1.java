package shunfengkeji;

import java.util.Scanner;

/*
* 通过率80% 给定一个字符串，求aabcc，两边长度大于中间长度的回文字串的最长串
* */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int left = 0, right = 0, middleLength = 0;
        char[] chars = s.toCharArray();
        String output = "";
        for (int i = 1; i < s.length(); i++) {
            left = i - 1;
            right = i + 1;
            for (int j = i + 1; j < s.length(); j++) {
                if (chars[j] == chars[i]) {
                    right++;
                } else {
                    break;
                }
            }
            middleLength = right - left - 1;
            int leastLength = Math.max(middleLength, (output.length() - middleLength) / 2);
            if (!check(chars, leastLength, left, right)) {
                continue;
            }
            left = left - middleLength;
            right = right + middleLength;
            char leftChar = chars[left], rightChar = chars[right];
            while (true) {
                if (left - 1 >= 0 && right + 1 < s.length() && chars[left - 1] == leftChar && chars[right + 1] == rightChar) {
                    left--;
                    right++;
                }
                else {
                    break;
                }
            }
            if (output.length() < right - left + 1) {
                output = s.substring(left, right + 1);
            }
            i += middleLength - 1;
        }
        System.out.println(output);
    }

    private static boolean check(char[] chars, int length, int leftEnd, int rightStart) {
        int leftStart = leftEnd - length;
        int rightEnd = rightStart + length;
        if (leftStart < 0 || rightEnd > chars.length - 1) {
            return false;
        }
        char temp = chars[leftStart];
        for (int i = leftStart + 1; i <= leftEnd; i++) {
            if (chars[i] != temp) {
                return false;
            }
        }
        temp = chars[rightStart];
        for (int i = rightStart + 1; i <= rightEnd; i++) {
            if (chars[i] != temp) {
                return false;
            }
        }
        return true;
    }

}
