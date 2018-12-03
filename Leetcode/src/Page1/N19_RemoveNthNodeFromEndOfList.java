package Page1;

import tools.ListNode;

/*
* Given a linked list, remove the n-th node from the end of list and return its head.
Example:
Given linked list: 1->2->3->4->5, and n = 2.
After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Follow up:
Could you do this in one pass?
* */
public class N19_RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        a = removeNthFromEnd(a, 1);
        System.out.println(a);
        ListNode b = new ListNode(1);
        ListNode c = new ListNode(5);
        b.next = c;
        System.out.println(removeNthFromEnd(b, 1).val);
    }

    private static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(0);
        ListNode slow = start, fast = start;
        slow.next = head;
        for (int i = 0; i <= n; i++)   {
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return start.next;
    }
}
