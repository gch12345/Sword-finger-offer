package nowCoder;

import java.util.ArrayList;
class ListNode {
    int val;
    ListNode next;
}
public class PrintListFromTailToHead {
    public ListNode reverseList(ListNode head) {
        ListNode Head = null;
        while (head != null) {
            ListNode Node = head;
            head = head.next;
            Node.next =  Head;
            Head = Node;
        }
        return Head;
    }
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        listNode = reverseList(listNode);
        while (listNode != null) {
            arrayList.add(listNode.val);
            listNode = listNode.next;
        }
        return arrayList;
    }
}
