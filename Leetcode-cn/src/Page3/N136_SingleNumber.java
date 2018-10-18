package Page3;

import java.util.HashSet;

/*
* 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素
* */
public class N136_SingleNumber {

    private static int singleNumber(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int output = 0;
        for (int a : nums
                ) {
            output ^= a;
        }
        return output;
    }
}
