package baidu;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class list {
    class node {
        int val;
        node next;
        public node(int val) {
            this.val = val;
        }
    }
    public node sort(node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Stack<node> stack = new Stack<>();
        Queue<node> queue = new LinkedList<>();
        node cur = head;
        while (cur != null) {
            queue.add(cur);
            cur = cur.next;
            if (cur != null) {
                stack.add(cur);
                cur = cur.next;
            }
        }
        node ret = new node(-1);
        node tail = ret;
        while (!stack.isEmpty() && !queue.isEmpty()) {
            if (stack.peek().val < queue.peek().val) {
                tail.next = stack.pop();
            } else {
                tail.next = queue.poll();
            }
            tail = tail.next;
        }
        while (!stack.isEmpty()) {
            tail.next = stack.pop();
            tail = tail.next;
        }
        while (!queue.isEmpty()) {
            tail.next = queue.poll();
            tail = tail.next;
        }
        tail.next = null;
        return ret.next;
    }
}
