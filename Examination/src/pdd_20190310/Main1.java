package pdd_20190310;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }

        Arrays.sort(a);
        Arrays.sort(b);
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += a[i] * b[n - i - 1];
        }
        System.out.println(total);
    }
}
