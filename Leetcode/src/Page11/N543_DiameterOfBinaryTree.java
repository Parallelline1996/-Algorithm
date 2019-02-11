package Page11;

import tools.TreeNode;

import java.util.HashMap;
import java.util.Map;

/*
* Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

Example:
Given a binary tree
          1
         / \
        2   3
       / \
      4   5
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

Note: The length of path between two nodes is represented by the number of edges between them.

* */
public class N543_DiameterOfBinaryTree {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode a1 = new TreeNode(2);
        TreeNode a2 = new TreeNode(3);
        TreeNode a3 = new TreeNode(4);
        TreeNode a4 = new TreeNode(5);
        a.left = a1; a.right = a2;
        a1.left = a3; a1.right = a4;
        System.out.println(diameterOfBinaryTree1(a));
    }

    // 用全局变量，速度会加快
    private static int diameterOfBinaryTree1(TreeNode root) {
        if(root == null){
            return 0;
        }
        int dia = depth(root.left) + depth(root.right);
        int ldia = diameterOfBinaryTree1(root.left);
        int rdia = diameterOfBinaryTree1(root.right);
        return Math.max(dia,Math.max(ldia,rdia));

    }

    private static int depth(TreeNode root){
        if(root == null){
            return 0;
        }
        return 1 + Math.max(depth(root.left), depth(root.right));
    }

    // 用 Map 优化，速度从 16ms -> 12ms
    private static int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Map<TreeNode, Integer> map = new HashMap<>();
        buildDepthMap(root, map);
        map.put(null, 0);
        // 因为算的是 edge，并不是算点数
        return diameterOfBinaryTree(root, map) - 1;
    }

    private static int diameterOfBinaryTree(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null) return 0;
        int withTheRoot = map.get(root.left) + map.get(root.right) + 1;
        int left = diameterOfBinaryTree(root.left, map);
        int right = diameterOfBinaryTree(root.right, map);
        return Math.max(withTheRoot, Math.max(left, right));
    }


    private static int buildDepthMap(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null) return 0;
        int depth = 1 + Math.max(buildDepthMap(root.left, map), buildDepthMap(root.right, map));
        map.put(root, depth);
        return depth;
    }

    // 用全局变量，这个速度最快
    int max = 0;
    public int diameterOfBinaryTree2(TreeNode root) {
        helper(root);
        return max;
    }

    public int helper(TreeNode root){
        if(root==null)return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        max = Math.max(max,left+right);
        return Math.max(left,right)+1;
    }
}
