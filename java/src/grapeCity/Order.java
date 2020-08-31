package grapeCity;

import java.util.Stack;

public class Order {
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
        Stack<node> stack0 = new Stack<>();
        Stack<node> stack1 = new Stack<>();
        stack0.add(head);
        int star = 0;
        while (!stack0.isEmpty() || !stack1.isEmpty()) {
            if (star == 0) {
                while (!stack0.isEmpty()) {
                    node cur = stack0.pop();
                    System.out.print(cur.val + " ");
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
                    System.out.print(cur.val + " ");
                    if (cur.right != null) {
                        stack0.add(cur.right);
                    }
                    if (cur.left != null) {
                        stack0.add(cur.left);
                    }
                    star = 0;
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        node head = new node(1);
        head.left = new node(2);
        head.right = new node(3);
        head.right.left = new node(6);
        head.right.right = new node(7);
        fun(head);
    }
}
