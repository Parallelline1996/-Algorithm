package Page5;

import java.util.Stack;

/*
* Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
Follow up:
                                    //   迭代           递归
A linked list can be reversed either iteratively or recursively. Could you implement both?
* */
public class N206_ReverseLinkedList {

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode a1 = new ListNode(2);
        ListNode a2 = new ListNode(3);
        ListNode a3 = new ListNode(4);
        ListNode a4 = new ListNode(5);
        a.next = a1; a1.next = a2; a2.next = a3; a3.next = a4;
        a = reverseList(a);
        ListNode b = a;
        while (a != null) {
            System.out.print(a.val + "  ");
            a = a.next;
        }
        System.out.println();

        a = reverseList1(b);
        while (a != null) {
            System.out.print(a.val + "  ");
            a = a.next;
        }
    }

    private static ListNode reverseList1(ListNode head) {
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

    // 迭代的做法速率慢
    private static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.add(head);
            head = head.next;
        }
        ListNode output = stack.pop();
        ListNode outputHead = output;
        while (!stack.isEmpty()) {
            ListNode temp = stack.pop();
            output.next = temp;
            output = output.next;
        }
        output.next = null;
        return outputHead;
    }
}
