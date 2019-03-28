package jrtt_20190315_test;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class Main1 {

    /*
    * 思路，将相同喜好值的用户存在一起，
    * 每次判断该喜好值对应的用户是否在范围内
    * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        // 用于放 喜好值 -> 对应的用户
        Hashtable<Integer, ArrayList<Integer>> hashtable = new Hashtable<>();
        for (int i = 0; i < n; i++) {
            int temp = scanner.nextInt();
            if (!hashtable.containsKey(temp)) {
                hashtable.put(temp, new ArrayList<>());
            }
            // 查询用户范围时为 1~n，所以这里 +1
            hashtable.get(temp).add(i + 1);
        }
        int q = scanner.nextInt();
        int output = 0, l = 0, r = 0, value = 0;
        ArrayList<Integer> arrayList = null;

        // 对读入的每组结果进行检查
        for (int i = 0; i < q; i++) {
            l = scanner.nextInt();
            r = scanner.nextInt();
            value = scanner.nextInt();
            output = 0;
            // 如果该喜好值不对应任何用户，则直接输出 0
            if (!hashtable.containsKey(value)) {
                System.out.println(0);
                continue;
            }
            // 遍历该喜好值对应的所有用户，判断是否在范围内
            arrayList = hashtable.get(value);
            for (int k : arrayList
                 ) {
                if (k >= l && k <= r)
                    output++;
            }
            System.out.println(output);
        }
    }
}
