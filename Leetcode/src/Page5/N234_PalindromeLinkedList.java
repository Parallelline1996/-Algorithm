package Page5;

import tools.ListNode;

/*
* Given a singly linked list, determine if it is a palindrome.
Example 1:
Input: 1->2
Output: false

Example 2:
Input: 1->2->2->1
Output: true

Follow up:
Could you do it in O(n) time and O(1) space?
* */
public class N234_PalindromeLinkedList{

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode a1 = new ListNode(2);
        a.next = a1;
        System.out.println(isPalindrome(a));

        ListNode b = new ListNode(1);
        ListNode b1 = new ListNode(2);
        ListNode b2 = new ListNode(2);
        ListNode b3 = new ListNode(1);
        b.next = b1; b1.next = b2; b2.next = b3;
        System.out.println(isPalindrome(b));
    }

    private static boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        slow = slow.next;
        slow = reverse(slow);
        while (slow != null) {
            if (slow.val != head.val) {
                return false;
            }
            slow = slow.next;
            head = head.next;
        }
        return true;
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
