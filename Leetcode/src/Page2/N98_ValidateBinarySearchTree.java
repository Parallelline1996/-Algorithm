package Page2;

import tools.TreeNode;

import java.util.ArrayList;

/*
* Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Example 1:

Input:
    2
   / \
  1   3
Output: true
Example 2:

    5
   / \
  1   4
     / \
    3   6
Output: false
Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
             is 5 but its right child's value is 4.
* */
public class N98_ValidateBinarySearchTree {


    public static void main(String[] args) {
        N98_ValidateBinarySearchTree Main = new N98_ValidateBinarySearchTree();
        TreeNode a = new TreeNode(1);
        a.left = new TreeNode(1);
        System.out.println(Main.isValidBST(a));
    }

    /**
     * 注意这道题的二叉搜索树，是左子树比根节点小，右子树比根节点大，并没有出现相等的情况
     *
     * @param root 传入根节点
     * @return 判断是否为二叉搜索树
     */
    private boolean isValidBST(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return true;
        ArrayList<Integer> arrayList = new ArrayList<>();
        inorderTraversal(root, arrayList);
        for (int i = 0; i < arrayList.size() - 1; i++) {
            if (arrayList.get(i) >= arrayList.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    private void inorderTraversal(TreeNode root, ArrayList<Integer> arrayList) {
        if (root == null) return;
        inorderTraversal(root.left, arrayList);
        arrayList.add(root.val);
        inorderTraversal(root.right, arrayList);
    }

}
