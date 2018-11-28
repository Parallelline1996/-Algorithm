package Page7;

/*
* 给定一个整数，写一个函数来判断它是否是 3 的幂次方。
* */
public class N326_PowerOfThree {

    public static void main(String[] args) {
//        System.out.println(isPowerOfThree(27));
//        System.out.println(isPowerOfThree(0));
//        System.out.println(isPowerOfThree(9));
//        System.out.println(isPowerOfThree(45));
        System.out.println(isPowerOfThree(243));
    }

    // 判断这个数是否是3的幂次方，将这个数对3取对数，如果取出来为整数，则判断为3的幂次方
    private static boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }
        double k = Math.log10(n) / Math.log10(3);
        return k == (int)k;
    }
}
