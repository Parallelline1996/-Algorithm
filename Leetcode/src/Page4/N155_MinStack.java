package Page4;

import java.util.LinkedList;

/*
* Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
Example:
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.
* */
public class N155_MinStack {

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(-2);
        obj.push(0);
        obj.push(-3);
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.top());
        System.out.println(obj.getMin());
    }
}

/*
* 思路：
* 利用另外一个栈，维护最小的数
* 主要要保证出栈后，最小栈的 O(1)的速度可以获取最小值
* */
class MinStack {

    LinkedList<Integer> linkedList = null;
    LinkedList<Integer> min = null;

    /** initialize your data structure here. */
    public MinStack() {
        linkedList = new LinkedList<>();
        min = new LinkedList<>();
    }

    public void push(int x) {
        if (linkedList.size() == 0) {
            min.add(x);
        } else {
            if (x < min.peekLast()) {
                min.add(x);
            } else {
                min.add(min.peekLast());
            }
        }
        linkedList.add(x);
    }

    public void pop() {
        linkedList.removeLast();
        min.removeLast();
    }

    public int top() {
        return linkedList.getLast();
    }

    public int getMin() {
        return min.getLast();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */