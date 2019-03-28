package jrtt_20190316;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int z = 0; z < n; z++) {
            String s = scanner.next();
            char[] c = s.toCharArray();
//            char[] c = scanner.next().toCharArray();
            if (c.length == 0) {
                System.out.println("");
                continue;
            }
            StringBuilder sb = new StringBuilder();
            boolean first = false, second = false;
            sb.append(c[0]);
            for (int i = 1; i < c.length; i++) {
                if (second) {
                    if (c[i] != c[i - 1]) {
                        second = false;
                        first = false;
                        sb.append(c[i]);
                    }
                } else if (first) {
                    if (c[i] != c[i - 1]) {
                        second = true;
                        sb.append(c[i]);
                    }
                } else {
                    if (c[i] == c[i - 1]) {
                        first = true;
                    }
                    sb.append(c[i]);
                }
            }
            System.out.println(sb.toString());
        }
    }
}
