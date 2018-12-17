package tools;

public class TreeMethod {

    public static void preOrder(TreeNode treeNode) {
        if (treeNode == null) {
            System.out.print(null + " ");
            return;
        }
        System.out.print(treeNode.val + " ");
        preOrder(treeNode.left);
        preOrder(treeNode.right);
    }
}
