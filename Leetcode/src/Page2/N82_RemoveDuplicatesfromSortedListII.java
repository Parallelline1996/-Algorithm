package Page2;

import tools.ListNode;

/*
* Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

Example 1:

Input: 1->2->3->3->4->4->5
Output: 1->2->5
Example 2:

Input: 1->1->1->2->3
Output: 2->3
*
* */
public class N82_RemoveDuplicatesfromSortedListII {

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode a1 = new ListNode(2);
        ListNode a2 = new ListNode(3);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(4);
        ListNode a6 = new ListNode(5);
        a.next = a1; a1.next = a2; a2.next = a3;
        a3.next = a4; a4.next = a5; a5.next = a6;
        a = deleteDuplicates(a);
        while (a != null) {
            System.out.print(a.val + "  ");
            a = a.next;
        }
        System.out.println();

        ListNode b = new ListNode(1);
        ListNode b1 = new ListNode(1);
        ListNode b2 = new ListNode(1);
        ListNode b3 = new ListNode(2);
        ListNode b4 = new ListNode(3);
        b.next = b1; b1.next = b2;
        b2.next = b3; b3.next = b4;
        b = deleteDuplicates(b);
        while (b != null) {
            System.out.print(b.val + "  ");
            b = b.next;
        }
    }

    private static ListNode deleteDuplicates(ListNode head) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode pre = newHead;
        ListNode cur = null;
        // 标记时候需要删除操作
        boolean weatherNeedDelete = false;
        while (pre.next != null) {
            cur = pre.next;
            while (cur.next != null && cur.next.val == pre.next.val) {
                cur = cur.next;
                weatherNeedDelete = true;
            }
            // 发生删除操作，直接将中间重复的部分略过
            if (weatherNeedDelete) {
                pre.next = cur.next;
                weatherNeedDelete = false;
            } else {
                pre.next = cur;
                pre = pre.next;
            }
        }
        return newHead.next;
    }
}
