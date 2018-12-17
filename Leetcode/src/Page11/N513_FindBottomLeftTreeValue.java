package Page11;

import tools.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/*
Given a binary tree, find the leftmost value in the last row of the tree.

Example 1:
Input:

    2
   / \
  1   3

Output:
1
Example 2:
Input:

        1
       / \
      2   3
     /   / \
    4   5   6
       /
      7

Output:
7
* */
public class N513_FindBottomLeftTreeValue {

    public static void main(String[] args) {

    }

    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int output = root.val;
        while (!queue.isEmpty()) {
            int num = queue.size();
            TreeNode cur = null;
            for (int i = 0; i < num; i++) {
                cur = queue.poll();
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
                if (i == 0) {
                    output = cur.val;
                }
            }
        }
        return output;
    }
}
