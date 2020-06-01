package LeetCode;

import java.util.*;

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

    public String serialize0(TreeNode root) {
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
                TreeNode node = queue.poll();
                if (node != null) {
                    queue.add(node.left);
                    queue.add(node.right);
                    stringBuilder.append(node.val);
                } else {
                    nullSize++;
                    stringBuilder.append("null");
                }
                stringBuilder.append(",");
            }
            if (nullSize == size) {
                string = stringBuilder.substring(0, stringBuilder.length() - 5 * size - 1);
                break;
            }
        }
        return string;
    }

    public String serialize(TreeNode root) {
        if (root == null) {
            return new String();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuilder stringBuilder = new StringBuilder();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                stringBuilder.append(node + ",");
                queue.add(node.left);
                queue.add(node.right);
            } else {
                stringBuilder.append("null,");
            }
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }


        public TreeNode deserialize0(String data) {
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
                continue;
            } else {
                for (int i = 0; i < size && !queue.isEmpty(); i++) {
                    TreeNode cur = curQueue.poll();
                    String string = queue.peek();
                    if (cur != null) {
                        if ("null".equals(string)) {
                            cur.left = null;
                        } else {
                            cur.left = new TreeNode(Integer.parseInt(string));
                        }
                        queue.poll();
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
                        curQueue.add(null);
                    }
                }
            }
            size *= 2;
        }
        return root;
    }

    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        String[] strings = data.split(",");
        int index = 0;
        TreeNode root = new TreeNode(Integer.parseInt(strings[index++]));
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (!"null".equals(strings[index])) {
                cur.left = new TreeNode(Integer.parseInt(strings[index]));
                queue.add(cur.left);
            }
            index++;
            if (!"null".equals(strings[index])) {
                cur.right = new TreeNode(Integer.parseInt(strings[index]));
                queue.add(cur.right);
            }
            index++;
        }
        return root;
    }

    public void post(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        post(root.left);
        post(root.right);
    }

    //字符串的排列
    public String[] permutation0(String s) {
        if (s == null || s.length() == 0) {
            return new String[0];
        }
        Set<String> solutions = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        dfs(solutions, set, s.toCharArray(), new char[s.length()]);
        int size = solutions.size();
        String[] strings = new String[size];
        int index = 0;
        for (String str : solutions) {
            strings[index++] = str;
        }
        return strings;
    }
    private void dfs(Set<String> solutions, Set<Integer> set, char[] chars, char[] sol) {
        if (set.size() == chars.length) {
            solutions.add(new String(sol));
        }
        for (int i = 0; i < chars.length; i++) {
            if (set.contains(i)) {
                continue;
            }
            sol[set.size()] = chars[i];
            set.add(i);
            dfs(solutions, set, chars, sol);
            set.remove(i);
        }
    }

    public String[] permutation(String s) {
        if (s == null) {
            return new String[0];
        }
        char[] chars = s.toCharArray();
        ArrayList<String> solutions = new ArrayList<>();
        dfs(chars, 0, solutions);
        return solutions.toArray(new String[solutions.size()]);
    }

    private void dfs(char[] chars, int index, ArrayList<String> solutions) {
        if (index == chars.length - 1) {
            solutions.add(new String(chars));
            return;
        }
        Set<Character> set = new HashSet<>();
        for (int i = index; i < chars.length; i++) {
            if (set.contains(chars[i])) {
                continue;
            }
            set.add(chars[i]);
            swap(chars, index, i);
            dfs(chars, index + 1, solutions);
            swap(chars, index, i);
        }
    }
    private void swap(char[] chars, int a, int b) {
        char ch = chars[a];
        chars[a] = chars[b];
        chars[b] = ch;
    }

    public static void main(String[] args) {
        Offer0 o = new Offer0();
//        TreeNode root = new TreeNode(0);
//        root.left = new TreeNode(1);
//        root.right = new TreeNode(2);
//        root.left.right = new TreeNode(3);
//        System.out.println(o.serialize(root));
        String s = "5,2,3,null,null,2,4,3,1";
        TreeNode root = o.deserialize(s);
        System.out.println(o.serialize(root));
    }
}