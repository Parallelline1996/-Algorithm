package Page5;

import tools.TreeNode;

/*
* Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]


             6
           /  \
          2    8
         / \  / \
        0  4 7   9
          / \
         3  5


Example 1:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.
Example 2:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.


Note:

All of the nodes' values will be unique.
p and q are different and both values will exist in the binary tree.
* */
public class N236_LowestCommonAncestorofaBinaryTree {

    // 思路相同，看看两个节点是否在同一侧
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 判断是否左子树里找得到节点，如果找不到，则返回右子树
        // 若右子树里也找不到，则返回根节点
        return left == null ? right : (right == null ? left : root);
    }


    // 效率过于慢
    public TreeNode lowestCommonAncestor_(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return null;
        return traversal(root, p, q);
    }

    private TreeNode traversal(TreeNode root, TreeNode p, TreeNode q) {
        if (helper(root.left, p) && helper(root.left, q)) {
            return traversal(root.left, p, q);
        } else if (helper(root.right, p) && helper(root.right, q)) {
            return traversal(root.right, p, q);
        } else {
            return root;
        }
    }

    private boolean helper(TreeNode root, TreeNode p) {
        return root == p || (root != null && (helper(root.left, p) || helper(root.right, p)));
    }
}
