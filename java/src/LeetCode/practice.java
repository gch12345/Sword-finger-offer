package LeetCode;

import java.util.*;

public class practice {
    // 最长不重复子串
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int max = 0;
        int curLen = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!map.containsKey(ch) || i - curLen > map.get(ch)) {
                curLen++;
            } else {
                curLen = i - map.get(ch);
            }
            map.put(ch, i);
            if (curLen > max) {
                max = curLen;
            }
        }
        return max;
    }

    // 二叉搜索树转双向链表
    class Node{
        int val;
        Node left;
        Node right;
    }
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        helper(root);
        head.left = tail;
        tail.right = head;
        return head;
    }
    Node head;
    Node tail;
    private void helper(Node root) {
        if (root == null) {
            return;
        }
        helper(root.left);
        if (head == null) {
            head = root;
            tail = root;
        } else {
            tail.right = root;
            root.left = tail;
            tail = tail.right;
        }
        helper(root.right);
    }

    // 后序遍历
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.peek();
            if (cur.right == prev || cur.right == null) {
                list.add(cur.val);
                prev = stack.pop();
                cur = null;
            } else {
                cur = cur.right;
            }
        }
        return list;
    }
}
