package Page2;

import tools.ListNode;

import java.util.LinkedList;


/*
*
* Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
You should preserve the original relative order of the nodes in each of the two partitions.

Example:
Input: head = 1->4->3->2->5->2, x = 3
Output: 1->2->2->4->3->5

* */
public class N86_PartitionList {

    public static void main(String[] args) {

    }

    public ListNode partition1(ListNode head, int x) {
        // 用于分别引用前后两段不同的链表
        ListNode list1 = new ListNode(0);
        ListNode list2 = new ListNode(0);
        ListNode l1 = list1;
        ListNode l2 = list2;
        // 遍历整个链表，将链表分为大于给定值的链跟小于给定值的链
        while (head != null) {
            if (head.val >= x) {
                l2.next = head;
                l2 = l2.next;
            } else {
                l1.next = head;
                l1 = l1.next;
            }
            head = head.next;
        }
        // 将两条链链接起来，注意后面的链末尾要指向null
        l2.next = null;
        l1.next = list2.next;
        return list1.next;
    }

    // 这个解法较慢
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        LinkedList<Integer> smallList = new LinkedList<>();
        LinkedList<Integer> bigList = new LinkedList<>();
        while (head != null) {
            if (head.val >= x) {
                bigList.add(head.val);
            } else {
                smallList.add(head.val);
            }
            head = head.next;
        }
        ListNode newHead = null;
        if (smallList.size() == 0) {
            newHead = new ListNode(bigList.poll());
        } else {
            newHead = new ListNode(smallList.poll());
        }
        ListNode cur = newHead;
        while (smallList.size() > 0) {
            cur.next = new ListNode(smallList.poll());
            cur = cur.next;
        }
        while (bigList.size() > 0) {
            cur.next = new ListNode(bigList.poll());
            cur = cur.next;
        }
        return newHead;
    }
}
