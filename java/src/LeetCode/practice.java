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
    class node {
        int val;
        node left;
        node right;
    }
    public node treeToDoublyList(node root) {
        if (root == null) {
            return null;
        }
        helper(root);
        head.left = tail;
        tail.right = head;
        return head;
    }
    node head;
    node tail;
    private void helper(node root) {
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

    // 岛屿的最大面积
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                helper(grid, i, j);
                if (count > max) {
                    max = count;
                }
                count = 0;
            }
        }
        return max;
    }
    int count = 0;
    private void helper(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1) {
            return;
        }
        count++;
        grid[i][j] = -1;
        helper(grid, i - 1, j);
        helper(grid, i + 1, j);
        helper(grid, i, j - 1);
        helper(grid, i, j + 1);
    }

    // 复制带随机指针的链表
    class Node{
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        Node newHead = new Node(-1);
        Node newEnd = newHead;
        HashMap<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            Node node = new Node(cur.val);
            newEnd.next = node;
            map.put(cur, node);
            newEnd = newEnd.next;
            cur = cur.next;
        }
        Node cur1 = head;
        Node cur2 = newHead.next;
        while (cur1 != null) {
            cur2.random = map.get(cur1.random);
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return newHead.next;
    }

    public Node copyRandomList0(Node head) {
        if (head == null) {
            return head;
        }
        Map<Node, Node> map = new HashMap<>();
        for (Node cur = head; cur != null; cur = cur.next) {
            map.put(cur, new Node(cur.val));
        }
        for (Node cur = head; cur != null; cur = cur.next) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
        }
        return map.get(head);
    }

    // 58 - I. 翻转单词顺序
    public String reverseWords0(String s) {
        if (s == null || s.length() < 1) {
            return s;
        }
        s = s.trim();
        String[] strings = s.split(" ");
        StringBuffer stringBuffer = new StringBuffer();
        for (String string : strings) {
            if (string.equals(" ")) {
                continue;
            }
            int index = string.length() - 1;
            while (index >= 0) {
                stringBuffer.append(string.charAt(index));
                index--;
            }
            stringBuffer.append(" ");
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        return stringBuffer.reverse().toString();
    }

    /**
     * 小Q想要给他的朋友发送一个神秘字符串，但是他发现字符串的过于长了，
     * 于是小Q发明了一种压缩算法对字符串中重复的部分进行了压缩，
     * 对于字符串中连续的m个相同字符串S将会压缩为[m|S](m为一个整数且1<=m<=100)，
     * 例如字符串ABCABCABC将会被压缩为[3|ABC]，现在小Q的同学收到了小Q发送过来的字符串，你能帮助他进行解压缩么？
     */
    private static String replace(String str) {
        if (str.contains("]")) {
            int i =0;
            while (i<=str.length()){
                if ("]".charAt(0) == str.charAt(i++)){
                    break;
                }
            }
            int j = i-1;
            while (0 <= j) {
                char c = str.charAt(j--);
                if ("[".charAt(0) == c) {
                    String repeatStr = str.substring(j + 2, i - 1);
                    String[] split = repeatStr.split("\\|");
                    Integer num = Integer.parseInt(split[0]);
                    String compress = split[1];
                    StringBuilder builder = new StringBuilder();
                    while (0 < num) {
                        builder.append(compress);
                        num--;
                    }
                    str = replace(str.replace("["+repeatStr+"]",builder.toString()));
                }
            }
        }
        return str;
    }

    public static void main(String[] args) {
        practice practice = new practice();
        int[][] arr = {{0, 1}};
        practice.maxAreaOfIsland(arr);
    }
}
