package Page5;

import tools.ListNode;

/*
* 删除链表中等于给定值 val 的所有节点。
* */
public class N203_RemoveLinkedListElements {

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode a1 = new ListNode(2);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(1);
        a.next = a1; a1.next = a2; a2.next = a3;
        ListNode k = removeElements_(a, 2);
        while (k != null) {
            System.out.print(k.val + "  ");
            k = k.next;
        }
        System.out.println();

        ListNode b = new ListNode(1);
        b = removeElements_(b, 1);
        while (b != null) {
            System.out.println(b.val + " ");
            b = b.next;
        }
    }

    // 98%
    private static ListNode removeElements_(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        // 保证了第一个元素指向的对象的值一定不是 val
        while (head != null && head.val == val) {
            head = head.next;
        }
        ListNode output = head;
        while (head != null && head.next != null) {
            if (head.next.val == val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return output;
    }

    // leetcode-cn 通过，leetcode 不通过，【1，2，2，1】,2 报错
    private static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        // 保证了第一个元素指向的对象的值一定不是 val
        while (head != null && head.val == val) {
            head = head.next;
        }
        ListNode output = head;
        while (head != null && head.next != null) {
            if (head.next.val == val) {
                head.next = head.next.next;
            }
            head = head.next;
        }
        return output;
    }


}
