package Page3;

/*
* 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
注意你不能在买入股票前卖出股票。
* */
public class N121_BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(maxProfit(new int[]{7,6,4,3,1}));
    }

    // 只需要遍历一次的解法：
    // 通过维持最小峰值跟最大差值两个值
    private static int maxProfit(int[] prices) {
        if (prices == null) return 0;
        int minValue = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int a : prices) {
            if (a < minValue) {
                minValue = a;
            } else if (a - minValue > maxProfit) {
                // 保证了买入卖出的顺序问题
                maxProfit = a - minValue;
            }
        }
        return maxProfit;
    }

    // 循环的解法：
    private static int maxProfit_(int[] prices) {
        if (prices == null) {
            return 0;
        }
        int maxValue = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                maxValue = Math.max(prices[j] - prices[i], maxValue);
            }
        }
        return maxValue;
    }
}
