package Page4;


import java.util.Map;

/*
* Given an integer array nums, find the contiguous subarray within an array
* (containing at least one number) which has the largest product.

Example 1:
Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.

Example 2:
Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
* */
public class N152_MaximumProductSubarray {

    public static void main(String[] args) {
        System.out.println(new N152_MaximumProductSubarray().maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(new N152_MaximumProductSubarray().maxProduct(new int[]{-2, 0, -1}));
    }

    public int maxProduct(int[] nums) {
        if (nums.length == 1) return nums[0];
        // 定义状态，需要定义每一个包含第 i个元素的最大值跟最小值，因为有负负得正的情况
        // 0 代表 最大值，1 代表最小值
        // 也可以直接定义两个一位数组 int[] max, int[] min
        int[][] dp = new int[nums.length][2];
        // 全局最大值
        int max = nums[0];
        // 初始化
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];

        // 分两种情况，nums[i]可能是正也可能负，分别计算并比较大小再进行赋值
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.max(Math.max(dp[i - 1][0] * nums[i], dp[i - 1][1] * nums[i]), nums[i]);
            dp[i][1] = Math.min(Math.min(dp[i - 1][1] * nums[i], dp[i - 1][0] * nums[i]), nums[i]);
            max = Math.max(dp[i][0], max);
        }

        return max;
    }
}
