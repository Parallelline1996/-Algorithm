package Method;

public class ListMethod {

    /*
     * Sort a linked list using insertion sort.
     * 待完成
     * */
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = null;
        ListNode countNumber = head.next;
        ListNode next = null;
        ListNode newList = head;
        ListNode place = null;
        while (countNumber != null) {
            // 保存下一个元素，处理前面的元素
            next = countNumber.next;
            cur = countNumber;
            place = newList;
            while (place.val < cur.val && place.next != next) {
                place = place.next;
            }
            if (place != cur) {
                ListNode temp = place.next;
                place.next = cur;
                cur.next = temp;
            } else if (place == head) {
                cur.next = head;
                newList = cur;
            }
            countNumber = countNumber.next;
        }
        return newList;
    }

    /*
     * 这个答案有问题。。实在看不出问题在哪。。
     * 本地没有问题。一上系统就错了
     * */
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode first = head;
        ListNode tail = head;
        ListNode halfNode = head;
        ListNode output = head;
        // 统计节点数目
        int number = 1;
        while (tail.next != null) {
            tail = tail.next;
            number++;
        }
//        int half = (int)Math.ceil(number / 2);
        int half = (int)(((double)number + 0.5) / 2);
        // 确定后半部分节点位置
        for (int i = 0; i < half + 1; i++) {
            if (i == half) {
                ListNode temp = halfNode;
                halfNode = halfNode.next;
                temp.next = null;
                break;
            }
            halfNode = halfNode.next;
        }
        // 倒置
        halfNode = reverse(halfNode);
        ListNode newLink = new ListNode(head.val);
        head = newLink;
        first = first.next;
        while (first != null && halfNode != null) {
            newLink.next = halfNode;
            newLink = newLink.next;
            halfNode = halfNode.next;

            newLink.next = first;
            newLink = newLink.next;
            first = first.next;
        }
        if (first != null) {
            output.next = first;
        }

        while (head != null) {
            System.out.print("  " + head.val);
            head = head.next;
        }
    }

    public static ListNode reverse(ListNode first) {
        ListNode pre = null;
        ListNode cur = first;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            if (next == null) {
                first = pre;
                break;
            }
        }
        return first;
    }
}

