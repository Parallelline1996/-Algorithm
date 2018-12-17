package Page3;

import tools.TreeNode;

import java.util.*;

public class N107_BinaryTreeLevelOrderTraversalII {

    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<List<Integer>> stack = new Stack<>();
        queue.add(root);
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> arrays = new ArrayList<>();
        TreeNode temp = null;
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                temp = queue.poll();
                arrays.add(temp.val);
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
            stack.add(new ArrayList<>(arrays));
            arrays.clear();
        }
        while (!stack.isEmpty()) {
            lists.add(stack.pop());
        }
        return lists;
    }
}
