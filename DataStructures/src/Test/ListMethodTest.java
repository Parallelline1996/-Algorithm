package Test;

import Method.ListMethod;
import Method.ListNode;
import org.junit.Test;

public class ListMethodTest {

    @Test
    public void testInsertionSortList() {
        ListNode a = new ListNode(5);
        ListNode a1 = new ListNode(3);
        ListNode a2 = new ListNode(4);
        ListNode a3 = new ListNode(6);
        ListNode a4 = new ListNode(1);
        a.next = a1; a1.next = a2;
        a2.next = a3; a3.next = a4;
        ListMethod method = new ListMethod();
        ListNode temp = method.insertionSortList(a);
        while (temp != null) {
            System.out.print(temp.val + "  ");
        }
        System.out.println();
    }

    @Test
    public void testReverse() {
        ListNode a = new ListNode(1);
        ListNode a1 = new ListNode(2);
        ListNode a2 = new ListNode(3);
        ListNode a3 = new ListNode(4);
        ListNode a4 = new ListNode(5);
        a.next = a1;
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
//        ListNode temp1 = a;
//        while (temp1 != null) {
//            System.out.print("  " + temp1.val);
//            temp1 = temp1.next;
//        }
        a = ListMethod.reverse(a);
        System.out.println();
        while (a != null) {
            System.out.print("  " + a.val);
            a = a.next;
        }
    }

    @Test
    public void testReorderList() {
        ListNode a = new ListNode(1);
        ListNode a1 = new ListNode(2);
        ListNode a2 = new ListNode(3);
        ListNode a3 = new ListNode(4);
        ListNode a4 = new ListNode(5);
        ListNode a5 = new ListNode(6);
        a.next = a1;
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        ListMethod method = new ListMethod();
        method.reorderList(a);
        System.out.println();
        ListNode b = new ListNode(1);
        ListNode b1 = new ListNode(2);
        ListNode b2 = new ListNode(3);
        b.next = b1;
        b1.next = b2;
        method.reorderList(b);

        System.out.println();
        ListNode c = new ListNode(1);
        ListNode c1 = new ListNode(2);
        ListNode c2 = new ListNode(3);
        ListNode c3 = new ListNode(4);
        c.next = c1;
        c1.next = c2;
        c2.next = c3;
        method.reorderList(c);
    }
}
