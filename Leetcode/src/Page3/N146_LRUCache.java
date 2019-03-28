package Page3;

import Page20.N983_MinimumCostForTickets;

import java.util.HashMap;

/*
* Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2 );
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
*
* */
public class N146_LRUCache {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 );
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
//        cache.get(1);       // returns -1 (not found)
//        cache.get(3);       // returns 3
//        cache.get(4);       // returns 4
    }
}

/*
* 思路：
* 维护一个 hashmap，使得里面的 key值都是缓存内的值
* 通过双向链表，来维护
* */
class LRUCache {

    class Node{
        int value;
        int key; // key值的目的：反过来删除hashmap的节点
        Node pre;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // 将当前节点踢出缓存
    private void removeNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    // LRU，加到最开始的位置
    private void addNodeToTop(Node node) {
        node.next = head.next;
        node.next.pre = node;
        head.next = node;
        node.pre = head;
    }

    private HashMap<Integer, Node> hashmap;
    private int size;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        hashmap = new HashMap<>(capacity);
        size = capacity;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.pre = head;
        head.pre = null;
        tail.next = null;
    }

    public int get(int key) {
        if (hashmap.containsKey(key)) {
            int result = hashmap.get(key).value;
            removeNode(hashmap.get(key));
            addNodeToTop(hashmap.get(key));
            return result;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (hashmap.get(key) != null) {
            Node node = hashmap.get(key);
            node.value = value;
            removeNode(node);
            addNodeToTop(node);
        } else {
            // 新增节点时，可能缓存区不够存储，所以将最末一个替换
            Node node = new Node(key, value);
            if (hashmap.size() < size) {
                addNodeToTop(node);
            } else {
                hashmap.remove(tail.pre.key);
                removeNode(tail.pre);
                addNodeToTop(node);
            }
            hashmap.put(key, node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
