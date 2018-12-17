package Page12;

import tools.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
*

Given an n-ary tree, return the preorder traversal of its nodes' values.

For example, given a 3-ary tree:


Return its preorder traversal as: [1,3,5,6,2,4].


Note:

Recursive solution is trivial, could you do it iteratively?
使用迭代，不要使用递归求
* */
public class N589_N_aryTreePreorderTraversal {

    public static void main(String[] args) {

    }

    public List<Integer> preorder(Node root) {
        List<Integer> lists = new LinkedList<>();
        if (root == null) {
            return lists;
        }
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        Node temp = null;
        while (!stack.isEmpty()) {
            temp = stack.pop();
            int num = temp.children.size();
            for (int i = num - 1 ; i >= 0; i--) {
                stack.add(temp.children.get(i));
            }
            lists.add(temp.val);
        }
        return lists;
    }
}
