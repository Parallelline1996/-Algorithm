package Page3;

import tools.TreeLinkNode;

import java.util.LinkedList;
import java.util.Queue;

/*
* Given a binary tree

struct TreeLinkNode {
  TreeLinkNode *left;
  TreeLinkNode *right;
  TreeLinkNode *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
Recursive approach is fine, implicit stack space does not count as extra space for this problem.
Example:

Given the following binary tree,

     1
   /  \
  2    3
 / \    \
4   5    7
After calling your function, the tree should look like:

     1 -> NULL
   /  \
  2 -> 3 -> NULL
 / \    \
4-> 5 -> 7 -> NULL
* */
public class N117_PopulatingNextRightPointersInEachNodeII {

    public static void main(String[] args) {

    }

    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeLinkNode head = queue.peek();
            int number = queue.size();
            for (int i = 0; i < number; i++) {
                TreeLinkNode cur = queue.poll();
                if (i != 0) {
                    head.next = cur;
                    head = cur;
                }
                if (cur.left != null){
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
        }
    }
}
