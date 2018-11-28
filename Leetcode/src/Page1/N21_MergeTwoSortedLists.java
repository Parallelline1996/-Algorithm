package Page1;

import tools.ListNode;

/*
* Merge two sorted linked lists and return it as a new list.
* The new list should be made by splicing together the nodes of the first two lists.
Example:
Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
* */
public class N21_MergeTwoSortedLists {

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode a1 = new ListNode(2);
        ListNode a2 = new ListNode(4);
        ListNode b = new ListNode(1);
        ListNode b1 = new ListNode(3);
        ListNode b2 = new ListNode(5);
        ListNode b3 = new ListNode(7);
        a.next = a1; a1.next = a2;
        b.next = b1; b1.next = b2; b2.next = b3;
        ListNode c = mergeTwoLists(a, b);
        while (c != null) {
            System.out.print(c.val + " ");
            c = c.next;
        }
    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 对输入进行判断，如果有一边为空，则直接返回另一边
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        // output为输出时的头指针
        ListNode output = null;
        ListNode temp = null;
        ListNode cur = null;
        int val;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                val = l1.val;
                l1 = l1.next;
            } else {
                val = l2.val;
                l2 = l2.next;
            }
            temp = new ListNode(val);
            // 这里是对起始节点进行赋值，这块可以在循环开始前先进行判断
            if (output == null) {
                output = temp;
                cur = temp;
            } else {
                cur.next = temp;
                cur = cur.next;
            }
        }
        if (l1 != null) {
            cur.next = l1;
            cur = cur.next;
            l1 = l1.next;
        }
        if (l2 != null) {
            cur.next = l2;
            cur = cur.next;
            l2 = l2.next;
        }
        return output;
    }
}
