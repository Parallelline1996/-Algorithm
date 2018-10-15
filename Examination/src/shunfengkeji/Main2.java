package shunfengkeji;

import java.util.Scanner;

/*
* 给定两个数组，求多少个数在两个数组里的顺序是相反的
* */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int[] array1 = new int[number];
        int[] array2 = new int[number];
        for (int i = 0; i < number; i++) {
            array1[scanner.nextInt()] = i;
        }
        for (int i = 0; i < number; i++) {
            array2[scanner.nextInt()] = i;
        }
        int output = 0;
        for (int i = 0; i < number; i++) {
            for (int j = i; j < number; j++) {
                if (check(array1, array2, i, j)) {
                    output++;
                }
            }
        }
        System.out.println(output);
    }

    private static boolean check(int[] array1, int[] array2, int i, int j) {
        int a = array1[i] - array1[j];
        int b = array2[i] - array2[j];
        return (a * b <= 0 && a != b);
    }
}
