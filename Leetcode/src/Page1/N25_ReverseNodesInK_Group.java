package Page1;

import tools.ListNode;

/*
*
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
k is a positive integer and is less than or equal to the length of the linked list.
If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

Example:
Given this linked list: 1->2->3->4->5
For k = 2, you should return: 2->1->4->3->5
For k = 3, you should return: 3->2->1->4->5

Note:
Only constant extra memory is allowed.
You may not alter the values in the list's nodes, only nodes itself may be changed.
* */
public class N25_ReverseNodesInK_Group {

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode a1 = new ListNode(2);
        ListNode a2 = new ListNode(3);
        ListNode a3 = new ListNode(4);
        ListNode a4 = new ListNode(5);
        a.next = a1; a1.next = a2; a2.next = a3;
        a3.next = a4;
        a = reverseKGroup(a, 5);
        while (a != null) {
            System.out.print(a.val + "  ");
            a = a.next;
        }
        System.out.println();

    }

    /*
    * 思路：
    * 找到符合条件的组，将整组进行倒置
    * */
    private static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) {
            return head;
        }
        ListNode newHead = new ListNode(0);
        ListNode preGroup = newHead, nextGroup = null, cur = head;
        while (true) {
            nextGroup = cur;
            int i = 1;
            while (nextGroup != null && i <= k) {
                i++;
                nextGroup = nextGroup.next;
            }
            // 出现符合条件的 group
            if (i > k) {
                preGroup.next = reverse(cur, k, nextGroup);
                preGroup = cur;
                cur = nextGroup;
            } else {
                preGroup.next = cur;
                break;
            }
        }
        return newHead.next;
    }

    // 链表倒置
    private static ListNode reverse(ListNode head, int k, ListNode nextGroup) {
        ListNode pre = nextGroup;
        ListNode cur = head;
        ListNode next = head.next;
        for (int i = 0; i < k; i++) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        head = pre;
        return head;
    }
}
