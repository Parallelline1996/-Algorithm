package Page9;

import tools.ListNode;

import java.util.Stack;

/*
* You are given two non-empty linked lists representing two non-negative integers.
* The most significant digit comes first and each of their nodes contain a single digit.
* Add the two numbers and return it as a linked list.
* You may assume the two numbers do not contain any leading zero, except the number 0 itself.
Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

Example:
Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7
* */
public class N445_AddTwoNumbersII {

    public static void main(String[] args) {
        ListNode a = new ListNode(7);
        ListNode a1 = new ListNode(2);
        ListNode a2 = new ListNode(4);
        ListNode a3 = new ListNode(3);
        a.next = a1; a1.next = a2; a2.next = a3;
        ListNode b = new ListNode(5);
        ListNode b1 = new ListNode(6);
        ListNode b2 = new ListNode(4);
        b.next = b1; b1.next = b2;
        ListNode c = addTwoNumbers(a, b);
        while (c != null) {
            System.out.print(c.val + " ");
            c = c.next;
        }
    }

    // 最快速度的，还是用链表的倒置，再相加

    // 66.6%
    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> outputStack = new Stack<>();
        int len1 = 0, len2 = 0;
        while (l1 != null) {
            stack1.add(l1.val);
            l1 = l1.next;
            len1++;
        }
        while (l2 != null) {
            stack2.add(l2.val);
            l2 = l2.next;
            len2++;
        }
        int n = Math.max(len1, len2);
        int a = 0, b = 0, add = 0, total = 0;
        ListNode output = null;
        for (int i = 0; i < n; i++) {
            a = (len1 > 0)? stack1.pop(): 0;
            b = (len2 > 0)? stack2.pop(): 0;
            len1--;
            len2--;
            total = a + b + add;
            add = total / 10;
            outputStack.add(total % 10);
        }
        if (add == 1) {
            outputStack.add(add);
        }
        output = new ListNode(outputStack.pop());
        ListNode temp = output;
        while (!outputStack.isEmpty()) {
            temp.next = new ListNode(outputStack.pop());
            temp = temp.next;
        }
        return output;
    }
}
