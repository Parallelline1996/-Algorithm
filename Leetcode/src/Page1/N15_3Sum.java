package Page1;

import java.util.*;

/*
* Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
* Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
* */
public class N15_3Sum {


    public static void main(String[] args) {
        N15_3Sum Main = new N15_3Sum();
        int[] nums = new int[]{0,0,0};
//        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};

        System.out.println(Main.threeSum(nums).toString());

    }

    /*
    * 思路：
    * 先排序，再从左到右遍历，确定第一个数，
    * 从第一个数后面的数中，分别从最左跟最右两个位置，向中间遍历，找出和为规定值的情况
    * */
    public List<List<Integer>> threeSum(int[] nums) {
        // 输入空，或数组长度小于 3，返回空
        if (nums == null || nums.length < 3) return new ArrayList<>();
        List<List<Integer>> output = new ArrayList<>();
        Arrays.sort(nums);
        // i : 第一个元素
        for (int i = 0; i <= nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1, right = nums.length - 1;
            // 从左右两个端点向中间寻找解
            while (left < right) {
                // 当结果过大时，右指针向左移动，结果过小时，左指针向右移动
                if (nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                } else if (nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                } else {
                    output.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 将重复结果进行去除
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                }
            }
        }
        return output;
    }

    // 速度巨慢。。
    public List<List<Integer>> threeSum1(int[] nums) {
        if (nums == null || nums.length < 3) return new ArrayList<>();
        List<List<Integer>> output = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int sum = -nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int remainValue = sum - nums[j];
                if (set.contains(remainValue)) {
                    ArrayList<Integer> a = new ArrayList<>();
                    a.add(-sum);
                    a.add(remainValue);
                    a.add(nums[j]);
                    Collections.sort(a);
                    if (!output.contains(a)) {
                        output.add(a);
                    }
                } else {
                    set.add(nums[j]);
                }
            }
            set.clear();
        }
        return output;
    }
}
