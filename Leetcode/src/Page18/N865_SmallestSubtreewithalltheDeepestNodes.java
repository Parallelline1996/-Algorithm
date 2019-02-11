package Page18;

import tools.TreeNode;

import java.util.HashMap;
import java.util.Map;

/*
* Given a binary tree rooted at root, the depth of each node is the shortest distance to the root.
A node is deepest if it has the largest depth possible among any node in the entire tree.
The subtree of a node is that node, plus the set of all descendants of that node.
Return the node with the largest depth such that it contains all the deepest nodes in its subtree.

Example 1:
Input: [3,5,1,6,2,0,8,null,null,7,4]
Output: [2,7,4]
Explanation:
                    3
                  /   \
                 5     1
                / \   / \
               6  2  0   8
                 / \
                7  4
We return the node with value 2, colored in yellow in the diagram.
The nodes colored in blue are the deepest nodes of the tree.
The input "[3, 5, 1, 6, 2, 0, 8, null, null, 7, 4]" is a serialization of the given tree.
The output "[2, 7, 4]" is a serialization of the subtree rooted at the node with value 2.
Both the input and output have TreeNode type.

Note:
The number of nodes in the tree will be between 1 and 500.
The values of each node are unique.
* */
public class N865_SmallestSubtreewithalltheDeepestNodes {

    public static void main(String[] args) {

    }

    // 思路：从根部开始，当某个节点的左右子树深度相同时，则该节点包含了所有最大深度的子节点
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null) return null;
        if (depth(root.left) == depth(root.right)) {
            return root;
        } else {
            if (depth(root.left) > depth(root.right)) {
                return subtreeWithAllDeepest(root.left);
            } else {
                return subtreeWithAllDeepest(root.right);
            }
        }
    }

    private static int depth(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        return leftDepth > rightDepth? leftDepth + 1: rightDepth + 1;
    }

    // 使用 map 进行优化，优化效果一般
    public TreeNode subtreeWithAllDeepest1(TreeNode root) {
        if (root == null) return null;
        Map<Integer, Integer> map = new HashMap<>();
        int leftDepth = depth(root.left, map);
        int rightDepth = depth(root.right, map);
        if (leftDepth == rightDepth) {
            return root;
        } else {
            if (leftDepth > rightDepth) {
                return subtreeWithAllDeepest1(root.left);
            } else {
                return subtreeWithAllDeepest1(root.right);
            }
        }
    }

    private static int depth(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) return 0;
        if (map.containsKey(root.val)) {
            return map.get(root.val);
        }
        int leftDepth = depth(root.left, map);
        int rightDepth = depth(root.right, map);
        int depth = leftDepth > rightDepth? leftDepth + 1: rightDepth + 1;
        map.put(root.val, depth);
        return depth;
    }

    private int max = 0;
    private Map<TreeNode,Integer> map = new HashMap();

    // 可以考虑直接把 map 先 build
    private void buildmap(TreeNode node,TreeNode parent){
        if (node == null) return;
        int tmp = map.get(parent) + 1;
        max = Math.max(max, tmp);
        map.put(node, tmp);
        buildmap(node.left, node);
        buildmap(node.right, node);
    }

}
