package chapter2;

import java.util.Stack;

/*
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * */
public class Main9 {
	public static void main(String[] args) {
		
	}
	
	// 这个用于进栈
    private static Stack<Integer> stack1 = new Stack<Integer>();
	// 这个用于出栈
	private static Stack<Integer> stack2 = new Stack<Integer>();
	
	// 实现入队列操作
	public static void push(int node) {
		stack1.push(node);
	}
	    
	// 出队列
	public static int pop() {
		// 查看用于出栈的栈是否空
		if (!stack2.isEmpty()) {
			return stack2.pop();
		} else {
			// 当用于出栈的栈为空时，将所有用于入栈的栈里的元素全部移动到出栈的
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		return stack2.pop();
	}
}
