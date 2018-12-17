package Page9;

import tools.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
* Given an n-ary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example, given a 3-ary tree:



We should return its level order traversal:

[
     [1],
     [3,2,4],
     [5,6]
]
* */
public class N429_NaryTreeLevelOrderTraversal {

    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) return lists;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> list = new ArrayList<>();
        Node temp = null;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                temp = queue.poll();
                queue.addAll(temp.children);
                list.add(temp.val);
            }
            lists.add(new ArrayList<>(list));
            list.clear();
        }
        return lists;
    }
}
