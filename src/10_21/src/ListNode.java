//反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
  }

class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null) {
            return null;
        }
        if(m == n) {
            return head;
        }
        ListNode node = head;
        ListNode cur = null;
        int count = 1;
        while (node.next != null) {
            if(m == 1 || count == m - 1) {
                if(m != 1) {
                    cur = node;
                }
                ListNode newEnd = null;
                ListNode prev = null;
                ListNode newHead = null;
                if(m != 1) {
                    prev = node.next;
                } else {
                    prev = node;
                    count--;
                }
                newHead = prev.next;
                while (count < n && prev != null) {
                    prev.next = newEnd;
                    newEnd = prev;
                    prev = newHead;
                    if(newHead !=null)
                        newHead = newHead.next;
                    count++;
                }
                if (m == 1){
                    head.next = prev;
                    head = newEnd;
                } else {
                    cur.next.next = prev;
                    cur.next = newEnd;
                }
                break;
            }
            count++;
            node = node.next;
        }
        return head;
    }
}