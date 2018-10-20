package Page5;

/*
* 删除链表中等于给定值 val 的所有节点。
* */
public class N203_RemoveLinkedListElements {

    public static void main(String[] args) {

    }

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
