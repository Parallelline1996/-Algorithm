package Page3;

import java.util.ArrayList;
import java.util.List;

/*
* 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
* 你可以优化你的算法到 O(k) 空间复杂度吗？
* */
public class N119_PascalsTrangle2 {

    public static void main(String[] args) {
        List<Integer> list = getRow(5);
        for (Integer a : list
             ) {
            System.out.print(a + " ");
        }
        System.out.println();
        list = getRow(0);
        for (Integer a : list
             ) {
            System.out.print(a + " ");
        }
    }

    private static List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>(rowIndex + 1);
        if (rowIndex < 0) {
            return list;
        }
        for (int i = 0; i < rowIndex + 1; i++) {
            list.add(1);
        }
        for (int i = 0; i <= rowIndex + 1; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (j == 0 || j == i - 1) {
                    list.set(j, 1);
                } else {
                    list.set(j, list.get(j) + list.get(j - 1));
                }
            }
        }
        return list;
    }
}
