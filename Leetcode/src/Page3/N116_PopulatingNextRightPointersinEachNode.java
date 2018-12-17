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
Populate each next pointer to point to its next right node.
If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
Recursive approach is fine, implicit stack space does not count as extra space for this problem.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
Example:

Given the following perfect binary tree,

     1
   /  \
  2    3
 / \  / \
4  5  6  7
After calling your function, the tree should look like:

     1 -> NULL
   /  \
  2 -> 3 -> NULL
 / \  / \
4->5->6->7 -> NULL
* */
public class N116_PopulatingNextRightPointersinEachNode {

    public static void main(String[] args) {

    }

    // 用层序遍历，将每一层都连起来
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int number = queue.size();
            TreeLinkNode head = queue.peek();
            for (int i = 0; i < number; i++) {
                TreeLinkNode temp = queue.poll();
                if (i != 0) {
                    head.next = temp;
                    head = temp;
                }
                if (temp.left != null){
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
        }
    }
}
