package pdd_20190310;

import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int d = scanner.nextInt();
        int[] index = new int[n];
        int[] money = new int[n];
        int oneBackMax = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            index[i] = scanner.nextInt();
            money[i] = scanner.nextInt();
            if (money[i] > oneBackMax) oneBackMax = money[i];
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (oneBackMax + money[i] <= max) continue;
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(index[i] - index[j]) < d) continue;
                max = Math.max(max, money[i] + money[j]);
//                System.out.println(max + " " + i + " " + j);
            }
        }
        System.out.println(max);
    }
}
