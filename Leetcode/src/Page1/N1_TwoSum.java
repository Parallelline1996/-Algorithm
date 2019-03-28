package Page1;

import java.util.HashMap;

/*
* Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
* */
public class N1_TwoSum {

    /*
    * 思路：
    * 使用一个 map数据结构，key为值，value为该值对应的下标（因为此题最后要求返回下标）
    * 遍历一遍数组，判断 Map中是否有跟当前值相加为所需值的数，
    * 如有，则结束遍历，若无，则将（当前值，下标）的组合添加到 Map中
    * */
    public int[] twoSum(int[] nums, int target) {
        // 对输入进行判断，若为空或数组长度小于二，直接返回
        if (nums == null || nums.length < 2) return null;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int remainValue = target - nums[i];
            if (map.containsKey(remainValue)) {
                return new int[]{map.get(remainValue), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }
}
