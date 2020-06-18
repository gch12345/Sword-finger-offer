package LeetCode;

import java.util.*;

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

    //55 - I. 二叉树的深度
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
    }

//    55 - II. 平衡二叉树
    public boolean isBalanced0(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left = isBalanced0(root.left);
        boolean right = isBalanced0(root.right);
        if (left && right && Math.abs(maxDepth(root.left) - maxDepth(root.right)) == 1) {
            return true;
        }
        return false;
    }

    public boolean isBalanced(TreeNode root) {
         int ret = help(root);
         if (ret == -1) {
             return false;
         }
        return true;
    }

    private int help(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = help(root.left);
        if (left == -1) {
            return -1;
        }
        int right = help(root.right);
        if (right == -1) {
            return -1;
        }
        return Math.abs(left - right) <= 1 ? Math.max(left, right) + 1 : -1;
    }

    //I. 数组中数字出现的次数
    public int[] singleNumbers(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int sum = nums[0];
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            sum = sum ^ nums[i];
        }
        int count = 0;
        while ((sum & 1) != 1) {
            sum = sum >> 1;
            count++;
        }
        int num1 = 0;
        int num2 = 0;
        for (int i = 0; i < len; i++) {
            if ((nums[i] >> count & 1) == 1) {
                num1 = num1 ^ nums[i];
            } else {
                num2 = num2 ^ nums[i];
            }
        }
        int[] ret = new int[2];
        ret[0] = num1;
        ret[1] = num2;
        return ret;
    }

    // 后序遍历
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode top = stack.peek();
            if (top.right == null || top.right == prev) {
                list.add(top.val);
                stack.pop();
                prev = top;
            } else {
                cur = top.right;
            }
        }
        return list;
    }

    private class fun {

    }

    // 堆排序
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        help(arr);
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[0];
            arr[0] = arr[arr.length - i];
            arr[arr.length - i] = temp;
            shiftDown(arr, 0, arr.length - i);
        }
    }
    // 建堆
    private static void help(int[] arr) {
        int index = (arr.length - 1 -1) / 2;
        for (; index >= 0; index--) {
            shiftDown(arr, index, arr.length);
        }
    }

    private static void shiftDown(int[] arr, int index, int length) {
        int parent = index;
        int child = parent * 2 + 1;
        while (child < length) {
            if (child + 1 < length && arr[child] < arr[child + 1]) {
                child = child + 1;
            }
            if (arr[child] <= arr[parent]) {
                return;
            }
            int temp = arr[child];
            arr[child] = arr[parent];
            arr[parent] = temp;
            parent = child;
            child = parent * 2 + 1;
        }
    }

    // 插入排序
    public static void insert(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            int num = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (num < arr[j]) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = num;
        }
    }

    public static void main(String[] args) {
        int[] arr = {3,1,6,3,7,1,7,2,0};
//        heapSort(arr);
        insert(arr);
        System.out.println(Arrays.toString(arr));
//        Class<?> c  = Offer1.class;
//        Class<?>[] classes = c.getDeclaredClasses();
//        for (Class<?> C : classes) {
//            System.out.println(C.getName());
//        }
    }
}
