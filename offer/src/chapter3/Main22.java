package chapter3;

import niuke.assit.ListNode;

/*
 * 输入一个链表，输出该链表中倒数第k个结点
 * */
public class Main22 {
	
	public ListNode FindKthToTail(ListNode head, int k) {
		// 对输入进行判断
		if (k <= 0 || head == null) {
			return null;
		}
		
		// 对链表长度短于k的情况进行讨论
		ListNode temp = head;
		for (int i = 0; i < k - 1; i++) {
			head = head.next;
			if (head == null) {
				return null;
			}
		}
		
		// 链表长度不小于k
		while (head.next != null) {
			head = head.next;
			temp = temp.next;
		}
		return temp;
    }
}

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/

/*
 * 1 2 3 4 5 6
 * 
 * 倒数第三个 ： 4
 * 3
 * 
 * 1
 * */
