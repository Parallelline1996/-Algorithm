package Page5;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

/*
* Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
* You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.

Example:
Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
Output: [3,3,5,5,6,7]

Explanation:
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7

Note:
You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.

Follow up:
Could you solve it in linear time?
* */
public class N239_SlidingWindowMaximum {

    public static void main(String[] args) {
        int[] a = maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);
        for (int i : a
             ) {
            System.out.print(i + " ");
        }

    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) return new int[]{};
        Deque<Integer> deque = new ArrayDeque<>();
        // 用于保存要输出的结果
        int[] output = new int[nums.length - k + 1];
        int outputSize = 0;
        for (int i = 0; i < nums.length; i++) {
            // 保持 deque的左侧元素在滑窗范围内
            if (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }

            // 判断 deque中的成员与即将进入 deque的元素的大小
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // 将新成员加入 deque
            deque.offer(i);

            // 输出到输出数组
            if (i >= k - 1) {
                output[outputSize] = nums[deque.peek()];
                outputSize++;
            }
        }
        return output;
    }
}