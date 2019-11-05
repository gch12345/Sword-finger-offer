package StackAndQueue;

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

        /** Initialize your data structure here. */
        public MyStack() {

        }

        /** Push element x onto stack. */
        public void push(int x) {

        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {

        }

        /** Get the top element. */
        public int top() {

        }

        /** Returns whether the stack is empty. */
        public boolean empty() {

        }
    }

}
