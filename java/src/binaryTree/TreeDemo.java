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

    //最近公共祖先
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

    //二叉搜索树转换成一个排序的双向链表
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        if (pRootOfTree.left == null && pRootOfTree.right == null) {
            return pRootOfTree;
        }
        TreeNode left = Convert(pRootOfTree.left);
        TreeNode leftHead = left;
        while (leftHead != null && leftHead.right != null) {
            leftHead = leftHead.right;
        }
        if (left != null) {
            leftHead.right = pRootOfTree;
            pRootOfTree.left = leftHead;
        }
        TreeNode right = Convert(pRootOfTree.right);
        if (right != null) {
            pRootOfTree.right = right;
            right.left = pRootOfTree;
        }
        return left == null ? pRootOfTree : left;
    }

    //根据一棵树的前序遍历与中序遍历构造二叉树。
    int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        index = 0;
        if (preorder.length == 0) {
            return null;
        }
        return helper(preorder, inorder, 0, inorder.length);
    }

    private TreeNode helper(int[] pereorder, int[] inorder, int inorderLeft, int inorderRight) {
        if (inorderLeft >= inorderRight) {
            return null;
        }
        if (index >= pereorder.length) {
            return null;
        }
        TreeNode root = new TreeNode(pereorder[index]);
        int pos = find(inorder, inorderLeft, inorderRight, pereorder[index]);
        index++;
        root.left = helper(pereorder, inorder, inorderLeft, pos);
        root.right = helper(pereorder, inorder, pos + 1, inorderRight);
        return root;
    }
    private int find(int[] inorder, int inorderLeft, int inorderRight, int val) {
        for (int i = inorderLeft; i < inorderRight; i++) {
            if (inorder[i] == val) {
                return i;
            }
        }
        return -1;
    }
}
