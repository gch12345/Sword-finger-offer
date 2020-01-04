package LeetCode;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 *  输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 *  输出：7 -> 0 -> 8
 *  原因：342 + 465 = 807
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Boolean start = true;
        ListNode ret = new ListNode(-1);
        ListNode tail = ret;
        while (l1 != null || l2 != null) {
            ListNode cur = null;
            if (l1 == null) {
                cur = new ListNode(l2.val);
                l2 = l2.next;
            } else if (l2 == null) {
                cur = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                cur = new ListNode(l1.val + l2.val);
                l1 = l1.next;
                l2 = l2.next;
            }
            tail.next = cur;
            if (!start) {
                cur.val += 1;
            }
            if (cur.val >= 10) {
                cur.val -= 10;
                start = false;
            } else {
                start = true;
            }
            tail = tail.next;
        }
        if (!start) {
            tail.next = new ListNode(1);
        }
        return ret.next;
    }
}
