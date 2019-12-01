package LeetCode;
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class NumTrees {
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

    public boolean isValidBST(TreeNode root) {
        return helper(root, root.val);
    }
    private boolean helper(TreeNode root, int x) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        boolean left = isValidBST(root.left);
        boolean right = isValidBST(root.right);
        if (left != true || right != true) {
            return false;
        }
        if (root.left == null ) {
            if (root.right.val > root.val && root.right.val > x)
                return true;
            else
                return false;
        }
        if (root.right == null ) {
            if (root.left.val < root.val && root.left.val < x)
                return true;
            else
                return false;
        }
        if (root.left.val < root.val && root.right.val > root.val && root.left.val < x && root.right.val > x) {
            return true;
        }
        return false;
    }
}
