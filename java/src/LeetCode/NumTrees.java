package LeetCode;

import java.util.Stack;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class NumTrees {
    //不同的二叉搜索树
    public int numTrees(int n) {
        int[] array = new int[n + 1];
        array[0] = 1;
        array[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                array[i] += array[j - 1] * array[i - j];
            }
        }
        return array[n];
    }

    //验证二叉搜索树
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }
    private boolean helper(TreeNode root, Integer lower, Integer upper) {
        if (root == null) {
            return true;
        }
        if (lower != null && root.val <= lower) {
            return false;
        }
        if (upper != null && root.val >= upper) {
            return false;
        }
        boolean left = helper(root.left, lower, root.val);
        boolean right = helper(root.right, root.val, upper);
        if (!left || !right) {
            return false;
        }
        return true;
    }

    //二叉树展开为链表
    public void flatten(TreeNode root) {
        while (root != null) {
            if (root.left == null) {
                root = root.right;
            } else {
                TreeNode prev = root.left;
                while(prev.right != null) {
                    prev = prev.right;
                }
                prev.right = root.right;
                root.right = root.left;
                root.left = null;
            }
        }
    }
    public void flatten0(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode prve = null;
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (prve != null) {
                prve.right = cur;
                prve.left = null;
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
            prve = cur;
        }
    }
    private TreeNode prve = null;
    public void flatten1(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten1(root.right);
        flatten1(root.left);
        root.right = prve;
        root.left = null;
        prve = root;
    }
}
