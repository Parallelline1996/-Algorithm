package Page5;

/*
* Given an array of integers, find if the array contains any duplicates.
* Your function should return true if any value appears at least twice in the array,
* and it should return false if every element is distinct.
Example 1:
Input: [1,2,3,1]
Output: true
Example 2:

Input: [1,2,3,4]
Output: false
Example 3:

Input: [1,1,1,3,3,4,3,2,4,2]
Output: true
* */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class N217_ContainsDuplicate {

    public static void main(String[] args) {

    }

    // 先排序，再执行
    private static boolean containsDuplicate1(int[] nums) {
        Arrays.sort(nums);
        for (int i=0;i<nums.length-1;++i) {
            if (nums[i] == nums[i+1]) {
                return true;
            }
        }
        return false;
    }

    // 执行效率比较慢
    private static boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int a : nums
             ) {
            if (set.contains(a)) {
                return true;
            } else {
                set.add(a);
            }
        }
        return false;
    }
}
