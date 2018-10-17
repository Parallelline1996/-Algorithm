package Page3;

/*
* 给定一个二叉树，检查它是否是镜像对称的。
*
* 思路：
* 写一个遍历顺序相反的前序遍历
* */
public class N101_SymmetricTree {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode a1 = new TreeNode(2);
        TreeNode a2 = new TreeNode(2);
        TreeNode a3 = new TreeNode(3);
        TreeNode a4 = new TreeNode(3);
        TreeNode a5 = new TreeNode(4);
        TreeNode a6 = new TreeNode(4);
        a.left = a1; a.right = a2;
        a1.left = a3; a1.right = a5;
        a2.left = a6; a2.right = a4;
        System.out.println(isSymmetric(a));
    }

    private static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        String a = sb.toString();
        sb = new StringBuilder(a.length());
        preorderReserve(root, sb);
//        System.out.println(a);
//        System.out.println(sb.toString());
        return a.equals(sb.toString());
    }

    private static void preorder(TreeNode node, StringBuilder sb) {
        if (node == null) {
            return;
        }
        sb.append(node.val);
        if (node.left == null) {
            sb.append("n");
        } else {
            preorder(node.left, sb);
        }
        if (node.right == null) {
            sb.append("n");
        } else {
            preorder(node.right, sb);
        }
    }

    private static void preorderReserve(TreeNode node, StringBuilder sb) {
        if (node == null) {
            return;
        }
        sb.append(node.val);
        if (node.right == null) {
            sb.append("n");
        } else {
            preorderReserve(node.right, sb);
        }
        if (node.left == null) {
            sb.append("n");
        } else {
            preorderReserve(node.left, sb);
        }
    }
}
