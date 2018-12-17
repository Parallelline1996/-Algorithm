package Page2;

import tools.TreeNode;

/*
*Given two binary trees, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
* */
public class N100_SameTree {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode a1 = new TreeNode(2);
        TreeNode a2 = new TreeNode(3);
        a.left = a1; a.right = a2;

        TreeNode b = new TreeNode(1);
        TreeNode b1 = new TreeNode(2);
        TreeNode b2 = new TreeNode(3);
        b.left = b1; b.right = b2;

        System.out.println(isSameTree(a, b));
    }

    // faster
    private static boolean isSameTree1(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && isSameTree1(p.left, q.left) && isSameTree1(p.right, q.right);
    }


    private static boolean isSameTree(TreeNode p, TreeNode q) {
        if (!check(p, q)) {
            return false;
        }
        if (p != null && (!isSameTree(p.left, q.left) || !isSameTree(p.right, q.right))) {
            return false;
        }
        return true;
    }

    private static boolean check(TreeNode p, TreeNode q) {
        return (p == null && q == null) ||
                (p != null && q != null && p.val == q.val);
    }
}
