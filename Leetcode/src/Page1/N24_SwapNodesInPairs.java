package Page1;

import tools.ListNode;

/*
*
* Given a linked list, swap every two adjacent nodes and return its head.
Example:
Given 1->2->3->4, you should return the list as 2->1->4->3.
Note:
Your algorithm should use only constant extra space.
You may not modify the values in the list's nodes, only nodes itself may be changed.
* */
public class N24_SwapNodesInPairs {

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode a1 = new ListNode(2);
        ListNode a2 = new ListNode(3);
        ListNode a3 = new ListNode(4);
        ListNode a4 = new ListNode(5);
        ListNode a5 = new ListNode(6);
        ListNode a6 = new ListNode(7);
        a.next = a1; a1.next = a2; a2.next = a3;
        a3.next = a4; a4.next = a5; a5.next = a6;
        ListNode output = swapPairs(a);
        while (output != null) {
            System.out.print(output.val + "  ");
            output = output.next;
        }
    }

    public ListNode swapPairs_(ListNode head) {
        // 多用了一个节点做最前的节点，减少判断的问题
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        prev.next = head;
        while(prev.next != null && prev.next.next!= null) {
            // 创建第一个和第二个节点
            ListNode first = prev.next;
            ListNode second = prev.next.next;
            // 更改两个节点之间的指针
            first.next = second.next;
            second.next = first;
            prev.next = second;
            prev = first;
        }
        return dummy.next;
    }


    private static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = null;
        ListNode cur = head;
        ListNode pre = null;
        ListNode next = null;
        while (cur != null && cur.next != null) {
            if (newHead == null) {
                newHead = cur.next;
                pre = cur;
                cur = cur.next.next;
                newHead.next = pre;
                pre.next = cur;
                continue;
            }
            pre.next = cur.next;
            next = cur.next.next;
            pre.next.next = cur;
            pre = cur;
            cur.next = next;
            cur = next;
        }
        return newHead;
    }
}
