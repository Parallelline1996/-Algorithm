package Page5;

import java.util.Stack;

/*
* Implement the following operations of a queue using stacks.

push(x) -- Push element x to the back of queue.
pop() -- Removes the element from in front of queue.
peek() -- Get the front element.
empty() -- Return whether the queue is empty.

Example:
MyQueue queue = new MyQueue();
queue.push(1);
queue.push(2);
queue.peek();  // returns 1
queue.pop();   // returns 1
queue.empty(); // returns false

Notes:
You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).
* */
public class N232_ImplementQueueUsingStacks {

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
//        queue.push(1);
//        queue.push(2);
//        System.out.println(queue.peek());  // returns 1
//        System.out.println(queue.pop());   // returns 1
//        System.out.println(queue.empty()); // returns false
//        queue.pop();
//        System.out.println(queue.empty());
        queue.push(1);
        System.out.println(queue.pop());
        System.out.println(queue.empty());
    }
}

class MyQueue {

    Stack<Integer> inputStack = null;
    Stack<Integer> outputStack = null;

    /** Initialize your data structure here. */
    public MyQueue() {
        inputStack = new Stack<>();
        outputStack = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        inputStack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (!outputStack.isEmpty()) return outputStack.pop();
        move();
        return outputStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (outputStack.isEmpty()) move();
        return outputStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return outputStack.isEmpty() && inputStack.isEmpty();
    }

    private void move() {
        while (!inputStack.isEmpty()) {
            outputStack.push(inputStack.pop());
        }
    }
}
