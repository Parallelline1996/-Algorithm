package Page3;

import tools.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
* Given a binary tree, return the postorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [3,2,1]
* */
public class N145_BinaryTreePostorderTraversal {

    public static void main(String[] args) {

    }

    // 把先序规则翻过来，先中间，后右，再左，输出后序遍历的逆序
    public List<Integer> postorderTraversal_(TreeNode root) {
        LinkedList<Integer> lists = new LinkedList<>();
        if (root == null) return lists;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode temp = null;
        while (!stack.isEmpty()) {
            temp = stack.pop();
            lists.addFirst(temp.val);
            if (temp.left != null) {
                stack.push(temp.left);
            }
            if (temp.right != null) {
                stack.push(temp.right);
            }
        }
        return lists;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> lists = new LinkedList<>();
        if (root == null) return lists;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while (!stack.isEmpty() || temp != null) {
            if (temp != null) {
                stack.push(temp);
                lists.addFirst(temp.val);
                temp = temp.right;
            } else {
                temp = stack.pop().left;
            }
        }
        return lists;
    }
}
