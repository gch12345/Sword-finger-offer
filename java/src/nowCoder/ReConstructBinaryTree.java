package nowCoder;

import java.util.HashMap;
import java.util.Map;
//输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class ReConstructBinaryTree {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        return helper (pre, 0, pre.length - 1, in, 0, in.length -1);
    }
    private TreeNode helper(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        if (endPre < startPre || endIn < startIn) {
            return null;
        }
        TreeNode root = new TreeNode(pre[startPre]);
        for (int i = startIn; i <= endIn; i++) {
            if (in[i] == pre[startPre]) {
                root.left = helper(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
                root.right = helper(pre, startPre + i - startIn + 1, endPre, in, i + 1, endIn);
                break;
            }
        }
        return root;
    }

    Map<Integer, Integer> map = new HashMap<>();
    int index = 0;
    public TreeNode reConstructBinaryTree0(int [] pre,int [] in) {
        for (; index < in.length; index++) {
            map.put(in[index], index);
        }
        index = 0;
        return helper(pre, in, 0, in.length - 1);
    }
    private TreeNode helper(int[] pre, int[] in, int startIn, int endIn) {
        if (startIn > endIn || index > in.length - 1) {
            return null;
        }
        TreeNode root = new TreeNode(pre[index++]);
        int pos = map.get(root.val);
        root.left = helper(pre, in, startIn, pos - 1);
        root.right = helper(pre, in, pos + 1, endIn);
        return root;
    }
}
