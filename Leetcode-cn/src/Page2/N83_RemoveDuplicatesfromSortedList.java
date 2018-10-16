package Page2;


import java.util.HashSet;
import java.util.Set;

/*
* 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次
* */
public class N83_RemoveDuplicatesfromSortedList {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode a1 = new ListNode(2);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(3);
        a.next = a1;
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        ListNode temp = deleteDuplicates(a);
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    private static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        Set<Integer> set = new HashSet<>();
        ListNode newHead = head;
        ListNode preHead = head;
        while (head != null) {
            if (set.contains(head.val)) {
                if (head.next != null) {
                    head.val = head.next.val;
                    head.next = head.next.next;
                } else {
                    preHead.next = null;
                    head = null;
                }
            } else {
                set.add(head.val);
                preHead = head;
                head = head.next;
            }
        }
        return newHead;
    }


    /* 这种方式更快：
    注意题目：是给定了一定顺序。。。。
    *     ListNode current = head;
        while (current != null && current.next != null) {
        if (current.next.val == current.val) {
            current.next = current.next.next;
        } else {
            current = current.next;
        }
    }
    return head;
    *
    * */
}

