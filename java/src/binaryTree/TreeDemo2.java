package binaryTree;

import java.util.*;

public class TreeDemo2 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    //最近公共祖先
    TreeNode ret = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        find(root, p, q);
        return ret;
    }

    private boolean find(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        int mid = (root == p || root == q) ? 1 : 0;
        int left = find(root.left, p, q) ? 1 : 0;
        int right = find(root.right, p ,q) ? 1 : 0;
            if (mid + left + right >= 2) {
                ret = root;
                return true;
        }
        return (mid + left + right) > 0;
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
        TreeNode cur = left;
        while (cur != null && cur.right != null) {
            cur = cur.right;
        }
        if (left != null) {
            cur.right = pRootOfTree;
            pRootOfTree.left = cur;
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
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree0(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, inorder, 0, preorder.length - 1);
    }
    public TreeNode helper(int[] perorder, int[] inorder, int inorderLeft, int inorderRight) {
        if (index >= perorder.length) {
            return null;
        }
        if (inorderLeft > inorderRight) {
            return null;
        }
        TreeNode root = new TreeNode(perorder[index++]);
        int ret = map.get(root.val);
        root.left = helper(perorder, inorder, inorderLeft, ret - 1);
        root.right = helper(perorder, inorder, ret + 1, inorderRight);
        return root;
    }

    //根据一棵树的中序遍历与后序遍历构造二叉树。
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        index = 0;
        for ( index = 0; index < inorder.length; index++) {
            map.put(inorder[index], index);
        }
        index--;
        return Helper(inorder, postorder, 0, inorder.length - 1);
    }
    private TreeNode Helper(int[] inorder, int[] postorder, int inorderLeft, int inorderRight) {
        if (inorderLeft > inorderRight) {
            return null;
        }
        if (index < 0) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[index--]);
        int pos = map.get(root.val);
        root.right = Helper(inorder, postorder, pos + 1, inorderRight);
        root.left = Helper(inorder, postorder, inorderLeft, pos - 1);
        return root;
    }

    StringBuffer string = new StringBuffer();
    public String tree2str(TreeNode t) {
        index = 0;
        help(t);
        return string.toString();
    }
    private void help(TreeNode t) {
        if (t == null) {
            return;
        }
        if (t.left == null && t.right== null) {
            string.append(t.val);
            return;
        }
        string.append(t.val);
        string.append('(');
        help(t.left);
        string.append(')');
        if (t.right == null) {
            return;
        }
        string.append('(');
        help(t.right);
        string.append(')');
    }
    //非递归前序遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            list.add(cur.val);
            if (cur.right != null) {
                stack.add(cur.right);
            }
            if (cur.left != null) {
                stack.add(cur.left);
            }
        }
        return list;
    }
    //非递归中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        //stack.add(root);
        TreeNode cur = root;
        while (true) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            if (stack.isEmpty()) {
                break;
            }
            TreeNode top = stack.pop();
            list.add(top.val);
            cur = top.right;
        }
        return list;
    }
    //非递归后序遍历
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;
        while (true) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            if (stack.isEmpty()) {
                break;
            }
            TreeNode top = stack.peek();
            if (top.right == null || top.right == prev) {
                stack.pop();
                list.add(top.val);
                prev = top;
            } else {
                cur = top.right;
            }
        }
        return list;
    }
}
