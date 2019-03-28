package jrtt_20190315_test;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main2 {

    /*
    * 思路：
    * 由于是一个环，考虑成线性，再拼接一段在末尾的情况
    * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int c = scanner.nextInt();
        int[][] nm = new int[m - 1][c + 1];
        Set<Integer> set = new HashSet<>();
        int[] lastElement = new int[c + 1];
        for (int i = 0; i < m - 1; i++) {
            int temp = scanner.nextInt();
            for (int j = 0; j < temp; j++) {
                int v = scanner.nextInt();
                nm[i][v] = 1;
                if (i > 0 && i - lastElement[v] < m) {
                    set.add(v);
                } else {
                    lastElement[v] = i;
                }
            }
        }

        for (int i = m - 1; i < n; i++) {
            int temp = scanner.nextInt();
            for (int j = 0; j < temp; j++) {
                int v = scanner.nextInt();
                if (i > 0 && i - lastElement[v]< m) {
                    set.add(v);
                } else {
                    lastElement[v] = i;
                }
            }
        }

        for (int i = 0; i < m - 1; i++) {
            for (int j = 1; j < c + 1; j++) {
                if (nm[i][j] == 1 && i + n - lastElement[j] < m) {
                        set.add(j);
                }
            }
        }
        System.out.println(set.size());
    }
}
