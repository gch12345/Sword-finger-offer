package nowCoder;

import java.util.HashMap;
import java.util.Map;

//根据一棵树的中序遍历与后序遍历构造二叉树。

public class BuildTree {
    Map<Integer, Integer> map = new HashMap<>();
    int index = 0;
    public TreeNode buildTree0(int[] inorder, int[] postorder) {
        index = 0;
        for (index = 0; index < inorder.length; index++) {
            map.put(inorder[index], index);
        }
        index--;
        return helper(inorder, postorder, 0, inorder.length -1);
    }
    private TreeNode helper(int[] inorder, int[] postorder, int startIn, int endIn) {
        if (startIn > endIn || index < 0) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[index--]);
        int pos = map.get(root.val);
        root.right = helper(inorder, postorder, pos + 1, endIn);
        root.left = helper(inorder, postorder, startIn, pos - 1);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    private TreeNode helper(int[] in, int startIn, int endIn, int[] post, int startPost, int endPost) {
        if (startIn > endIn || startPost > endPost) {
            return null;
        }
        TreeNode root = new TreeNode(post[endPost]);
        for (int i = startIn; i <= endIn; i++) {
            if (in[i] == post[endPost]) {
                root.left = helper(in, startIn, i - 1, post, startPost, startPost + i - startIn - 1);
                root.right = helper(in, i + 1, endIn, post, startPost + i - startIn, endPost - 1);
            }
        }
        return root;
    }
}
