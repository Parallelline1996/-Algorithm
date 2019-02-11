package Page3;

import tools.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
* Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1
Return:

[
   [5,4,11,2],
   [5,8,4,5]
]
* */
public class N113_PathSumII {

    public static void main(String[] args) {

    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) return lists;
        pathSum(root, sum, lists, new ArrayList<>());
        return lists;
    }

    private void pathSum(TreeNode root, int sum, List<List<Integer>> lists, List<Integer> list){
        if (root == null) {
            return;
        }
        list.add(root.val);
        // 判断为从 root-to-leaves 的串，则判断是否符合题意
        if (root.val == sum && root.left == null && root.right == null) {
            lists.add(new ArrayList<>(list));
        } else {
            // 当前节点为中间节点，则继续往下查看其左右节点
            pathSum(root.left, sum - root.val, lists, list);
            pathSum(root.right, sum - root.val, lists, list);
        }
        // 完成这个节点的遍历返回父节点时，要删除当前节点的值
        list.remove(list.size() - 1);
    }
}
