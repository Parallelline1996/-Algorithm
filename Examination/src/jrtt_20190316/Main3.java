package jrtt_20190316;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class Main3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int zz = scanner.nextInt();
        for (int z = 0; z < zz; z++) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            TreeMap<Integer, ArrayList<Integer>> treeMap = new TreeMap<>();
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
                if (!treeMap.containsKey(a[i])) {
                    treeMap.put(a[i], new ArrayList<>());
                }
                treeMap.get(a[i]).add(i);
            }
            ArrayList<Integer> arrayList = null;
            while (!treeMap.isEmpty()) {
                int key = treeMap.firstKey();
                arrayList = treeMap.get(key);
                for (int k : arrayList
                     ) {
                    helper(k, a, b);
                }
                treeMap.remove(key);
            }
            int output = 0;
            for (int kk : b
                 ) {
                output += kk;
            }
            System.out.println(output);
        }
    }

    private static void helper(int k, int[] n, int[] b) {
        int l = k - 1, r = k + 1;
        if (k == 0) {
            l = n.length - 1;
        } else if (k == n.length - 1) {
            r = 0;
        }
        if (n[k] > n[l]) {
            if (n[k] > n[r]) {
                b[k] = Math.max(b[r], b[l]) + 1;
            } else {
                b[k] = b[l] + 1;
            }
        } else {
            if (n[k] < n[r]) {
                b[k] = 1;
            } else {
                b[k] = b[r] + 1;
            }
        }
    }
}
