package Page2;

/*
* 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
*
* 思路：取一个局部最优，跟一个全局最优。
* 遍历每一个数，判断是否将这个数加入，或者是新起一个新的字串，来获取局部最优
* */
public class N53_MaximumSubarray {

    public static void main(String[] args) {
        int[] temp = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(temp));
        temp = new int[]{1};
        System.out.println(maxSubArray(temp));
    }

    /*
    * 思路：
    * 动态规划
    * */
    private static int maxSubArray1(int[] nums) {
        if (nums == null) {
            return 0;
        }
        // 定义为以第 i点为最后一个元素的子数组的能获得的最大值
        int[] dp = new int[nums.length];

        // 初始化
        dp[0] = nums[0];
        int max = dp[0];

        for (int i = 1; i < nums.length; i++) {
            // 判断是否要包含当前节点之前的其他节点
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }

    // 这道题比较容易，没必要跟上面一样写成dp[]的样子，这个解法速度更快
    private static int maxSubArray(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int max = nums[0];
        int totalMax = max;
        for(int i = 1; i < nums.length; i++) {
            max = Math.max(nums[i], max + nums[i]);
           if (totalMax < max) {
               totalMax = max;
           }
        }
        return totalMax;
    }
}
