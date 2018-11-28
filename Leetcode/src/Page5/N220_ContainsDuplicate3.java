package Page5;

import java.util.HashSet;
import java.util.Set;

/*
* Given an array of integers, find out whether there are two distinct
* indices i and j in the array such that
* the absolute difference between nums[i] and nums[j] is at most t
* and the absolute difference between i and j is at most k.

Example 1:
Input: nums = [1,2,3,1], k = 3, t = 0
Output: true

Example 2:
Input: nums = [1,0,1,1], k = 1, t = 2
Output: true

Example 3:
Input: nums = [1,5,9,1,5,9], k = 2, t = 3
Output: false
* */
public class N220_ContainsDuplicate3 {

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(containsNearbyAlmostDuplicate(new int[]{1,2,3,1}, 3, 0));
        System.out.println(containsNearbyAlmostDuplicate(new int[]{1,0,1,1}, 1, 2));
        System.out.println(containsNearbyAlmostDuplicate(new int[]{1,5,9,1,5,9}, 2, 3));
        System.out.println(containsNearbyAlmostDuplicate(new int[]{-1,2147483647}, 1, 2147483647));
    }

    private static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <= i + k && j < nums.length; j++) {
                if (Math.abs((long)nums[i] - (long)nums[j]) <= t) {
                    return true;
                }
            }
        }
        return false;
    }

}
