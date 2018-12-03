package Page2;

import tools.ListNode;

public class N92_ReverseLinkedListII {

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode a1 = new ListNode(2);
        ListNode a2 = new ListNode(3);
        ListNode a3 = new ListNode(4);
        ListNode a4 = new ListNode(5);
        a.next = a1;
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a = reverseBetween(a, 2, 4);
        while (a != null) {
            System.out.print(a.val + "  ");
            a = a.next;
        }
        System.out.println();

        ListNode b = new ListNode(1);
        ListNode b1 = new ListNode(2);
        ListNode b2 = new ListNode(3);
        ListNode b3 = new ListNode(4);
        ListNode b4 = new ListNode(5);
        b.next = b1; b1.next = b2;
        b2.next = b3; b3.next = b4;
        b = reverseBetween(b, 1, 4);
        while (b != null) {
            System.out.print(b.val + "  ");
            b = b.next;
        }
        System.out.println();
    }


    private static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }
        // 哨兵结点
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        // 第一部分正序的尾结点
        ListNode endOfFirstPart = newHead;
        for (int i = 0; i < m - 1; i++) {
            endOfFirstPart = endOfFirstPart.next;
        }
        // 第二部分正序的头结点
        ListNode startOfThirdPart = endOfFirstPart;
        for (int i = 0; i < n - m + 2; i++) {
            startOfThirdPart = startOfThirdPart.next;
        }
        // 逆序
        ListNode pre = startOfThirdPart, cur = endOfFirstPart.next, next = null;
        for (int i = 0; i <= n - m; i++) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        endOfFirstPart.next = pre;
        return newHead.next;
    }
}
