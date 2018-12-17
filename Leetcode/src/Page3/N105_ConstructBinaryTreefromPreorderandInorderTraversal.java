package Page3;

import tools.TreeMethod;
import tools.TreeNode;

import java.util.HashMap;
import java.util.Map;

/*
* Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
* */
public class N105_ConstructBinaryTreefromPreorderandInorderTraversal {

    public static void main(String[] args) {
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        TreeNode a = buildTree(preorder, inorder);
        TreeMethod.preOrder(a);
    }

    private static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) return null;
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private static TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preEnd < preStart || inEnd < inStart) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int i = inStart;
        for (; i <= inEnd; i++) {
            if (inorder[i] == root.val)
                break;
        }
        root.left = buildTree(preorder, preStart + 1, preStart + (i - inStart), inorder, inStart, i - 1);
        root.right = buildTree(preorder, preStart + (i - inStart) + 1, preEnd, inorder, i + 1, inEnd);
        return root;
    }

    private static TreeNode buildTree_(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) return null;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }

    private static TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> map) {
        if (preEnd < preStart || inEnd < inStart) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int i = map.get(root.val);
        root.left = buildTree(preorder, preStart + 1, preStart + (i - inStart), inorder, inStart, i - 1, map);
        root.right = buildTree(preorder, preStart + (i - inStart) + 1, preEnd, inorder, i + 1, inEnd, map);
        return root;
    }
}
