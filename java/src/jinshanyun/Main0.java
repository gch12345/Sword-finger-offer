package jinshanyun;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val) {
        this.val = val;
    }
}

public class Main0 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] strings = sc.nextLine().split(" ");
            int[] arr = new int[strings.length];
            for (int i = 0; i <  strings.length; i++) {
                arr[i] = Integer.parseInt(strings[i]);
            }
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            List<TreeNode> list = new ArrayList<>();
            TreeNode root = buildTree(arr, num1, num2, list);
            lowestCommonAncestor(root, list.get(0), list.get(1));
            System.out.println(ret.val);
        }
    }

    private static TreeNode buildTree(int[] arr, int num1, int num2, List<TreeNode> list) {
        TreeNode root = new TreeNode(arr[0]);
        Stack<TreeNode> stack = new Stack<>();
        int index = 1;
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode cur = new TreeNode(arr[index]);
            if (arr[index] == num1 || arr[index] == num2) {
                list.add(cur);
            }
            TreeNode parent = stack.peek();
            if (parent.left == null) {
                parent.left = cur;
            } else {
                parent.right = cur;
                stack.pop();
            }
            if (arr[index] != -1) {
                stack.add(cur);
            }
            index++;
        }
        return root;
    }

    static TreeNode ret;
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        help(root, p, q);
        return ret;
    }

    private static boolean help(TreeNode root, TreeNode p,  TreeNode q) {
        if (root.val == -1) {
            return false;
        }
        int left = help(root.left, p, q) ? 1 : 0;
        int right = help(root.right, p, q) ? 1 : 0;
        int mid = left + right;
        if (root == p || root == q) {
            mid++;
        }
        if (mid >= 2) {
            ret = root;
        }
        return mid > 0;
    }

    private static void order(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        order(root.left);
        order(root.right);
    }
}
