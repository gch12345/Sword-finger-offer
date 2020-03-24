package nowCoder;

public class Partition {
    public ListNode partition(ListNode pHead, int x) {
        // write code here
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode smailHead = null;
        ListNode smailEnd = null;
        ListNode bigHead = null;
        ListNode bigEnd = null;
        while (pHead != null) {
            if (pHead.val < x) {
                if (smailHead == null) {
                    smailHead = pHead;
                    smailEnd = pHead;
                } else {
                    smailEnd.next = pHead;
                    smailEnd = smailEnd.next;
                }
            } else {
                if (bigHead == null) {
                    bigHead = pHead;
                    bigEnd = pHead;
                } else {
                    bigEnd.next = pHead;
                    bigEnd = bigEnd.next;
                }
            }
            pHead = pHead.next;
        }
        if (smailHead != null) {
            smailEnd.next = bigHead;
        } else {
            return bigHead;
        }
        if (bigHead != null) {
            bigEnd.next = null;
        }
        return smailHead;
    }
}