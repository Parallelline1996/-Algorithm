package Page6;

import tools.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
* Given a binary tree, return all root-to-leaf paths.

Note: A leaf is a node with no children.

Example:

Input:

   1
 /   \
2     3
 \
  5

Output: ["1->2->5", "1->3"]

Explanation: All root-to-leaf paths are: 1->2->5, 1->3
* */
public class N257_BinaryTreePaths {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode a1 = new TreeNode(2);
        TreeNode a2 = new TreeNode(3);
        TreeNode a3 = new TreeNode(5);
        a.left = a1; a.right = a2; a1.right = a3;
        List<String> lists = binaryTreePaths1(a);
        System.out.println(lists.toString());
    }

    private static List<String> binaryTreePaths(TreeNode root) {
        List<String> lists = new ArrayList<>();
        if (root == null) return lists;
        helper(root, new StringBuilder(), lists);
        return lists;
    }

    private static void helper(TreeNode root, StringBuilder sb, List<String> lists) {
        if (root == null) return;
        int length = sb.length();
        sb.append("->");
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            lists.add(sb.toString().substring(2));
            sb.delete(length, sb.length());
            return;
        }
        helper(root.left, sb, lists);
        helper(root.right, sb, lists);
        if (length != sb.length()) {
            sb.delete(length, sb.length());
        }
    }

    // 直接用string，还可以省去删除的操作
    private static List<String> binaryTreePaths1(TreeNode root) {
        List<String> lists = new ArrayList<>();
        if (root == null) return lists;
        helper(root, "" + root.val, lists);
        return lists;
    }

    private static void helper(TreeNode root, String path, List<String> lists) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            lists.add(path);
            return;
        }
        if (root.left != null) {
            helper(root.left, path + "->" + root.left.val, lists);
        }
        if (root.right != null) {
            helper(root.right, path + "->" + root.right.val, lists);
        }
    }
}
