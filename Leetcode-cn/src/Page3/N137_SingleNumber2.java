package Page3;

import java.util.HashSet;
import java.util.Set;

/*
* 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素
* */
public class N137_SingleNumber2 {

    public static void main(String[] args) {

    }

    // 这种做法适用于 python，java长度限制，爆掉了
    private static int singleNubmer1(int[] A) {
        if (A == null) {
            return 0;
        }
        Set<Integer> set = new HashSet<>(A.length);
        int totalSum = 0, setSum = 0;
        for (int a : A
             ) {
            totalSum += a;
            if (!set.contains(a)) {
                set.add(a);
                setSum += a;
            }
        }
        return (setSum * 3 - totalSum) / 2;
    }

    private static int singleNumber(int[] A) {
        int result = 0;
        for (int i = 0; i < 32; i++){
            int temp = 0;
            for (int a : A) {
                temp += (a>>i & 1);
            }
            result |= ((temp % 3) << i);
        }
        return result;
    }

    private static int singleNumber2(int[] A) {
        //记录只出现过1次的bits
        int ones = 0;
        //记录只出现过2次的bits
        int twos = 0;
        // 记录出现过3次的bits
        int threes;
        // 遍历所有数
        for (int i : A
             ) {
            // 通过现在的数跟出现一次的数进行并运算，找出出现了两次的数
            twos |= ones & i;
            // 除去出现了一次的数中当前的数
            ones ^= i;
            // 如果在出现两次中出现了，还在出现一次中出现，则说明出现了三次
            threes = ones & twos;
            // 将出现三次的情况在记录只出现过1次的bits中除去
            ones &= ~threes;
            // 将出现三次的情况在记录只出现过2次的bits中除去
            twos &= ~threes;
        }
        // 返回只出现一次的bits，即没有重复的数
        return ones;
    }
}
