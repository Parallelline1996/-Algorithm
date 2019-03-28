package jrtt_20190316;

import java.util.Arrays;
import java.util.Scanner;

public class Main4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(), M = scanner.nextInt();
        double[] n = new double[N];
        for (int i = 0; i < N; i++) {
            n[i] = scanner.nextDouble();
        }
        Arrays.sort(n);
        double max = n[N - 1];
        double min = 0;
        while (Math.abs(max - min) > 0.001) {
            int number = count((min + max) / 2, n);
            if (number >= M) {
                min = (min + max) / 2;
            } else {
                max = (min + max) / 2;
            }
//            System.out.println(55);
        }
    }

    private static int count(double d, double[] N) {
        int number = 0;
        for (double i = d; i <= N[N.length - 1]; i *= 2) {
            int min = 0, max = N.length, mid = 0;
            while (max >= min && mid != min) {
                mid = (min + max) / 2;
                if (N[mid] > i) {
                    min = mid;
                } else if (N[mid] < i) {
                    max = mid;
                } else if (Math.abs(N[mid] - i) <= 1) {
                    break;
                }
            }
            if (N[mid] > i) mid++;
            number += (N.length - mid);
        }
        return number;
    }

    private static String helper(double b) {
        String a = Double.toString(b);
        int i = 0;
        for (; i < a.length(); i++) {
            if (a.charAt(i) == '.')
                break;
        }
        if (i < a.length() - 3) {
            return a.substring(0, i + 3);
        }
        return a;
    }
}
