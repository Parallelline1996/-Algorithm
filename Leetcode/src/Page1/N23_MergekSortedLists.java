package Page1;

import tools.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
* Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:
Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6
* */
public class N23_MergekSortedLists {

    public static void main(String[] args) {

    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) {
            return null;
        }
        ListNode newHead = new ListNode(1);
        ListNode cur = newHead;
        while (true) {
            int value = Integer.MAX_VALUE;
            int index = -1;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    if (lists[i].val < value) {
                        index = i;
                        value = lists[i].val;
                    }
                }
            }
            if (index == -1) {
                break;
            }
            cur.next = new ListNode(value);
            cur = cur.next;
            lists[index] = lists[index].next;
        }
        return newHead.next;
    }

    // 基于优先队列
    public ListNode mergeKLists1(ListNode[] lists) {
        if(lists.length == 0) return null;
        ListNode dummy = new ListNode(0);
        PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(11, new Comparator<ListNode>(){
            public int compare(ListNode n1, ListNode n2){
                return n1.val - n2.val;
            }
        });
        // 初始化大小为k的堆
        for(int i = 0; i < lists.length; i++){
            if(lists[i] != null) q.offer(lists[i]);
        }
        ListNode curr = dummy;
        while(!q.isEmpty()){
            // 拿出堆顶元素
            curr.next = q.poll();
            curr = curr.next;
            // 将堆顶元素的下一个加入堆中
            if(curr.next != null){
                q.offer(curr.next);
            }
        }
        return dummy.next;
    }
}
