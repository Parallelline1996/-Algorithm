package Page2;


import java.util.HashSet;
import java.util.Set;
import tools.ListNode;

/*
* Given a sorted linked list, delete all duplicates such that each element appear only once.
Example 1:
Input: 1->1->2
Output: 1->2
Example 2:
Input: 1->1->2->3->3
Output: 1->2->3
* */

public class N83_RemoveDuplicatesfromSortedList {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode a1 = new ListNode(2);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(3);
        a.next = a1;
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        ListNode temp = deleteDuplicates(a);
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }


    private static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        ListNode next = cur.next;
        while (cur != null && next != null) {
            if (next.val == cur.val) {
                cur.next = next.next;
            } else {
                cur = cur.next;
            }
            next = next.next;
        }
        return head;
    }

    // 这种解法在这里比较慢，因为这个列表是有序的
    private static ListNode deleteDuplicates1(ListNode head) {
        if (head == null) {
            return null;
        }
        Set<Integer> set = new HashSet<>();
        ListNode newHead = head;
        ListNode preHead = head;
        while (head != null) {
            if (set.contains(head.val)) {
                if (head.next != null) {
                    head.val = head.next.val;
                    head.next = head.next.next;
                } else {
                    preHead.next = null;
                    head = null;
                }
            } else {
                set.add(head.val);
                preHead = head;
                head = head.next;
            }
        }
        return newHead;
    }


}

