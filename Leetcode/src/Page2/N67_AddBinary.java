package Page2;

/*
* 给定两个二进制字符串，返回他们的和（用二进制表示）。
* 输入为非空字符串且只包含数字 1 和 0
* */
public class N67_AddBinary {

    public static void main(String[] args) {
        System.out.println(addBinary("11", "1"));
        System.out.println(addBinary("1010", "1011"));
    }

    private static String addBinary(String a, String b) {
        // 这种解法长度上可能有问题
//        return Integer.toString(Integer.parseInt(a, 2) + Integer.parseInt(b, 2), 2);
        // 对输入进行判断
        if (a == null || b == null) {
            return null;
        }
        if (a.length() == 0) {
            return b;
        }
        if (b.length() == 0) {
            return a;
        }
        int aTemp, bTemp, add = 0, total;
        char[] aChars = a.toCharArray(), bChars = b.toCharArray();
        StringBuilder sb = new StringBuilder();
        // 因为两个字符串长度可能不等，这里处理方式是：字符串读完的，下一次读取是读为0即可
        for(int aIndex = a.length() - 1, bIndex = b.length() - 1; aIndex >= 0 || bIndex >= 0; aIndex--, bIndex--) {
            aTemp = (aIndex >= 0)? (int)aChars[aIndex] - 48: 0;
            bTemp = (bIndex >= 0)? (int)bChars[bIndex] - 48: 0;
            total = add + aTemp + bTemp;
            add = total / 2;
            sb.append(total % 2);
        }
        // 判断最后的是否需要进位
        if (add == 1) {
            sb.append("1");
        }
        return sb.reverse().toString();
    }
}
