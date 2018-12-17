package Page3;

import tools.TreeNode;


/*
* Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up
* all the values along the path equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \      \
7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
* */
public class N112_PathSum {

    public static void main(String[] args) {

    }

    public boolean hasPathSum(TreeNode root, int sum) {
        // 对题目的输入进行判断，若空则返回
        return root != null && hasPathSum1(root, sum);
    }

    /*
    * 两种情况：
    * ① 输入节点为叶子节点，且符合要求
    * ② 输入节点为内部节点，判断其孩子节点中是否有符合要求的题目
    * */
    private static boolean hasPathSum1(TreeNode root, int sum) {
        return (root.val == sum && root.left == null && root.right == null)
                || (root.left != null && hasPathSum1(root.left, sum - root.val))
                || (root.right != null && hasPathSum1(root.right, sum - root.val));
    }
}
