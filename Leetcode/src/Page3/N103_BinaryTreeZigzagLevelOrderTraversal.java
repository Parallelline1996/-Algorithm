package Page3;

import java.util.*;

/*
* 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行
* */
public class N103_BinaryTreeZigzagLevelOrderTraversal {

    /*
    *        3
    *       /\
    *      9 20
    *        /\
    *       15 7
    * */
    public static void main(String[] args) {
        TreeNode a = new TreeNode(3);
        TreeNode a1 = new TreeNode(9);
        TreeNode a2 = new TreeNode(20);
        TreeNode a3 = new TreeNode(15);
        TreeNode a4 = new TreeNode(7);
        a.left = a1; a.right = a2;
        a2.left = a3; a2.right = a4;
        List<List<Integer>> lists = zigzagLevelOrder(a);
        for (List<Integer> b : lists
             ) {
            for (int i = 0; i < b.size(); i++) {
                System.out.print(b.get(i) + " ");
            }
            System.out.println();
        }
    }

    private static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> arrays = new ArrayList<>();
        TreeNode temp = null;
        int number = 2;
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
            if (number % 2 != 0) {
                List<Integer> a = new ArrayList<>(arrays.size());
                for (int k = arrays.size() - 1; k >= 0; k--) {
                    a.add(arrays.get(k));
                }
                arrays = a;
            }
            lists.add(new ArrayList<>(arrays));
            arrays.clear();
            number++;
        }
        return lists;
    }
}
