package LeetCode;

public class InsertionSortList {
    //对链表进行插入排序。
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head;
        while (head != null) {
            ListNode cur = head;
            head = head.next;
            if (newHead == null) {
                newHead = cur;
                cur.next = null;
            } else {
                ListNode prev = null;
                ListNode node = newHead;
                while (node != null && cur.val > node.val) {
                    prev = node;
                    node = node.next;
                }
                if (node == null) {
                    prev.next = cur;
                    cur.next = null;
                } else if (prev == null){
                    cur.next = newHead;
                    newHead = cur;
                } else {
                    cur.next = node;
                    prev.next = cur;
                }
            }
        }
        return newHead;
    }
    
    public ListNode insertionSortList0(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head;
        ListNode newEnd = head;
        head = head.next;
        while (head != null) {
            if (newEnd.val <= head.val) {
                newEnd.next = head;
                newEnd = newEnd.next;
                head = head.next;
                continue;
            }
            newEnd.next = head.next;
            ListNode cur = head;
            ListNode node = newHead;
            ListNode prev = null;
            head = head.next;
            if (cur.val <= newHead.val) {
                cur.next = newHead;
                newHead = cur;
                continue;
            }
            while (cur.val > node.val) {
                prev = node;
                node = node.next;
            }
            prev.next = cur;
            cur.next = node;
        }
        return newHead;
    }
}
