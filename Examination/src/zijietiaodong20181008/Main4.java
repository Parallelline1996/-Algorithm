package zijietiaodong20181008;

import java.util.ArrayList;
import java.util.Scanner;

// 0%
public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        ArrayList<String> arrayList = new ArrayList<>();
        while (scanner.hasNext()) {
            String temp = scanner.next();
            if (temp.length() == 0) {
                break;
            }
            arrayList.add(temp);
        }
        // 获取行列数
        String temp = arrayList.get(0);
        String[] temp_ = temp.split(",");
        int col = temp_.length;
        temp_ = null;
        int row = arrayList.size();
        int[] m = new int[col * row];
        for (int i = 0; i < row; i++) {
            temp = arrayList.get(i);
            String[] strings = temp.split(",");
            for (int j = 0; j < col; j++) {
               m[i * col + j] = Integer.parseInt(strings[j]);
            }
        }
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < col; j++) {
//                System.out.print(m[i * col + j] + "  ");
//            }
//            System.out.println();
//        }
        int[] output = new int[m.length];
        for (int i = 0 ; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (!check(m, i, j, row, col, 3)) {
                    output[i * col + j] = 1;
                }
            }
        }
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (j != row - 1) {
                    System.out.print(output[i * col + j] + ",");
                } else {
                    System.out.println(output[i * col + j]);
                }
            }
        }
    }

    private static boolean check(int[] array, int x, int y, int totalRow, int totalCol, int number) {
        if (number == 0 || x < 0 || x >= totalCol || y < 0 || y >= totalRow) {
            return false;
        }
        if (array[x + y * totalCol] == 1) {
            return true;
        }
        return check(array, x - 1, y, totalRow, totalCol, number - 1) ||
                check(array, x, y - 1, totalRow, totalCol, number - 1) ||
                check(array, x + 1, y, totalRow, totalCol, number - 1) ||
                check(array, x, y + 1, totalRow, totalCol, number - 1);
    }
}
