package huawei;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // main1:
//        String string = scanner.next();
//        String a = scanner.next();
//        solution(string, a);

        // main2:
//        for (int i = 0; i < 2; i++) {
//            printCharacter(scanner.next());
//        }

        // main3:
//        while (scanner.hasNext()) {
//            String data = scanner.next();
//            toDecimalNumber(data);
//        }

        // main4:
//        long data = scanner.nextLong();
//        System.out.println(getResult(data));

        // main5:
//        double data = scanner.nextDouble();
//        upOrDown(53.5);
//        upOrDown(53.4);
//        upOrDown(53.51);

        // main6:
        combine(scanner.nextInt(), scanner);
    }

    /*
    * main1
    * 写出一个程序，接受一个由字母和数字组成的字符串，和一个字符，
    * 然后输出输入字符串中含有该字符的个数。不区分大小写。
    * */
    private static void solution(String string, String a) {
        if (string == null || a == null || a.length() != 1) {
            System.out.println(0);
            return;
        }
        string = string.toUpperCase();
        a = a.toUpperCase();
        int number = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.substring(i, i + 1).equals(a)) {
                number++;
            }
        }
        System.out.println(number);
    }

    /*
    * main2
    * 连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；
    * 长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
    * 输入描述：连续输入字符串(输入2次,每个字符串长度小于100)
    * */
    private static void printCharacter(String data) {
        if (data == null) {
            return;
        }
        int i = 0;
        for (; i + 7 < data.length(); i += 8) {
            System.out.println(data.substring(i, i + 8));
        }
        if (i == data.length()) {
            return;
        }
        if (i + 8 != data.length()) {
            StringBuilder sb = new StringBuilder(data.substring(i));
            for (int j = 0; j < 8 - data.length() % 8; j++) {
                sb.append("0");
            }
            System.out.println(sb.toString());
        }
    }

    /*
    * main3
    * 接受一个十六进制的数值字符串，输出该数值的十进制字符串
    * */
    private static void toDecimalNumber(String hexNumber) {
        int decimalNumber = Integer.parseInt(hexNumber.substring(2), 16);
        System.out.println(decimalNumber);
    }

    /*
    * main4
    * 输入一个正整数，按照从小到大的顺序输出它的所有质数的因子（如180的质数因子为2 2 3 3 5 ）
    * 最后一个数后面也要有空格
    * */
    private static String getResult(long ulDataInput) {
        StringBuilder sb = new StringBuilder();
        while (ulDataInput % 2 == 0) {
            sb.append("2 ");
            ulDataInput = ulDataInput / 2;
        }
        for (int i = 3; ; i += 2) {
            if (ulDataInput == 1) {
                break;
            }
            while (ulDataInput % i == 0) {
                sb.append(i + " ");
                ulDataInput = ulDataInput / i;
            }
        }
        return sb.toString();
    }

    /*
    * main5:
    * 写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。如果小数点后数值大于等于5,向上取整；小于5，则向下取整。
    * */
    private static void upOrDown(double data) {
        int temp = (int)(data * 10) % 10;
        if (temp >= 5) {
            System.out.println((int)Math.ceil(data));
        } else {
            System.out.println((int)Math.floor(data));
        }
    }

    /*
     * 数据表记录包含表索引和数值，请对表索引相同的记录进行合并，
     * 即将相同索引的数值进行求和运算，输出按照key值升序进行输出
     */
    private static void combine(int number, Scanner scanner) {
        Map<Integer, Integer> map = new TreeMap<>();
        int key = 0, val = 0;
        for (int i = 0; i < number; i++) {
            key = scanner.nextInt();
            val = scanner.nextInt();
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + val);
            } else {
                map.put(key, val);
            }
        }
        for (Integer i: map.keySet()
             ) {
            System.out.println(i + " " + map.get(i));
        }
    }
}
