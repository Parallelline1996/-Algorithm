package Page3;

/*
* 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）
* */
public class N123_BestTimeToBuyAndSellStock3 {

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{3,3,5,0,0,3,1,4}));//6
        System.out.println(maxProfit(new int[]{1,2,3,4,5}));//4
        System.out.println(maxProfit(new int[]{7,6,4,3,1}));//0
    }

    // 其他参考：https://blog.csdn.net/linhuanmars/article/details/23236995

    // O(n)
    public int maxProfit_(int[] prices) {
        int b1 = Integer.MIN_VALUE, b2 = Integer.MIN_VALUE;
        int s1 = 0, s2 = 0;

        for (int i = 0; i < prices.length; i++){
            // 第一次买入的最小值
            b1 = Math.max(b1, -prices[i]);
            // 第一次卖出的最大值
            s1 = Math.max(s1, b1 + prices[i]);
            // 第一次的最大值 减去第二次的初始值
            b2 = Math.max(b2, s1 - prices[i]);
            // 两次的最大值
            s2 = Math.max(s2, b2 + prices[i]);
        }
        return s2;
    }

    // O(n²)
    private static int maxProfit(int[] prices) {
        if (prices == null) {
            return 0;
        }
        // 做一笔交易
        int maxOne = maxProfit(prices, 0, prices.length - 1);

        // 做两笔交易
        int maxTwo = 0;
        for (int i = 1; i < prices.length - 2; i++) {
            maxTwo = Math.max(maxTwo,
                    maxProfit(prices, 0, i) + maxProfit(prices, i + 1, prices.length - 1));
        }
        return Math.max(maxOne, maxTwo);
    }

    private static int maxProfit(int[] prices, int left, int right) {
        if (prices == null) {
            return 0;
        }
        int minValue = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = left; i <= right; i++) {
            if (prices[i] < minValue) {
                minValue = prices[i];
            } else if (prices[i] - minValue > maxProfit) {
                maxProfit = prices[i] - minValue;
            }
        }
        return maxProfit;
    }
}
