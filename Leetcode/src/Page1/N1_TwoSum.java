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

    // 这里用 map，因为最后要返回的是下标
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) return null;
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] output = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int remainValue = target - nums[i];
            if (map.containsKey(remainValue)) {
                output[0] = map.get(remainValue);
                output[1] = i;
                return output;
            } else {
                map.put(nums[i], i);
            }
        }
        return output;
    }
}
