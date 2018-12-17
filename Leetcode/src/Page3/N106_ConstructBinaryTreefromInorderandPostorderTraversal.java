package Page3;

import tools.TreeMethod;
import tools.TreeNode;

import java.util.HashMap;
import java.util.Map;

/*
* Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
* */
public class N106_ConstructBinaryTreefromInorderandPostorderTraversal {

    public static void main(String[] args) {
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        int[] postorder = new int[]{9, 15, 7, 20, 3};
        TreeNode a = buildTree(inorder, postorder);
        TreeMethod.preOrder(a);
    }

    private static TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length) return null;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(0, inorder.length - 1, 0, postorder.length - 1, inorder, postorder, map);
    }

    private static TreeNode buildTree(int inStart, int inEnd, int postStart, int postEnd,
                                      int[] inorder, int[] postorder, Map<Integer, Integer> map) {
        if (inEnd < inStart || postEnd < postStart) return null;
        TreeNode root = new TreeNode(postorder[postEnd]);
        int i = map.get(root.val);
        root.left = buildTree(inStart, i - 1, postStart, postStart + (i - inStart) - 1, inorder, postorder, map);
        root.right = buildTree(i + 1, inEnd, postStart + (i - inStart), postEnd - 1, inorder, postorder, map);
        return root;
    }
}
