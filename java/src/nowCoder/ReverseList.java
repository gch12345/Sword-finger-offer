package nowCoder;

public class ReverseList {
    public ListNode ReverseList(ListNode head) {
        ListNode Head = null;
        while (head != null) {
            ListNode Node = head;
            head = head.next;
            Node.next = Head;
            Head = Node;
        }
        return Head;
    }
}
