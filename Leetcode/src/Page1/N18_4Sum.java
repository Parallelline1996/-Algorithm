package Page1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* Given an array nums of n integers and an integer target,
* are there elements a, b, c, and d in nums such that a + b + c + d = target?
* Find all unique quadruplets in the array which gives the sum of target.

Note:

The solution set must not contain duplicate quadruplets.

Example:

Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
* */
public class N18_4Sum {

    // 基于 3Sum的解法：
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length < 4) return new ArrayList<>();
        List<List<Integer>> output = new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> temp = null;
        for (int i = 0; i <= nums.length - 4; i++) {
            for (int j = i + 1; j <= nums.length - 3; j++) {
                int left = j + 1, right = nums.length - 1;
                while (left < right) {
                    if (nums[i] + nums[j] + nums[left] + nums[right] > target) {
                        right--;
                    } else if (nums[i] + nums[j] + nums[left] + nums[right] < target) {
                        left++;
                    } else {
                        temp = Arrays.asList(nums[i], nums[j], nums[left], nums[right]);
                        if (!output.contains(temp)) {
                            output.add(temp);
                        }
                        left++;
                        right--;
                    }
                }
            }
        }
        return output;
    }
}
