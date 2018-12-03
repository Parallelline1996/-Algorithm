package Page7;

import tools.ListNode;

/*
* Given a singly linked list, group all odd nodes together followed by the even nodes.
* Please note here we are talking about the node number and not the value in the nodes.
You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example 1:
Input: 1->2->3->4->5->NULL
Output: 1->3->5->2->4->NULL

Example 2:
Input: 2->1->3->5->6->4->7->NULL
Output: 2->3->6->7->1->5->4->NULL
Note:

The relative order inside both the even and odd groups should remain as it was in the input.
The first node is considered odd, the second node even and so on ...
* */
public class N328_OddEvenLinkedList {

    public static void main(String[] args) {

    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        // 奇数位链
        ListNode oddNode = head;
        // 偶数位链
        ListNode evenNode = head.next;
        // 偶数位链的开端
        ListNode evenListHead = evenNode;
        // 遍历整个链表
        while (evenNode != null && evenNode.next != null) {
            oddNode.next = evenNode.next;
            oddNode = oddNode.next;
            evenNode.next = oddNode.next;
            evenNode = evenNode.next;
        }
        // 在奇数链的末端链接上偶数链
        oddNode.next = evenListHead;
        return head;
    }
}
