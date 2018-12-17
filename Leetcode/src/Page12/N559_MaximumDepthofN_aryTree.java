package Page12;

import tools.Node;

/*
* Given a n-ary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

For example, given a 3-ary tree:
We should return its max depth, which is 3.

Note:
The depth of the tree is at most 1000.
The total number of nodes is at most 5000
* */
public class N559_MaximumDepthofN_aryTree {

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int max = 0;
        for (Node childNode : root.children
             ) {
            int value = maxDepth(childNode);
            if (value > max) {
                max = value;
            }
        }
        return max + 1;
    }
}
