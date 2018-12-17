package Page17;

import tools.TreeNode;

/*
* We are given the head node root of a binary tree, where additionally every node's value is either a 0 or a 1.

Return the same tree where every subtree (of the given tree) not containing a 1 has been removed.

(Recall that the subtree of a node X is X, plus every node that is a descendant of X.)

Example 1:
Input: [1,null,0,0,1]
Output: [1,null,0,null,1]

Explanation:
Only the red nodes satisfy the property "every subtree not containing a 1".
The diagram on the right represents the answer.


Example 2:
Input: [1,0,1,0,0,0,1]
Output: [1,null,1,null,1]



Example 3:
Input: [1,1,0,1,1,0,1,0]
Output: [1,1,0,1,1,null,1]



Note:

The binary tree will have at most 100 nodes.
The value of each node will only be 0 or 1
* */
public class N814_BinaryTreePruning {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode a1 = new TreeNode(0);
        TreeNode a2 = new TreeNode(0);
        TreeNode a3 = new TreeNode(1);
        a.right = a1;
        a1.left = a2; a1.right = a3;
        pruneTree(a);
        System.out.println(a.val);
        System.out.println(a.right.val);
    }

    /*
    * 分别判断当前节点的左右节点是否需要删除，
    * 之后在返回当前节点是否需要删除的信息
    * */
    private static boolean isDelete(TreeNode root) {
        boolean needDeleteLeft = true;
        boolean needDeleteRight = true;
        if (root.left != null) {
            if (isDelete(root.left)) {
                root.left = null;
            } else {
                needDeleteLeft = false;
            }
        }
        if (root.right != null) {
            if (isDelete(root.right)) {
                root.right = null;
            } else {
                needDeleteRight = false;
            }
        }
        return (needDeleteLeft && needDeleteRight) && !(root.val == 1);
    }

    private static TreeNode pruneTree(TreeNode root) {
        if (root != null) {
            isDelete(root);
        }
        return root;
    }
    /*
    *
    * */
}
