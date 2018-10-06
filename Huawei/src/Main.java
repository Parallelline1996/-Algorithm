import java.util.*;

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
//        combine(scanner.nextInt(), scanner);

        // main7:
//        getNumber(scanner.nextInt());

        // main8:
//        countCharacter(scanner.next());

        // main9:
//        reserve(scanner.nextInt());

        // main10:
//        reserveByWord(scanner.nextLine());

        // main11:
//        dictionary(scanner);

        // main12:
//        countOne(scanner.nextInt());

        // main13:
//        while (scanner.hasNext()) {
//            sortByASCII(scanner.next());
//            System.out.println();
//        }

        // main14:
//        while (scanner.hasNext()) {
//            isContains(scanner.nextLine(), scanner.nextLine());
//        }
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
     * main6：
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

    /*
     * main7：
     * 输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数
     * */
    private static void getNumber(int number) {
        int temp;
        ArrayList<Integer> arrayList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        while (number > 0) {
            temp = number % 10;
            number /= 10;
            if (!arrayList.contains(temp)) {
                arrayList.add(temp);
                sb.append(temp);
            }
        }
        System.out.println(sb.toString());
    }

    /*
     * main8:
     * 计算字符串中含有的不同字符的个数。字符在ACSII码范围内(0~127)。不在范围内的不作统计
     * */
    private static void countCharacter(String data) {
        if (data == null) {
            System.out.println(0);
            return;
        }
        HashSet<Character> hashSet = new HashSet<>();
        char[] temp = data.toCharArray();
        for (char a : temp
                ) {
            if (a > 0 && a < 127 && !hashSet.contains(a)) {
                hashSet.add(a);
            }
        }
        System.out.println(hashSet.size());
    }

    /*
     * main9：
     * 输入一个整数，将这个整数以字符串的形式逆序输出
     * 程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001
     * */
    private static void reserve(int data) {
        StringBuilder sb = new StringBuilder(Integer.toString(data));
        System.out.println(sb.reverse().toString());
    }

    /*
     * main10：
     * 将一个英文语句以单词为单位逆序排放。例如“I am a boy”，逆序排放后为“boy a am I”
     * 所有单词之间用一个空格隔开，语句中除了英文字母外，不再包含其他字符
     * */
    private static void reserveByWord(String data) {
        String[] datas = data.split(" ");
        for (int i = datas.length - 1; i > 0; i--) {
            System.out.print(datas[i] + " ");
        }
        System.out.print(datas[0]);
    }

    /*
     * main11：
     * 给定n个字符串，请对n个字符串按照字典序排列
     * */
    private static void dictionary(Scanner scanner) {
        int number = scanner.nextInt();
        if (number <= 0) {
            System.out.println();
            return;
        }
        String[] list = new String[number];
        for (int i = 0; i < number; i++) {
            list[i] = scanner.next();
        }
        Arrays.sort(list);
        for (String o: list
                ) {
            System.out.println(o);
        }
    }

    /*
     * main12:
     * 输入一个int型的正整数，计算出该int型数据在内存中存储时1的个数
     * */
    private static void countOne(int number) {
        int num = 0;
        while (number != 0) {
            number = number & (number - 1);
            num ++;
        }
        System.out.println(num);
    }

    /*
     * main13:
     * 需要把这些图片按照大小（ASCII码值从小到大）排列收好
     * */
    private static void sortByASCII(String data) {
        char[] chars = data.toCharArray();
        Arrays.sort(chars);
        for (char a : chars
                ) {
            System.out.print(a);
        }
    }

    /*
     * main14：
     * 判断短字符串中的所有字符是否在长字符串中全部出现
     * */
    private static void isContains(String shortString, String longString) {
        char[] temp = shortString.toCharArray();
        HashSet<Character> shortSet = new HashSet<>();
        HashSet<Character> longSet = new HashSet<>();
        for (char a : temp
                ) {
            shortSet.add(a);
        }
        temp = longString.toCharArray();
        for (char a : temp
                ) {
            longSet.add(a);
        }
        System.out.println(longSet.containsAll(shortSet));
    }
}
