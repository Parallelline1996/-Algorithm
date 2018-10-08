package chapter2;

import java.util.LinkedList;
import java.util.Queue;

import niuke.assit.TreeNode;

/*
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回
 * */
public class Main7 {
	public static void main(String[] args) {
		int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
		int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
		TreeNode treeNode = reConstructBinaryTree(pre, in);
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(treeNode);
		while(!queue.isEmpty()) {
			TreeNode temp = queue.poll();
			if (temp.left != null) {
				queue.offer(temp.left);
			}
			if (temp.right != null) {
				queue.offer(temp.right);
			}
			System.out.print(temp.val + "  ");
		}
	}
	
	public static TreeNode reConstructBinaryTree(int[] pre, int pre_start, int pre_end, 
			int[] in, int in_start, int in_end) {
		// 判断是否符合要求
		if (pre_start > pre_end || in_start  > in_end) {
			return null;
		}
		
		TreeNode root = new TreeNode(pre[pre_start]);
		
		// 根据先序和中序的特点，通过先序确定根节点，再使用根节点的位置对中序进行划分
		for (int i = in_start; i <= in_end; i++) {
			// 中序的划分： 左子树：in_start ~ i - 1; 右子树： i + 1 ~ in_end;
			// 前序的划分： 左子树：pre_start + 1 ~ pre_start + (i - in_start); 右子树：pre_start + (i - in_start) + 1 ~ pre_end
			// 原因：对于中序遍历，i刚好就是划分左右子树的中间值，所以分成两个，一边从头到i-1，一边从i+1到结束
			// 对于先序遍历，因为每次都是先取走pre[pre_start],所以实际上是划分pre[]的pre_start + 1 ~ pre_end,划分成两段
			// 重点就是将前后分开，通过中序确定前序的左右子树的大小，进而进行划分
			if (in[i] == pre[pre_start]) {
				// 先序遍历的理解也可以理解为：通过中序来判断前序左侧的数目
				root.left = reConstructBinaryTree(pre, pre_start + 1, pre_start + i - in_start, in, in_start, i - 1);
				root.right = reConstructBinaryTree(pre, pre_start + i - in_start + 1, pre_end, in, i + 1, in_end);
				break;
			}
		}
		return root;
	}
	
	public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		if (pre.length != in.length) {
			return null;
		}
		return reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
	}
}
