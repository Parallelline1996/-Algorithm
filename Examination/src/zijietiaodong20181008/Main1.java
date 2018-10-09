package zijietiaodong20181008;

import java.util.Scanner;

// 20%
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int k = scanner.nextInt();
        long number = 0;
        for (int numA = 0; numA <= k; numA++) {
            int numB = k - numA;
            if (checkSum(numA, numB, a, b)) {
                number += count(numA, k);
                number %= 1000000007;
            }
        }
        System.out.println(number);
    }

    private static long count(int numA, int k) {
        long number = 1;
        for (int i = 0; i < numA; i++) {
            number *= (k - i);
        }
        for (int i = numA; i > 0; i--) {
            number /= i;
        }
        return number;
    }

    private static boolean checkSum(int numA, int numB, int a, int b) {
        int sum = a * numA + b * numB;
        while (sum > 0) {
            int temp = sum % 10;
            if (temp == a || temp == b) {
                sum /= 10;
                continue;
            }
            return false;
        }
        return true;
    }
}
