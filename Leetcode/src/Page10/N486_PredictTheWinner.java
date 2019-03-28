package Page10;

/*
* Given an array of scores that are non-negative integers.
* Player 1 picks one of the numbers from either end of the array followed by the player 2 and then player 1 and so on.
* Each time a player picks a number, that number will not be available for the next player.
* This continues until all the scores have been chosen. The player with the maximum score wins.

Given an array of scores, predict whether player 1 is the winner.
You can assume each player plays to maximize his score.

Example 1:
Input: [1, 5, 2]
Output: False
Explanation: Initially, player 1 can choose between 1 and 2.
If he chooses 2 (or 1), then player 2 can choose from 1 (or 2) and 5. If player 2 chooses 5, then player 1 will be left with 1 (or 2).
So, final score of player 1 is 1 + 2 = 3, and player 2 is 5.
Hence, player 1 will never be the winner and you need to return False.

Example 2:
Input: [1, 5, 233, 7]
Output: True
Explanation: Player 1 first chooses 1. Then player 2 have to choose between 5 and 7. No matter which number player 2 choose, player 1 can choose 233.
Finally, player 1 has more score (234) than player 2 (12), so you need to return True representing player1 can win.

Note:
1 <= length of the array <= 20.
Any scores in the given array are non-negative integers and will not exceed 10,000,000.
If the scores of both players are equal, then player 1 is still the winner.
* */
public class N486_PredictTheWinner {

    public static void main(String[] args) {
        System.out.println(new N486_PredictTheWinner().PredictTheWinner(new int[]{1,5,233,7}));
        System.out.println(new N486_PredictTheWinner().PredictTheWinner(new int[]{1,5,2}));
    }

    public boolean PredictTheWinner(int[] nums) {
        // dp[i][j]，表示从第 i个元素到第 j个元素的范围中，
        // 下一个取元素的人可以多赢几分
        int[][] dp = new int[nums.length][nums.length];
        // 这里要从大到小进行遍历，原因：判断的过程中有 dp[i+1][j]，如果反过来，该值为 0
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < nums.length; j++) {
                // 即判断两个端点，取哪个端点，会让你获得的利益跟剩下部分能获得的利益差距更大
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        // 返回从 [0, length - 1]整个串第一个取的人能否收益
        return dp[0][nums.length - 1] >= 0;
    }
}
