package Page5;

import tools.TreeNode;

/*
* 翻转一棵二叉树。
* */
public class N226_InvertBinaryTree {

    public static void main(String[] args) {

    }

    private static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
