package pdd_20190309_test;

import java.util.Scanner;

public class Main1 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int offset = scanner.nextInt();
            int n = scanner.nextInt();
            int length1 = scanner.nextInt();
            int length2 = scanner.nextInt();
            int start1 = 0, start2 = 0, end1 = 0, end2 = 0;
            if (offset >= length1) {
                start1 = length1;
                end1 = length1;
                if (offset >= length1 + length2) {
                    start2 = length2;
                    end2 = length2;
                } else {
                    start2 = offset - length1;
                    end2 = Math.min(offset + n - length1, length2);
                }
            } else {
                start1 = offset;
                if (n + offset <= length1) {
                    end1 = n + offset;
                } else {
                    end1 = length1;
                    end2 = n + offset - length1;
                }
            }
            System.out.println(start1 + " " + end1 + " " + start2 + " " + end2);
        }
    }
}
