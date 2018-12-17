package Page2;

import tools.TreeNode;

import java.util.*;

/*
* Given a binary tree, return the inorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]
* */
public class N94_BinaryTreeInorderTraversal {

    public static void main(String[] args) {

    }


    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root, temp = null;
        List<Integer> lists = new ArrayList<>();
        if (root == null) return lists;
        // 判断条件：所有栈为空，且节点指向为空，即所有节点已经完成遍历
        while (!stack.isEmpty() || node != null) {
            // 向左搜索，寻找最左的节点，即中序遍历的第一个节点
            while (node != null) {
                stack.add(node);
                node = node.left;
            }
            // 对每一个节点进行判断
            if (!stack.empty()) {
                // 获取当前节点
                temp = stack.pop();
                // 遍历该节点
                lists.add(temp.val);
                // 如果该节点为内部节点，则按中序遍历的顺序，遍历其右子节点
                node = temp.right;
            }
        }
        return lists;
    }
}
