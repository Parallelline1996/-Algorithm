package Page3;

import tools.ListNode;

/*
* Given a linked list, determine if it has a cycle in it.
Follow up:
Can you solve it without using extra space?
* */
public class N141_LinkedListCycle {

    public static void main(String[] args) {

    }

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
