package Page1;

import tools.ListNode;

/*
* 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
* 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
*
* 思路：类比N67的两数相加
* */
public class N2_AddTwoNumbers {
    public static void main(String[] args) {
        ListNode a = new ListNode(2);
        ListNode a1 = new ListNode(4);
        ListNode a2 = new ListNode(3);
        ListNode b = new ListNode(5);
        ListNode b1 = new ListNode(6);
        ListNode b2 = new ListNode(4);
        a.next = a1;
        a1.next = a2;
        b.next = b1;
        b1.next = b2;
        ListNode c = addTwoNumbers(a, b);
        while (c != null) {
            System.out.println(c.val);
            c = c.next;
        }
        System.out.println("=======");
        ListNode d = new ListNode(5);
        ListNode d1 = new ListNode(5);
        ListNode e = addTwoNumbers(d, d1);
        while (e != null) {
            System.out.println(e.val);
            e = e.next;
        }
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode output = null;
        ListNode head = null;
        int a, b, add = 0, total;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                a = l1.val;
                l1 = l1.next;
            } else {
                a = 0;
            }
            if (l2 != null) {
                b = l2.val;
                l2 = l2.next;
            } else {
                b = 0;
            }
            total = a + b + add;
            add = total / 10;
            if (output == null) {
                output = new ListNode(total % 10);
                head = output;
            } else {
                output.next = new ListNode(total % 10);
                output = output.next;
            }
        }
        if (add == 1) {
            output.next = new ListNode(add);
        }
        return head;
    }

}

