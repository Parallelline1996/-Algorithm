package Page4;

/*
* 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
* 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
* 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
* 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
*
* 示例 1:
输入: [1,2,3,1]
输出: 4
解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
     偷窃到的最高金额 = 1 + 3 = 4 。

示例 2:

输入: [2,7,9,3,1]
输出: 12
解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
* */
public class N198_HouseRobber {

    public static void main(String[] args) {
        System.out.println(rob(new int[]{1,2,3,1}));
        System.out.println(rob(new int[]{2,7,9,3,1}));
    }

    private static int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        // 状态的定义：房间数
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            // 对于每一间房间：比较是否要前dp[i - 2]跟当前的房间，还是不要当前的房间即dp[i - 1]
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }
}
