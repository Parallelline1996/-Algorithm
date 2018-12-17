package Page9;

import tools.TreeNode;

/*
* Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
* */
public class N404_SumOfLeftLeaves {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode a1 = new TreeNode(2);
        TreeNode a2 = new TreeNode(3);
        TreeNode a3 = new TreeNode(4);
        TreeNode a4 = new TreeNode(5);
        a.left = a1; a.right = a2;
        a1.left = a3; a1.right = a4;
        System.out.println(sumOfLeftLeaves(a));
    }

    private static int sumOfLeftLeaves(TreeNode root) {
        return sumOfLeftLeaves(root, false);
    }

    private static int sumOfLeftLeaves(TreeNode root, boolean isLeftTree) {
        if (root == null) {
            return 0;
        }
        return (isLeftTree && root.left == null && root.right == null)?
                root.val: sumOfLeftLeaves(root.left, true) + sumOfLeftLeaves(root.right, false);
    }
}
