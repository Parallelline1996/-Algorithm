package Page1;


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
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
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
            if (output == null) {
                output = temp;
                cur = temp;
            } else {
                cur.next = temp;
                cur = cur.next;
            }
        }
        while (l1 != null) {
            cur.next = l1;
            cur = cur.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            cur.next = l2;
            cur = cur.next;
            l2 = l2.next;
        }
        return output;
    }
}
