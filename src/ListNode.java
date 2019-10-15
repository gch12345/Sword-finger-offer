public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
//给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        ListNode cur = head;
        int size = size(head);
        if (k % size == 0) {
            return head;
        }
        for (int i = 0; i < size - (k % size) - 1; i++) {
            cur = cur.next;
        }
        ListNode newHead = cur.next;
        cur.next = null;
        ListNode end = newHead;
        while (end.next != null) {
            end = end.next;
        }
        end.next = head;
        return newHead;
    }

    public int size(ListNode head) {
        int ret = 0;
        while (head != null) {
            ret++;
            head =head.next;
        }
        return ret;
    }
}
