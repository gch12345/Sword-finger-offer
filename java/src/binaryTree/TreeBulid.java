package binaryTree;

import java.util.Scanner;

public class TreeBulid {
    static class TreeNode {
        public char val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(char val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.next();
            TreeNode root = buildTree(str);
            inOrder(root);
            System.out.println();
        }
    }
    static int index = 0;
    public static TreeNode buildTree(String str) {
        if (str == null) {
            return null;
        }
        char s = str.charAt(index);
        if (s == '#') {
            return null;
        }
        TreeNode root = new TreeNode(s);
        index++;
        root.left = buildTree(str);
        index++;
        root.right = buildTree(str);
        return root;
    }
    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }
}
