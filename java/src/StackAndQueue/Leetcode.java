package StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Leetcode {
    public boolean isValid(String s) {
        if (s == null) {
            return true;
        }
        char[] array = s.toCharArray();
        Stack<Character> stack = new Stack();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == '[' || array[i] == '{' || array[i] == '(') {
                stack.push(array[i]);
                continue;
            }
            if (stack.isEmpty()) {
                return false;
            }
            char ch = stack.pop();
            if (array[i] == ']' && ch == '[') {
                continue;
            }
            if (array[i] == '}' && ch == '{') {
                continue;
            }
            if (array[i] == ')' && ch == '(') {
                continue;
            }
            return false;
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }

    class MyStack {
        Queue<Integer> A = new LinkedList<>();
        Queue<Integer> B = new LinkedList<>();
        /** Initialize your data structure here. */
        public MyStack() {

        }

        /** Push element x onto stack. */
        public void push(int x) {
            A.offer(x);
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            if (A.isEmpty()) {
                return 0;
            }
            while (A.size() != 1) {
                int cur = A.poll();
                B.offer(cur);
            }
            int ret = A.poll();
            Queue<Integer> cur = A;
            A = B;
            B = cur;
            return ret;
        }

        /** Get the top element. */
        public int top() {
            if (A.isEmpty()) {
                return 0;
            }
            while (A.size() != 1) {
                int cur = A.poll();
                B.offer(cur);
            }
            int ret = A.poll();
            B.offer(ret);
            Queue<Integer> cur = A;
            A = B;
            B = cur;
            return ret;
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return A.isEmpty();
        }
    }
    class MyQueue {
        Stack<Integer> A = new Stack<>();
        Stack<Integer> B = new Stack<>();
        /** Initialize your data structure here. */
        public MyQueue() {

        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            while (!B.isEmpty()) {
                int cur = B.pop();
                A.push(cur);
            }
            A.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if (A.isEmpty() && B.isEmpty()) {
                return 0;
            }
            while (!A.isEmpty()) {
                int cur = A.pop();
                B.push(cur);
            }
            int ret = B.pop();
            return ret;
        }

        /** Get the front element. */
        public int peek() {
            if (A.isEmpty() && B.isEmpty()) {
                return 0;
            }
            while (!A.isEmpty()) {
                int cur = A.pop();
                B.push(cur);
            }
            int ret = B.peek();
            return ret;
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return B.isEmpty() && A.isEmpty();
        }
    }

    class MinStack {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> minStack = new Stack<>();
        /** initialize your data structure here. */
        public MinStack() {

        }

        public void push(int x) {
            if (stack.isEmpty()) {
                stack.push(x);
                minStack.push(x);
                return;
            }
            stack.push(x);
            minStack.push(minStack.peek() < x ? minStack.peek() : x);
        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

    class MyCircularQueue {
        private int[] array;
        private int start = 0;
        private int end = 0;
        private int size = 0;
        /** Initialize your data structure here. Set the size of the queue to be k. */
        public MyCircularQueue(int k) {
            array = new int[k];
        }

        /** Insert an element into the circular queue. Return true if the operation is successful. */
        public boolean enQueue(int value) {
            if (size == array.length) {
                return false;
            }
            array[end] = value;
            end++;
            size++;
            end = end % array.length;
            return true;
        }

        /** Delete an element from the circular queue. Return true if the operation is successful. */
        public boolean deQueue() {
            if (size == 0) {
                return false;
            }
            start++;
            size--;
            start = start % array.length;
            return true;
        }

        /** Get the front item from the queue. */
        public int Front() {
            if (size == 0) {
                return -1;
            }
            return array[start];
        }

        /** Get the last item from the queue. */
        public int Rear() {
            if (size == 0) {
                return -1;
            }
            return array[(start + size - 1) % array.length];
        }

        /** Checks whether the circular queue is empty or not. */
        public boolean isEmpty() {
            if (size == 0) {
                return true;
            }
            return false;
        }

        /** Checks whether the circular queue is full or not. */
        public boolean isFull() {
            if (size == array.length) {
                return true;
            }
            return false;
        }
    }
}
