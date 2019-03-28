package Page20;

import java.util.HashSet;
import java.util.Set;

/*
* In a country popular for train travel, you have planned some train travelling one year in advance.
* The days of the year that you will travel is given as an array days.  Each day is an integer from 1 to 365.

Train tickets are sold in 3 different ways:

a 1-day pass is sold for costs[0] dollars;
a 7-day pass is sold for costs[1] dollars;
a 30-day pass is sold for costs[2] dollars.
The passes allow that many days of consecutive travel.  For example, if we get a 7-day pass on day 2, then we can travel for 7 days: day 2, 3, 4, 5, 6, 7, and 8.

Return the minimum number of dollars you need to travel every day in the given list of days.



Example 1:
Input: days = [1,4,6,7,8,20], costs = [2,7,15]
Output: 11
Explanation:
For example, here is one way to buy passes that lets you travel your travel plan:
On day 1, you bought a 1-day pass for costs[0] = $2, which covered day 1.
On day 3, you bought a 7-day pass for costs[1] = $7, which covered days 3, 4, ..., 9.
On day 20, you bought a 1-day pass for costs[0] = $2, which covered day 20.
In total you spent $11 and covered all the days of your travel.

Example 2:
Input: days = [1,2,3,4,5,6,7,8,9,10,30,31], costs = [2,7,15]
Output: 17
Explanation:
For example, here is one way to buy passes that lets you travel your travel plan:
On day 1, you bought a 30-day pass for costs[2] = $15 which covered days 1, 2, ..., 30.
On day 31, you bought a 1-day pass for costs[0] = $2 which covered day 31.
In total you spent $17 and covered all the days of your travel.


Note:
1 <= days.length <= 365
1 <= days[i] <= 365
days is in strictly increasing order.
costs.length == 3
1 <= costs[i] <= 1000
* */

// Medium
public class N983_MinimumCostForTickets {

    public static void main(String[] args) {
        System.out.println(new N983_MinimumCostForTickets().mincostTickets(new int[]{1,4,6,7,8,20}, new int[]{2,7,15}));
//        System.out.println(new N983_MinimumCostForTickets().mincostTickets(new int[]{1,2,3,4,5,6,7,8,9,10,30,31}, new int[]{2,7,15}));
    }

    public int mincostTickets(int[] days, int[] costs) {
        if (days == null || costs == null || costs.length != 3 || days.length == 0) return 0;
        // 定义为：第x天的最低花费
        int[] dp = new int[days[days.length - 1] + 1];
        // 用一个 set来保存有观影的日子
        Set<Integer> set = new HashSet<>();
        for (int day : days
             ) {
            set.add(day);
        }
        for (int i = days[0]; i < dp.length; i++) {
            if (set.contains(i)) {
                // 状态转换，判断应该哪种购票可以获得最低
                dp[i] = Math.min(Math.min(helper(dp, i - 1) + costs[0], helper(dp, i - 7) + costs[1]),
                        helper(dp, i - 30) + costs[2]);
            } else {
                // 当日无花费，最低花费与前一日相同
                dp[i] = dp[i - 1];
            }
        }
//        for (int i = 0; i < dp.length; i++) {
//            System.out.println(i + " " + dp[i]);
//        }
        return dp[days[days.length - 1]];
    }

    private int helper(int[] dp, int i) {
        if (i <= 0)
            return 0;
        return dp[i];
    }
}
