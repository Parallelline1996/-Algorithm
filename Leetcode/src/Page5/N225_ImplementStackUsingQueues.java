package Page5;


/*
* Implement the following operations of a stack using queues.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
empty() -- Return whether the stack is empty.

Example:
MyStack stack = new MyStack();
stack.push(1);
stack.push(2);
stack.top();   // returns 2
stack.pop();   // returns 2
stack.empty(); // returns false

Notes:
You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).

* */

import java.util.LinkedList;
import java.util.Queue;

public class N225_ImplementStackUsingQueues {

    public static void main(String[] args) {
        MyStack stack = new MyStack();

        stack.push(1);
        stack.push(2);
        System.out.println(stack.top());   // returns 2
        System.out.println(stack.pop());   // returns 2
        System.out.println(stack.empty()); // returns false
    }
}


/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
class MyStack {

    Queue<Integer> queue;

    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.add(queue.poll());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}

class MyStack_ {

    Queue<Integer> queue1;
    Queue<Integer> queue2;

    /** Initialize your data structure here. */
    public MyStack_() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        if (this.empty()) {
            queue1.add(x);
        } else {
            if (queue1.isEmpty()) {
                queue2.add(x);
            } else {
                queue1.add(x);
            }
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int value = 0;
        if (queue1.isEmpty()) {
            while (queue2.size() > 1) {
                queue1.add(queue2.poll());
            }
            value = queue2.poll();
        } else {
            while (queue1.size() > 1) {
                queue2.add(queue1.poll());
            }
            value = queue1.poll();
        }
        return value;
    }

    /** Get the top element. */
    public int top() {
        int value = 0;
        if (queue1.isEmpty()) {
            while (queue2.size() > 1) {
                queue1.add(queue2.poll());
            }
            value = queue2.peek();
            queue1.add(queue2.poll());
        } else {
            while (queue1.size() > 1) {
                queue2.add(queue1.poll());
            }
            value = queue1.peek();
            queue2.add(queue1.poll());
        }
        return value;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
}