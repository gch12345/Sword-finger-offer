package LeetCode;
class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}
public class SortList {
    public ListNode sortList(ListNode head) {
        ListNode ret = head;
        int size = size(head);
        for (int group = 1; group < size; group *= 2) {
            ListNode prve = null;
            for (ListNode cur = ret; cur != null; cur = find(cur, group, prve)) {
                ListNode l2 = null;
                l2 = findL2(cur, group);
                ListNode me = merge(cur, l2, group);
                if (prve != null) {
                    prve.next = me;
                    cur = prve.next;
                } else {
                    ret = me;
                    cur = ret;
                }
            }
        }
        return ret;
    }
    private ListNode findL2(ListNode head, int group) {
        ListNode cur = head;
        for (int i = 0; i < group; i++) {
            if (cur == null) {
                return cur;
            }
            cur = cur.next;
        }
        return cur;
    }
    private ListNode find(ListNode head, int group, ListNode prve) {
        ListNode cur = head;
        for (int i = 0; i < group * 2; i++) {
            if (cur == null) {
                return null;
            }
            prve = cur;
            cur = cur.next;
        }
        return cur;
    }
    private int size(ListNode head) {
        int ret = 0;
        while(head != null) {
            ret++;
            head = head.next;
        }
        return ret;
    }
    private ListNode merge(ListNode l1, ListNode l2, int len) {
        if (l1 == null || l2 == null || len <= 0) {
            return null;
        }
        int len1 = 0;
        int len2 = 0;
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (l1 != null && l2 != null && len1 < len && len2 < len) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
                len1++;
            } else {
                cur.next = l2;
                l2 = l2.next;
                len2++;
            }
            cur = cur.next;
        }
        if (l1 == null || len1 >= len) {
            cur.next = l2;
        }
        if (l2 == null || len2 >= len) {
            ListNode next = cur.next;
            cur.next = l1;
            while(len1 < len - 1) {
                l1 = l1.next;
                len1++;
            }
            l1.next = next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(4);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(2);
        ListNode d = new ListNode(1);
        a.next = b;
        b.next = c;
        c.next = d;
        SortList solve = new SortList();
        solve.sortList(a);
    }
}
