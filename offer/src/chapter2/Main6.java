package chapter2;
import java.util.ArrayList;
import java.util.Stack;

import niuke.assit.ListNode;

/*
 * 输入一个链表，从尾到头打印链表每个节点的值。
 * 
 * 思路：
 * 1.递归
 * 2.栈
 * */
public class Main6 {
	
	public static void main(String[] args) {
		
	}
	
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
    	// 用于返回最后的结果
        ArrayList<Integer> temp = new ArrayList<>();
        
        // 对输入进行判断
        if (listNode == null) {
        	return temp;        	
        }
        
        Stack<ListNode> aIntegers = new Stack<>();
        ListNode head = listNode;
        
        // 进行压栈
        while (head != null) {
            aIntegers.push(head);
            head = head.next;
        }
		
        // 进行出栈
        while (!aIntegers.empty()) {
            temp.add(aIntegers.pop().val);
		}
        return temp;
    }
}