package wangyi._2020_09_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val) {
        this.val = val;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int num = sc.nextInt();
            TreeNode root = new TreeNode(1);
            List<TreeNode> list = new ArrayList<>();
            list.add(root);
            for (int i = 2; i <= n; i++) {
                list.add(new TreeNode(i));
            }
            for (int i = 0; i < num; i++) {
                int parent = sc.nextInt();
                String s = sc.next();
                int child = sc.nextInt();
                if (s.equals("left")) {
                    list.get(parent - 1).left = list.get(child - 1);
                } else {
                    list.get(parent - 1).right = list.get(child - 1);
                }
            }
            helper(root);
            System.out.println(ret);
        }
    }
    static int ret = 0;
    public static boolean helper(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left = helper(root.left);
        boolean right = helper(root.right);
        if (left && right == true && root.left != null && root.right != null) {
            ret++;
            return false;
        }
        if (left == true && right == true) {
            return true;
        }
        return false;
    }
}
