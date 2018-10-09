package chapter3;


import assit.ListNode;

/*
 * 输入一个链表，反转链表后，输出新链表的表头
 * */
public class Main24 {
	
	public static void main(String[] args) {
		ListNode aListNode = new ListNode(1);
		ListNode bListNode = new ListNode(2);
		ListNode cListNode = new ListNode(3);
		ListNode dListNode = new ListNode(4);
		aListNode.next = bListNode;
		bListNode.next = cListNode;
		cListNode.next = dListNode;
		ListNode temp = ReverseList(aListNode);
		while (temp != null) {
			System.out.println(temp.val);
			temp = temp.next;
		}
	}

	public static ListNode ReverseList(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode answer = null;
		ListNode left = null;
		ListNode cur = head;
		ListNode right = null;
		while (cur != null) {
			right = cur.next;
			if (right == null) {
				answer = cur;
			}
			cur.next = left;
			left = cur;
			cur = right;
		}
		return answer;
    }
}
