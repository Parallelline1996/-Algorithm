package Page18;

import tools.TreeMethod;
import tools.TreeNode;

/*
* Return any binary tree that matches the given preorder and postorder traversals.

Values in the traversals pre and post are distinct positive integers.



Example 1:

Input: pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
Output: [1,2,3,4,5,6,7]


Note:

1 <= pre.length == post.length <= 30
pre[] and post[] are both permutations of 1, 2, ..., pre.length.
It is guaranteed an answer exists. If there exists multiple answers, you can return any of them.
* */
public class N889_ConstructBinaryTreefromPreorderandPostorderTraversal {

    public static void main(String[] args) {
        int[] pre = new int[]{1,2,4,5,3,6,7};
        int[] post = new int[]{4,5,2,6,7,3,1};
        TreeNode a = constructFromPrePost(pre, post);
        TreeMethod.preOrder(a);
    }

    private static TreeNode constructFromPrePost(int[] pre, int[] post) {
        if (pre == null || post == null || post.length != pre.length) return null;
        return constructTree(0, pre.length - 1, 0, post.length - 1, pre, post);
    }

    private static TreeNode constructTree(int preStart, int preEnd, int postStart, int postEnd,
                                          int[] pre, int[] post) {
        if (preEnd < preStart || postEnd < postStart) return null;
        TreeNode root = new TreeNode(pre[preStart]);
        if (preEnd == preStart) return root;
        int i = postStart;
        for (; i <= postEnd; i++) {
            if (post[i] == pre[preStart + 1])
                break;
        }
        root.left = constructTree(preStart + 1, preStart + 1 + (i - postStart), postStart, i, pre, post);
        root.right = constructTree(preStart + 1 + (i - postStart) + 1, preEnd, i + 1, postEnd - 1, pre, post);
        return root;
    }
}
