package Page3;

import tools.TreeNode;

/*
*

Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its minimum depth = 2.
* */
public class N111_MinimumDepthOfBinaryTree {

    public static void main(String[] args) {

    }

    // 思路：比较两个子节点哪个获得了较小的深度，加1并返回
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMinDepth = minDepth(root.left);
        int rightMinDepth = minDepth(root.right);
        // 注意这里要对左右子树的高度进行判断，如果为 0，这一部分是不能取的，【1，2】高度：2
        if (leftMinDepth == 0) {
            return rightMinDepth + 1;
        }
        if (rightMinDepth == 0) {
            return leftMinDepth + 1;
        }
        return leftMinDepth > rightMinDepth? rightMinDepth + 1: leftMinDepth + 1;
    }
}
