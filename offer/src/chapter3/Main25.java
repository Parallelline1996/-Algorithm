package chapter3;


import assit.ListNode;

/*
 * 输入两个单调递增的链表，输出两个链表合成后的链表，
 * 当然我们需要合成后的链表满足单调不减规则
 * */
public class Main25 {
	
	public static void main(String[] args) {
		ListNode aListNode = new ListNode(1);
		ListNode bListNode = new ListNode(2);
		ListNode cListNode = new ListNode(3);
		ListNode dListNode = new ListNode(4);
		ListNode eListNode = new ListNode(5);
		ListNode fListNode = new ListNode(6);
		ListNode gListNode = new ListNode(7);
		ListNode hListNode = new ListNode(8);
		ListNode iListNode = new ListNode(9);
		ListNode jListNode = new ListNode(10);
		// 1 2 4 6 7 10
		aListNode.next = bListNode;
		bListNode.next = dListNode;
		dListNode.next = fListNode;
		fListNode.next = gListNode;
		gListNode.next = jListNode;
		
		// 3 5 8 9
		cListNode.next = eListNode;
		eListNode.next = hListNode;
		hListNode.next = iListNode;
		ListNode a = Merge(aListNode, cListNode);
		while (a != null) {
			System.out.println(a.val);
			a = a.next;
		}
		
		System.out.println("===================");
		ListNode b = Merge_(aListNode, cListNode);
		int k = 0;
		while (b != null) {
			System.out.println(b.val);
			b = b.next;
			k ++;
			if (k > 10) {
				break;
			}
		}
	}

	public static ListNode Merge(ListNode list1,ListNode list2) {
		if (list1 == null) {
			return list2;
		} 
		if (list2 == null) {
			return list1;
		}
		ListNode answer = null;
		ListNode temp = null;
		
		// 确定头节点
		if (list1.val > list2.val) {
			answer = list2;
			temp = list2;
			list2 = list2.next;
		} else {
			answer = list1;
			temp = list1;
			list1 = list1.next;
		}
		
		// 两条链合并
		while (list1 != null && list2 != null) {
			if (list1.val < list2.val) {
				answer.next = list1;
				list1 = list1.next;
			} else {
				answer.next = list2;
				list2 = list2.next;
			}
			answer = answer.next;
		}
		
		// 将剩余非空的链的添加到结尾
		if (list1 != null) {
			while (list1 != null) {
				answer.next = list1;
				list1 =  list1.next;
				answer = answer.next;
			}
		} else {
			while (list2 != null) {
				answer.next = list2;
				list2 = list2.next;
				answer = answer.next;
			}
		}
        return temp;
    }
	
	// 剑指offer中提供的做法 -> 未完成
	public static ListNode Merge_(ListNode list1, ListNode list2) {
		if (list1 == null) {
			return list2;
		} else if(list2 == null) {
			return list1;
		}
		ListNode aNode = null;
		if (list1.val < list2.val) {
			aNode = list1;
			aNode.next = Merge_(list1.next, list2);
		} else {
			aNode = list2;
			aNode.next = Merge_(list1, list2.next);
		}
		return aNode;
	}
}
