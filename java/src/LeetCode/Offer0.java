package LeetCode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

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

    public String serialize(TreeNode root) {
        if (root == null) {
            return new String();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuilder stringBuilder = new StringBuilder();
        String string = null;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int nullSize = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.peek();
                if (node != null) {
                    queue.add(node.left);
                    queue.add(node.right);
                } else {
                    nullSize++;
                }
                stringBuilder.append(queue.poll());
                stringBuilder.append(",");
            }
            if (nullSize == size) {
                string = stringBuilder.substring(0, stringBuilder.length() - 5 * size);
                break;
            }
        }
        return string;
    }

    public TreeNode deserialize(String data) {
        if (data == null) {
            return null;
        }
        String[] strings = data.split(",");
        Queue<String> queue = new LinkedList<>();
        Collections.addAll(queue, strings);
        TreeNode root = null;
        Queue<TreeNode> curQueue = new LinkedList<>();
        int size = 0;
        while (!queue.isEmpty()) {
            if (size == 0) {
                String string = queue.poll();
                root = new TreeNode(Integer.parseInt(string));
                curQueue.add(root);
                size = 1;
            } else {
                for (int i = 0; i < size; i++) {
                    TreeNode cur = curQueue.poll();
                    String string = queue.poll();
                    if (cur != null) {
                        if ("null".equals(string)) {
                            cur.left = null;
                        } else {
                            cur.left = new TreeNode(Integer.parseInt(string));
                        }
                        string = queue.poll();
                        if ("null".equals(string)) {
                            cur.right = null;
                        } else {
                            cur.right = new TreeNode(Integer.parseInt(string));
                        }
                        curQueue.add(cur.left);
                        curQueue.add(cur.right);
                    } else {
                        curQueue.add(null);
                    }
                }
            }
            size *= 2;
        }
        return root;
    }
}