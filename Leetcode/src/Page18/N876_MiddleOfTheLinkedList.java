package Page18;

import tools.ListNode;

/*
* Given a non-empty, singly linked list with head node head, return a middle node of linked list.
If there are two middle nodes, return the second middle node.
Example 1:
Input: [1,2,3,4,5]
Output: Node 3 from this list (Serialization: [3,4,5])
The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
Note that we returned a ListNode object ans, such that:
ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.

Example 2:
Input: [1,2,3,4,5,6]
Output: Node 4 from this list (Serialization: [4,5,6])
Since the list has two middle nodes with values 3 and 4, we return the second one.

* */
public class N876_MiddleOfTheLinkedList {

    public static void main(String[] args) {
        // 输入为空
        System.out.println(middleNode(null));

        // 输入一个节点
        ListNode a = new ListNode(1);
        a = middleNode(a);
        System.out.println(middleNode(a).val);

        // 输入两个节点
        a = new ListNode(1);
        ListNode a1 = new ListNode(2);
        a.next = a1;
        System.out.println(middleNode(a).val);

        // 输入三个节点
        a = new ListNode(1);
        a1 = new ListNode(23);
        ListNode a2 = new ListNode(11);
        a.next = a1;
        a1.next = a2;
        System.out.println(middleNode(a).val);
    }

    private static ListNode middleNode(ListNode head) {
        ListNode a = head;
        ListNode b = head;
        // 这里排除了输入为空，跟输入只有一个元素的情况
        while (a != null && a.next != null) {
            a = a.next.next;
            b = b.next;
        }
        return b;
    }
}
