package blog;

import java.util.Scanner;

public class toutiao {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        StringBuilder sb = new StringBuilder();
        char[] chars = input.toCharArray();
        for (int i = input.length() - 1; i >= 0; i--) {
            if (chars[i] == 'o') {
                i--;
            } else {
                sb.append(chars[i]);
            }
        }
//        System.out.println(sb.toString());
        String temp = sb.reverse().toString();
        chars = temp.toCharArray();
        sb = new StringBuilder();
        for (int i = temp.length() - 1; i >= 0; i--) {
            if (chars[i] == 'i') {
                i--;
//                int num = 1;
//                i--;
//                while (i >= 0 && num > 0) {
//                    if (chars[i] == 'i') {
//                        num++;
//                    } else {
//                        num--;
//                    }
//                    i--;
//                }
//                i++;
            } else {
                sb.append(chars[i]);
            }
        }
        System.out.println(sb.reverse().toString());
    }
}
