package Page14;

import tools.TreeNode;

/*
* Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

The root is the maximum number in the array.
The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
Construct the maximum tree by the given array and output the root node of this tree.

Example 1:
Input: [3,2,1,6,0,5]
Output: return the tree root node representing the following tree:

      6
    /   \
   3     5
    \    /
     2  0
       \
        1
Note:
The size of the given array will be in the range [1,1000].
* */
public class N654_MaximumBinaryTree {

    public static void main(String[] args) {
        TreeNode a = constructMaximumBinaryTree(new int[]{3,2,1,6,0,5});
        System.out.println(a.val);
        System.out.println(a.left.val);
        System.out.println(a.right.val);
    }

    private static TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length < 1) {
            return null;
        }
        return constructMaximumBinaryTree(new TreeNode(1), nums, 0, nums.length - 1);
    }

    private static TreeNode constructMaximumBinaryTree(TreeNode root, int[] nums, int start, int end) {
        if (end < start) {
            return null;
        }
        // 对数组进行切分
        int max = Integer.MIN_VALUE, index = 0;
        for (int i = start; i <= end; i++) {
            if (nums[i] > max) {
                index = i;
                max = nums[i];
            }
        }
        // 对节点进行赋值
        root.val = nums[index];
        root.left = constructMaximumBinaryTree(new TreeNode(0), nums, start, index - 1);
        root.right = constructMaximumBinaryTree(new TreeNode(0), nums, index + 1, end);
        return root;
    }
}
