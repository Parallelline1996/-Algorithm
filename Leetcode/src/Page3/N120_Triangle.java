package Page3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* Given a triangle, find the minimum path sum from top to bottom.
* Each step you may move to adjacent numbers on the row below.

For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
*
* */
public class N120_Triangle {

    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(Arrays.asList(2));
        lists.add(Arrays.asList(3, 4));
        lists.add(Arrays.asList(6, 5, 7));
        lists.add(Arrays.asList(4, 1, 8, 3));
        System.out.println(new N120_Triangle().minimumTotal(lists));
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null) return 0;
        int n = triangle.size();
        // 定义状态，这里也可以用一维数组进行复用，二维数组代码清晰一点
        int[][] dp = new int[n][n];
        List<Integer> temp = null;
        dp[0][0] = triangle.get(0).get(0);
        // 对每一层进行遍历
        for (int i = 1; i < n; i++) {
            // 对最左侧跟最后侧两列取值方式不同的状态量先进行计算
            temp = triangle.get(i);
            dp[i][0] = dp[i - 1][0] + temp.get(0);
            dp[i][i] = dp[i - 1][i - 1] + temp.get(i);
            // 利用状态转移方程求解
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + temp.get(j);
            }
        }
        // 找出到达最末一行的最小路径值
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (dp[n - 1][i] < min) {
                min = dp[n - 1][i];
            }
        }
        return min;
    }
}
