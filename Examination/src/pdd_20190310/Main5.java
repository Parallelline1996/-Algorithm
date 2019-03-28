package pdd_20190310;

import java.util.Scanner;

public class Main5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstString = scanner.next();
        String secondString = scanner.next();
        int firstStringLeft = 0, firstStringRight = 0,
                secondStringLeft = 0, secondStringRight = 0;
        char[] first = firstString.toCharArray();
        char[] second = secondString.toCharArray();

        for (char k : first
             ) {
            if (k == '(') {
                firstStringLeft++;
            } else {
                firstStringRight++;
            }
        }

        for (char k : second
            ) {
            if (k == '(') {
                secondStringLeft++;
            } else {
                secondStringRight++;
            }
        }
    }
}
