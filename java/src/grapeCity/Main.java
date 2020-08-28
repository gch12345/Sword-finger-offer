package grapeCity;

import java.util.Stack;

public class Main {
    static class node {
        int val;
        node left;
        node right;
        public node(int val) {
            this.val = val;
        }
    }

    public static void fun(node head) {
        if (head == null) {
            return;
        }
        Stack<node> stack = new Stack<>();
        Stack<node> stack1 = new Stack<>();
        stack.add(head);
        int star = 0;
        while (!stack.isEmpty() || !stack1.isEmpty()) {
            if (star == 0) {
                while (!stack.isEmpty()) {
                    node cur = stack.pop();
                    System.out.println(cur.val);
                    if (cur.left != null) {
                        stack1.add(cur.left);
                    }
                    if (cur.right != null) {
                        stack1.add(cur.right);
                    }
                    star = 1;
                }
            } else {
                while (!stack1.isEmpty()) {
                    node cur = stack1.pop();
                    System.out.println(cur.val);
                    if (cur.right != null) {
                        stack.add(cur.right);
                    }
                    if (cur.left != null) {
                        stack.add(cur.left);
                    }
                    star = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        node head = new node(1);
        head.left = new node(2);
        head.right = new node(3);
        head.left.left = new node(4);
        head.left.right = new node(5);
        head.right.left = new node(6);
        fun(head);
    }
}
