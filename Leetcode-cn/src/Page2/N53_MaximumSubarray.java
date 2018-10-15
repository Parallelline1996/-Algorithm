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
