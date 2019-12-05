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
}
