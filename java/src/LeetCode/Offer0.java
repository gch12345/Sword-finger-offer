package LeetCode;

public class Offer0 {

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }
    }

    //  二叉搜索树与双向链表
    public Node treeToDoublyList0(Node root) {
        if (root == null) {
            return root;
        }
        if (root.left == null && root.right == null) {
            return root;
        }
        Node left = treeToDoublyList0(root.left);
        Node node = left;
        while (node != null && node.right != null) {
            node = node.right;
        }
        if (node != null) {
            root.left = node;
            node.right = root;
        }
        Node right = treeToDoublyList0(root.right);
        if (right != null) {
            root.right = right;
            right.left = root;
        }
        return left == null ? root : left;
    }

    Node prev;
    Node head;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        head.left = prev;
        prev.right = head;
        return head;
    }
    private void dfs(Node root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (prev == null) {
            head = root;
        } else {
            prev.right = root;
        }
        root.left = prev;
        prev = root;
        dfs(root.right);
    }
}