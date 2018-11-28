package Page5;

import java.util.HashSet;
import java.util.Set;

/*
* Given an array of integers and an integer k,
* find out whether there are two distinct indices i and j in the array
* such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
Example 1:
Input: nums = [1,2,3,1], k = 3
Output: true

Example 2:
Input: nums = [1,0,1,1], k = 1
Output: true

Example 3:
Input: nums = [1,2,3,1,2,3], k = 2
Output: false
* */
public class N219_ContainsDuplicate2 {

    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate1(new int[]{1,2,3,1}, 3));
        System.out.println(containsNearbyDuplicate1(new int[]{1,0,1,1}, 1));
        System.out.println(containsNearbyDuplicate1(new int[]{1,2,3,1,2,3}, 2));
    }

    private static boolean containsNearbyDuplicate1(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            } else {
                set.add(nums[i]);
            }
            if (i >= k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

    private static boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <= i + k && j < nums.length; j++) {
                if (nums[j] == nums[i]) {
                    return true;
                }
            }
        }
        return false;
    }
}
