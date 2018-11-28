package Page6;

/*
* 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素
* */
public class N260_SingleNumber3 {

    public static void main(String[] args) {

    }

    private static int[] singleNumber(int[] nums) {
        int a = 0;
        for (int i : nums
             ) {
            a ^= i;
        }
        a &= -a;
        int[] result = new int[2];
        for (int i : nums
             ) {
            if ((i & a) == 0) {
                result[0] ^= i;
            } else {
                result[1] ^= i;
            }
        }
        return result;
    }

}
