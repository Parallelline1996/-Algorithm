package Page4;

/*
* 编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
* */
public class N191_Numberof1Bits {

    public static void main(String[] args) {
        System.out.println(hammingWeight(2));
        System.out.println(hammingWeight(11));
        System.out.println(hammingWeight(128));
        System.out.println(hammingWeight(15));
    }

    private static int hammingWeight(int n) {
//        if (n <= 0) {
//            return 0;
//        }
//        int output = 0;
//        while (n > 0) {
//            output++;
//            n = n & (n - 1);
//        }
//        return output;

        int bits = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                bits++;
            }
            mask <<= 1;
        }
        return bits;
    }
}
