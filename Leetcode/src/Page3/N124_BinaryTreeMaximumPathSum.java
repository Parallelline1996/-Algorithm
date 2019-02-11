package Page3;

import tools.TreeNode;

/*
* Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some
starting node to any node in the tree along the parent-child connections.
The path must contain at least one node and does not need to go through the root.

Example 1:
Input: [1,2,3]

       1
      / \
     2   3

Output: 6

Example 2:
Input: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

Output: 42
* */
public class N124_BinaryTreeMaximumPathSum {

    public static void main(String[] args) {

    }

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        helper(root);
        return max;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;
        // 分别求出能从左右子树中获得的最大值，如果为负，则抛弃子树
        int left = Math.max(0, helper(root.left));
        int right = Math.max(0, helper(root.right));
        // 比较包含这个根节点的最大值路径跟 max的大小
        max = Math.max(max, left + right + root.val);
        return Math.max(left, right) + root.val;
    }

}
