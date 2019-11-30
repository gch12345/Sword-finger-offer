package LeetCode;

public class MergeKLists {
    class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode mergeKLists(ListNode[] lists){
        if (lists.length == 0) {
            return null;
        }
        return helper(lists, 0, lists.length - 1);
    }
    private ListNode helper(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        int mid = (left + right) / 2;
        ListNode leftList = helper(lists, left, mid);
        ListNode rightList = helper(lists, mid + 1, right);
        return menge(leftList, rightList);
    }
    private ListNode menge(ListNode leftList, ListNode rightList) {
        if (leftList == null) {
            return rightList;
        }
        if (rightList == null) {
            return leftList;
        }
        ListNode ret = new ListNode(-1);
        ListNode cur = ret;
        while (leftList != null && rightList != null) {
            if (leftList.val < rightList.val) {
                cur.next = leftList;
                leftList = leftList.next;
            } else {
                cur.next = rightList;
                rightList = rightList.next;
            }
            cur = cur.next;
        }
        if (leftList == null) {
            cur.next = rightList;
        } else {
            cur.next = leftList;
        }
        return ret.next;
    }
}
