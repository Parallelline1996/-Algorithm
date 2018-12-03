package Page4;

import tools.ListNode;

/*
* Write a program to find the node at which the intersection of two singly linked lists begins.
For example, the following two linked lists:
A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗
B:     b1 → b2 → b3
begin to intersect at node c1.

Notes:
If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
* */
public class N160_IntersectionOfTwoLinkedLists {

    public static void main(String[] args) {

    }

    public static ListNode getIntersectionNode_(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode endA = headA;
        ListNode endB = headB;
        int lenA = 1, lenB = 1;
        while (endA.next != null) {
            endA = endA.next;
            lenA++;
        }
        while (endB.next != null) {
            endB = endB.next;
            lenB++;
        }
        // 先判断两个链表是否相交
        if (endA != endB) {
            return null;
        }
        endA = headA;
        endB = headB;
        int m = lenA - lenB;
        if (m > 0) {
            while (m > 0) {
                endA = endA.next;
                m--;
            }
        } else {
            while (m < 0) {
                endB = endB.next;
                m++;
            }
        }
        while (endA != endB) {
            endA = endA.next;
            endB = endB.next;
        }
        return endA;
    }


    // 修改了数据结构，不符合题目要求
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        headA = reverse(headA);
        headB = reverse(headB);
        if (headA != headB) {
            return null;
        }
        ListNode newHead = null;
        while (headA != null && headB != null) {
            if (headA == headB) {
                newHead = headA;
            } else {
                break;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    private static ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = head.next;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        head = pre;
        return head;
    }
}
