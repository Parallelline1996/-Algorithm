package Page3;

import tools.TreeNode;

public class N104_MaximumDepthOfBinaryTree {

    public static void main(String[] args) {

    }

    private static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.right) + 1, maxDepth(root.left) + 1);
    }
}
