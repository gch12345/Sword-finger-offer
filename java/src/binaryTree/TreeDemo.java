package binaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public TreeNode buildtree(int[] preorder, int[] inorder) {
        index = 0;
        if (preorder.length == 0) {
            return null;
        }
        return Helper(preorder, inorder, 0, inorder.length);
    }

    private TreeNode Helper(int[] pereorder, int[] inorder, int inorderLeft, int inorderRight) {
        if (inorderLeft >= inorderRight) {
            return null;
        }
        if (index >= pereorder.length) {
            return null;
        }
        TreeNode root = new TreeNode(pereorder[index]);
        int pos = find(inorder, inorderLeft, inorderRight, pereorder[index]);
        index++;
        root.left = Helper(pereorder, inorder, inorderLeft, pos);
        root.right = Helper(pereorder, inorder, pos + 1, inorderRight);
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

    //根据一棵树的中序遍历与后序遍历构造二叉树。
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        index = 0;
        for (int a: inorder
             ) {
            map.put(a, index++);
        }
        index--;
        return helper(inorder, postorder, 0, inorder.length);
    }

    private TreeNode helper(int[] inorder, int[] postorder, int inorderLeft, int inorderRight) {
        if (inorderLeft >= inorderRight) {
            return null;
        }
        if (index < 0) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[index]);
        index--;
        int pos = map.get(root.val);
        root.right = helper(inorder, postorder, pos + 1, inorderRight);
        root.left = helper(inorder, postorder, inorderLeft, pos);
        return root;
    }

    //根据二叉树创建字符串
    StringBuffer str = new StringBuffer();
    public String tree2str(TreeNode t) {
        help(t);
        String re = str.toString();
        return re;
    }
    private void help(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            str.append(root.val);
            return;
        }
        str.append(root.val);
        str.append("(");
        help(root.left);
        str.append(")");
        if (root.right == null) {
            return;
        }
        str.append("(");
        help(root.right);
        str.append(")");
    }
}
