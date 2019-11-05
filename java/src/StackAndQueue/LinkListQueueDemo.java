package StackAndQueue;

class Linklist {
    int val;
    Linklist next;

    public Linklist(int val) {
        this.val = val;
    }
}

public class LinkListQueueDemo {
    private Linklist head = null;
    private Linklist end = null;
    private int size = 0;

    public void offer(int val) {
        Linklist cur = new Linklist(val);
        size++;
        if (head == null) {
            head = cur;
            end = cur;
            return;
        }
        end.next = cur;
        end = end.next;
    }

    public Integer poll() {
        if (head == null) {
            return null;
        }
        int ret = head.val;
        head = head.next;
        if (head == null) {
            end = null;
        }
        size--;
        return ret;
    }

    public Integer peek() {
        if (head == null) {
            return null;
        }
        return head.val;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}
