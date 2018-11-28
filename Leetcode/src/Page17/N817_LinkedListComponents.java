package Page17;

import tools.ListNode;

import java.util.HashSet;
import java.util.Set;

/*
* We are given head, the head node of a linked list containing unique integer values.
We are also given the list G, a subset of the values in the linked list.
Return the number of connected components in G, where two values are connected if they appear consecutively in the linked list.
Example 1:
Input:
head: 0->1->2->3
G = [0, 1, 3]
Output: 2
Explanation:
0 and 1 are connected, so [0, 1] and [3] are the two connected components.
Example 2:
Input:
head: 0->1->2->3->4
G = [0, 3, 1, 4]
Output: 2
Explanation:
0 and 1 are connected, 3 and 4 are connected, so [0, 1] and [3, 4] are the two connected components.
Note:
If N is the length of the linked list given by head, 1 <= N <= 10000.
The value of each node in the linked list will be in the range [0, N - 1].
1 <= G.length <= 10000.
G is a subset of all values in the linked list.
* */
public class N817_LinkedListComponents {

    public static void main(String[] args) {

    }

    // 利用题干中最下面的四个条件进行解答。利用空间换时间
    private static int numComponents1(ListNode head, int[] G) {
        if (head == null) {
            return 0;
        }
        boolean[] num = new boolean[10001];
        for (int i : G) {
            num[i] = true;
        }
        int number = 0;
        boolean isContain = false;
        while (head != null) {
            if (num[head.val]) {
                if (!isContain) {
                    isContain = true;
                }
            } else {
                if (isContain) {
                    number++;
                    isContain = false;
                }
            }
            head = head.next;
        }
        if (isContain) {
            number++;
        }
        return number;
    }



    // 利用 set 对每一个节点进行判断
    public int numComponents(ListNode head, int[] G) {
        if (head == null) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int i : G) {
            set.add(i);
        }
        int number = 0;
        boolean isContain = false;
        while (head != null) {
            if (set.contains(head.val)) {
                if (!isContain) {
                    isContain = true;
                }
            } else {
                if (isContain) {
                    number++;
                    isContain = false;
                }
            }
            head = head.next;
        }
        if (isContain) {
            number++;
        }
        return number;
    }

}
