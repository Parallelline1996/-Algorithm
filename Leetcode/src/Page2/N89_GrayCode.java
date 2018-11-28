package Page2;

import java.util.ArrayList;
import java.util.List;

/*
* 格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。
* 给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。格雷编码序列必须以 0 开头
* */
public class N89_GrayCode {

    public static void main(String[] args) {
        List<Integer> temp = grayCode(2);
        for (Integer i : temp
             ) {
            System.out.print(i + "  ");
        }
        System.out.println();

        temp = grayCode(3);
        for (Integer i : temp
                ) {
            System.out.print(i + "  ");
        }
        System.out.println();
    }

    private static List<Integer> grayCode(int n) {
        if (n < 0) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        if (n == 0) {
            list.add(0);
            return list;
        }
        String[] temp = getGrayCode(n);
        for (String a : temp
                ) {
            list.add(Integer.parseInt(a, 2));
        }
        return list;
    }

    private static String[] getGrayCode(int n) {
        String[] output = null;
        if (n == 1) {
            output = new String[]{"0", "1"};
        } else {
            String[] temp = getGrayCode(n - 1);
            output = new String[temp.length * 2];
            for (int i = 0; i < temp.length; i++) {
                output[i] = "0" + temp[i];
                output[temp.length * 2 - i - 1] = "1" + temp[i];
            }
        }
        return output;
    }
}
