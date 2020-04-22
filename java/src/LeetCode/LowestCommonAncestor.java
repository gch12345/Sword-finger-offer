package LeetCode;

public class LowestCommonAncestor {
    private TreeNode ret;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q);
        return ret;
    }

    private boolean helper (TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean left = helper(root.left, p, q);
        boolean right = helper(root.right, p, q);
        if (left && right) {
            ret = root;
            return true;
        }
        if ((root == p || root == q) && (left || right)) {
            ret = root;
            return true;
        }
        if (root == p || root == q) {
            return true;
        }
        return left || right;
    }
}
