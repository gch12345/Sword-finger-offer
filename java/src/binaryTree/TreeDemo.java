package binaryTree;

import java.util.ArrayList;
import java.util.List;

public class TreeDemo {
    static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    //层序遍历
    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        help(root, 0);
        return result;
    }
    private void help(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (result.size() <= level) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        help(root.left, level + 1);
        help(root.right, level + 1);
    }

    private TreeNode re = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        find(root, p ,q);
        return re;
    }

    private boolean find(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        int left = find(root.left, p, q) ? 1 : 0;
        int right = find(root.right, p, q) ? 1 : 0;
        int mid = (root.val == p.val || root.val == q.val) ? 1 : 0;
        if (left + right + mid >= 2) {
            re = root;
        }
        return (left + right + mid) > 0;
    }
}
