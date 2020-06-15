package LeetCode;

import java.util.HashMap;
import java.util.Stack;

public class Offer1 {
    // 53 - II. 0～n-1中缺失的数字
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        int mid = left + (right - left) / 2;
        while (left <= right) {
            if (mid == nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            mid = left + (right - left) / 2;
        }
        return left;
    }

    //54. 二叉搜索树的第k大节点
    // 中序遍历
    public int kthLargest0(TreeNode root, int k) {
        if (root == null || k <= 0) {
            return Integer.MIN_VALUE;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        int count = 0;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.right;
            }
            cur = stack.pop();
            count++;
            if (count == k) {
                break;
            }
            cur = cur.left;
        }
        return cur.val;
    }

    int k;
    int ret;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        if (root == null || k <= 0) {
            return Integer.MAX_VALUE;
        }
        dfs(root);
        return ret;
    }

    private void dfs(TreeNode root) {
        if (k == 0 || root == null) {
            return;
        }
        dfs(root.right);
        if (k == 0) {
            return;
        }
        ret = root.val;
        k--;
        dfs(root.left);
    }

    class Node{
        int val;
        Node left;
        Node right;
    }

//    36. 二叉搜索树与双向链表
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return root;
        }
        Stack<Node> stack = new Stack<>();
        Node head = null;
        Node prev = null;
        Node cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (prev == null) {
                head = cur;
            } else {
                prev.right = cur;
            }
            cur.left = prev;
            prev = cur;
            cur = cur.right;
        }
        head.left = prev;
        prev.right = head;
        return head;
    }
}
