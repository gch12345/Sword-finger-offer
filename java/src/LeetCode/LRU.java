package LeetCode;

import java.util.HashMap;

public class LRU {
    class lruNode {
        int key;
        int val;
        lruNode prev;
        lruNode next;
        public lruNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    HashMap<Integer, lruNode> hashMap = new HashMap<>();
    lruNode head;
    lruNode tail;
    int size = 3;
    public Integer get(int key) {
        lruNode ret = hashMap.get(key);
        if (ret != null) {
            move(key);
            return ret.val;
        }
        return null;
    }

    public void set(int key, int val) {
        lruNode cur = new lruNode(key, val);
        hashMap.put(key, cur);
        if (head == null) {
            head = cur;
            tail = cur;
            return;
        }
        if (size < hashMap.size()) {
            int removeKey = head.key;
            head = head.next;
            head.prev = null;
            hashMap.remove(removeKey);
        }
        tail.next = cur;
        cur.prev = tail;
        tail = tail.next;
    }

    private void move(int key) {
        if (key == head.key) {
            tail.next = head;
            head.prev = tail;
            tail = tail.next;
            head = head.next;
            head.prev = null;
            tail.next = null;
            return;
        }
        if (key == tail.key) {
            return;
        }
        lruNode cur = hashMap.get(key);
        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;
        tail.next = cur;
        cur.prev = tail;
        tail = tail.next;
        tail.next = null;
    }

    public void print() {
        lruNode Head = head;
        while (Head != null) {
            System.out.println(Head.key + "  " + Head.val);
            Head = Head.next;
        }
        System.out.println("------------");
    }

    public static void main(String[] args) {
        LRU lru = new LRU();
        lru.set(1, 1);
        lru.set(2, 2);
        lru.set(3, 3);
        lru.set(4, 4);
        lru.print();
        lru.get(2);
        lru.print();
    }
}
