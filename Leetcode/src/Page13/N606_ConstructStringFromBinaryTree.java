package Page13;

import tools.TreeNode;

/*
* You need to construct a string consists of parenthesis and integers from a binary tree with the preorder traversing way.
The null node needs to be represented by empty parenthesis pair "()".
And you need to omit all the empty parenthesis pairs that don't affect the one-to-one mapping relationship between the
string and the original binary tree.

Example 1:
Input: Binary tree: [1,2,3,4]
       1
     /   \
    2     3
   /
  4

Output: "1(2(4))(3)"

Explanation: Originallay it needs to be "1(2(4)())(3()())",
but you need to omit all the unnecessary empty parenthesis pairs.
And it will be "1(2(4))(3)".
Example 2:
Input: Binary tree: [1,2,3,null,4]
       1
     /   \
    2     3
     \
      4

Output: "1(2()(4))(3)"

Explanation: Almost the same as the first example,
except we can't omit the first parenthesis pair to break the one-to-one mapping relationship between the input and the output.
* */
public class N606_ConstructStringFromBinaryTree {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode a1 = new TreeNode(2);
        TreeNode a2 = new TreeNode(3);
        TreeNode a3 = new TreeNode(4);
        a.left = a1; a1.left = a3; a.right = a2;
        System.out.println(tree2str(a));

        TreeNode b = new TreeNode(1);
        TreeNode b1 = new TreeNode(2);
        TreeNode b2 = new TreeNode(3);
        TreeNode b3 = new TreeNode(4);
        b.left = b1; b1.right = b3; b.right = b2;
        System.out.println(tree2str(b));
    }

    private static String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        treesstr(t, sb);
        return sb.toString();
    }

    private static void treesstr(TreeNode t, StringBuilder sb) {
        if (t == null) {
            return;
        }
        sb.append(t.val);
        if (t.right != null) {
            sb.append("(");
            treesstr(t.left, sb);
            sb.append(")");
            sb.append("(");
            treesstr(t.right, sb);
            sb.append(")");
        } else if (t.left != null){
            sb.append("(");
            treesstr(t.left, sb);
            sb.append(")");
        }
    }
}
