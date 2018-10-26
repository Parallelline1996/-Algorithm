package Page4;

import java.util.Hashtable;

/*
* 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
* 你可以假设数组是非空的，并且给定的数组总是存在众数。
*
* */
public class N169_MajorityElement {

    public static void main(String[] args) {

    }

    // 思路：众数一定比其他数加起来还多，不同的时候就抵消，相同则叠加，最后一定剩下众数
    public int majorityElement_(int[] nums) {
        int temp = nums[0], times = 0;
        for (int i : nums) {
            if (times == 0) {
                temp = i;
            }
            if (temp == i)
                times++;
            else {
                times--;
            }
        }
        return temp;
    }

    // 时间很慢的解法
    public int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int n = nums.length / 2;
        Hashtable<Integer, Integer> hashtable = new Hashtable<>();
        for (int a : nums
             ) {
            if (hashtable.containsKey(a)) {
                int number = hashtable.get(a);
                number++;
                if (number > n) {
                    return a;
                } else {
                    hashtable.put(a, number);
                }
            } else {
                hashtable.put(a, 1);
            }
        }
        return 0;
    }
}
