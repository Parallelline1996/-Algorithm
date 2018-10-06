package Method;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeMethod {

    /*
    * leetcode
    * Given a binary tree, return the bottom-up level order traversal of
    * its nodes' values. (ie, from left to right, level by level from leaf
    * to root).
    * */
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> output = new ArrayList<>();
        if (root == null) {
            return output;
        }
        Stack<ArrayList<Integer>> stack = new Stack<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int number;
        TreeNode temp = null;
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (!queue.isEmpty()) {
            number = queue.size();
            for (int i = 0; i < number; i++) {
                temp = queue.poll();
                arrayList.add(temp.val);
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
            stack.add(new ArrayList<Integer>(arrayList));
            arrayList.clear();
        }
        while (!stack.isEmpty()) {
            output.add(stack.pop());
        }
        return output;
    }

    /*
    * leetcode
    * Given a binary tree, determine if it is height-balanced.
    * For this problem, a height-balanced binary tree is defined as a binary tree
    * in which the depth of the two subtrees of every node never differ by more than 1.
    * */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // 遍历所有节点
        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();
            // 分别计算每个点左右子树的深度。判断是否符合条件
            if (Math.abs(countDepth(temp.left, 0) - countDepth(temp.right, 0)) > 1) {
                return false;
            }
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
        return true;
    }

    // 计算深度
    public static int countDepth(TreeNode root, int number) {
        if (root == null) {
            return number;
        }
        if (root.right == null & root.left == null) {
            return number + 1;
        }
        int leftDepth = countDepth(root.left, number + 1);
        int rightDepth = countDepth(root.right, number + 1);
        return leftDepth > rightDepth ? leftDepth : rightDepth;
    }

    /*
    * leetcode
    * Given a binary tree and a sum, determine if the tree has a root-to-leaf path
    * such that adding up all the values along the path equals the given sum.
    * */
    private boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        sum -= root.val;
        if (sum == 0 & root.left == null & root.right == null) {
            return true;
        }
        return hasPathSum(root.left, sum) | hasPathSum(root.right, sum);
    }

    /*
    * leecode
    * Given a binary tree and a sum, find all root-to-leaf paths
    * where each path's sum equals the given sum.
    * */
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        pathSum(root, 0, sum, new ArrayList<Integer>(), list);
        return list;
    }

    private static void pathSum(TreeNode root, int sum, int target,
                               ArrayList<Integer> array, ArrayList<ArrayList<Integer>> output) {
        if (root == null) {
            return;
        }
        if (root.left == null & root.right == null & (sum + root.val) == target) {
            array.add(root.val);
            // 这里将符合条件的结果复制到一个新的位置
            output.add(new ArrayList<>(array));
            array.remove(array.size() - 1);
            return;
        }
        sum += root.val;
        array.add(root.val);
        pathSum(root.left, sum, target, array, output);
        pathSum(root.right, sum, target, array, output);
        array.remove(array.size() - 1);
    }

    /*
    * 将每一层都用next指针连起来，from leetcode
    * */
    public void populatingNextRightPointersInEachNode(TreeLinkNode root) {
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int number = queue.size();
            TreeLinkNode head = queue.peek();
            // 通过判断循环的数目，来分层
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

    // Sequence traversal 层序遍历
    public Integer[] sequenceTraversal(TreeNode root) {
        ArrayList<Integer> numbers = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root.left != null){
                queue.add(root.left);
            }
            if (root.right != null) {
                queue.add(root.right);
            }
            numbers.add(root.val);
        }
        Integer[] output = new Integer[numbers.size()];
        numbers.toArray(output);
        return output;
    }

    /*
    * The root-to-leaf path1->2represents the number12.
      The root-to-leaf path1->3represents the number13.
      Return the sum = 12 + 13 =25
    * */
    public int sumRootToLeafNumbers(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }
        return sumRootToLeafNumbers(root.left, sum) + sumRootToLeafNumbers(root.right, sum);
    }

    // 后序遍历
    private static void postorder(ArrayList<Integer> array, TreeNode root) {
        if (root == null) {
            return;
        }
        postorder(array, root.left);
        postorder(array, root.right);
        array.add(root.val);
    }

    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> output = new ArrayList<>();
        inorderTraversal(output, root);
        return output;
    }

    private static void inorderTraversal(ArrayList<Integer> arrayList, TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(arrayList, root.left);
        arrayList.add(root.val);
        inorderTraversal(arrayList, root.right);
    }

    // 后序遍历
    public static void postorder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        postorder(treeNode.left);
        postorder(treeNode.right);
        System.out.print(treeNode.val + " ");
    }

    // 后序遍历 非递归
    public static void postorder_(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = treeNode, temp = null;
        // 判断条件：所有栈为空，且节点指向为空，即所有节点已经完成遍历
        while (!stack.isEmpty() || node != null) {
            // 向左探索
            while (node != null) {
                stack.add(node);
                node = node.left;
            }
            // 这里要判断是否为第几次遍历
            if (!stack.empty()) {
                temp = stack.peek();
                if (temp.isFirst) {
                    temp = stack.pop();
                    System.out.print(temp.val + " ");
                } else {
                    temp.isFirst = true;
                    node = temp.right;
                }
            }
        }
    }

    // 中序遍历
    public static void inorder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        inorder(treeNode.left);
        System.out.print(treeNode.val + " ");
        inorder(treeNode.right);
    }

    // 中序遍历 非递归
    public static void inorder_(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root, temp = null;
        // 判断条件：所有栈为空，且节点指向为空，即所有节点已经完成遍历
        while (!stack.isEmpty() || node != null) {
            // 向左探索
            while (node != null) {
                stack.add(node);
                node = node.left;
            }
            // 每次出栈的时候进行读取
            if (!stack.empty()) {
                temp = stack.pop();
                System.out.print(temp.val + " ");
                node = temp.right;
            }
        }
    }

    // 前序遍历
    public static void preorder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.print(treeNode.val + " ");
        preorder(treeNode.left);
        preorder(treeNode.right);
    }

    // 前序遍历 -> 非递归
    public static void preorder_(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        TreeNode temp = null;
        while (!stack.isEmpty()) {
            temp = stack.pop();
            System.out.print(temp.val + " ");
            if (temp.right != null) {
                stack.add(temp.right);
            }
            if (temp.left != null) {
                stack.add(temp.left);
            }
        }
    }

    // 输出每个节点的深度
    private static void depth(TreeNode treeNode, int height) {
        if (treeNode == null) {
            return;
        }
        System.out.println(treeNode.val + " " + height);
        depth(treeNode.left, height + 1);
        depth(treeNode.right, height + 1);
    }

    // 输出最小深度
    // 思路：比较两个子节点哪个获得了较小的深度，加1并返回
    private static int minDepth(TreeNode treeNode) {
        int leftMin, rightMin;
        if (treeNode == null) {
            return Integer.MAX_VALUE;
        }
        if (treeNode.left == null && treeNode.right == null) {
            return 1;
        } else {
            leftMin = minDepth(treeNode.left);
            rightMin = minDepth(treeNode.right);
            return leftMin > rightMin ? rightMin + 1 : leftMin + 1;
        }
    }
}
