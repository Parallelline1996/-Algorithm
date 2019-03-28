package pdd_20190310;

import java.util.Scanner;

public class Main2 {

    // 75%
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next().toLowerCase();
        char[] c = input.toCharArray();
        boolean[] booleans = new boolean[c.length];
        int i = 0;
        for (i = 0; i < c.length; i++) {
            if (booleans[i]) continue;
            for (int j = i + 1; j < c.length; j++) {
                if (c[j] == c[i]) {
                    booleans[j] = true;
                    booleans[i] = true;
                }
            }
            if (!booleans[i]) break;
        }
        char output = c[0];
        for (int j = 1; j < Math.min(c.length, i + 1); j++) {
            if (output > c[j]) {
                output = c[j];
            }
        }
//        System.out.println(i);
        System.out.println(output);
    }
}
