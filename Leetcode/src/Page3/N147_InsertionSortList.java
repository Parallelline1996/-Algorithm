package Page3;

import tools.ListNode;

/*
* Algorithm of Insertion Sort:
Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list,
and inserts it there.
It repeats until no input elements remain.

Example 1:
Input: 4->2->1->3
Output: 1->2->3->4

Example 2:
Input: -1->5->3->4->0
Output: -1->0->3->4->5
* */
public class N147_InsertionSortList {

    public static void main(String[] args) {
        ListNode a = new ListNode(4);
        ListNode a1 = new ListNode(2);
        ListNode a2 = new ListNode(1);
        ListNode a3 = new ListNode(3);
        a.next = a1; a1.next = a2; a2.next = a3;
        a = insertionSortList(a);
        while (a != null) {
            System.out.print(a.val + "  ");
            a = a.next;
        }
    }

    // 未完成
    private static ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        // 用于每一次从头开始的遍历
        ListNode pre = newHead;
        // 当前遍历的元素的前一元素
        ListNode cur = newHead;
        // 下一个被处理的元素
        ListNode next = null;
        while (cur.next != null) {
            // 下一个被处理的元素
            next = cur.next.next;
            while (pre.next.val < cur.next.val && pre != cur) {
                pre = pre.next;
            }
            if (pre != cur) {
                cur.next.next = pre.next;
                pre.next = cur.next;
            }
            cur = next;
            pre = newHead.next;
        }
        return newHead.next;
    }

    // 很快的做法
    public ListNode insertionSortList_(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fakeHead = new ListNode(1);
        ListNode pre = fakeHead;
        while (head != null)
        {
            if (pre != fakeHead && pre.val > head.val) {
                pre = fakeHead;
            }
            while (pre.next != null && pre.next.val < head.val) {
                pre = pre.next;
            }
            ListNode cur = head;
            head = head.next;
            cur.next = pre.next;
            pre.next = cur;
        }
        return fakeHead.next;
    }
}
