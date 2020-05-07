package LeetCode;

import sun.reflect.generics.tree.Tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Offer {
    // 数组中重复的数字
    public int findRepeatNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }

    //    二维数组中的查找
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int curRow = row - 1;
        int curCol = 0;
        while (curRow >= 0 && curCol < col) {
            if (matrix[curRow][curCol] > target) {
                curRow--;
            } else if (matrix[curRow][curCol] < target) {
                curCol++;
            } else {
                return true;
            }
        }
        return false;
    }

    // 替换空格
    public String replaceSpace(String s) {
        int length = s.length();
        char[] array = new char[length * 3];
        int size = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                array[size++] = '%';
                array[size++] = '2';
                array[size++] = '0';
            } else {
                array[size++] = c;
            }
        }
        String retStr = new String(array, 0, size);
        return retStr;
    }

    // 重建树
    Map<Integer, Integer> map = new HashMap<>();
    int index;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, inorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preOrder, int[] inOrder, int inLeft, int inRight) {
        if (inLeft > inRight || index >= preOrder.length) {
            return null;
        }
        TreeNode root = new TreeNode(preOrder[index]);
        int order = map.get(preOrder[index++]);
        root.left = helper(preOrder, inOrder, inLeft, order - 1);
        root.right = helper(preOrder, inOrder, order + 1, inRight);
        return root;
    }

    private Stack<Integer> appendStack = new Stack<>();
    private Stack<Integer> deleteStack = new Stack<>();

    public void appendTail(int value) {
        appendStack.push(value);
    }

    public int deleteHead() {
        if (deleteStack.isEmpty()) {
            if (appendStack.isEmpty()) {
                return -1;
            } else {
                while (!appendStack.isEmpty()) {
                    deleteStack.push(appendStack.pop());
                }
            }
        }
        return deleteStack.pop();
    }

    public int minArray(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return Integer.MIN_VALUE;
        }
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (numbers[right] < numbers[mid]) {
                left = mid + 1;
            } else if (numbers[right] == numbers[mid]) {
                right--;
            } else {
                right = mid;
            }
        }
        return numbers[left];
    }

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null) {
            return false;
        }
        boolean[][] star = new boolean[board.length][board[0].length];
        char[] ch = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == ch[0]) {
                    return helper(board, ch, 0, i, j, star);
                }
            }
        }
        return false;
    }

    private boolean helper(char[][] board, char[] ch, int index, int row, int col, boolean[][] star) {
        if (index >= ch.length) {
            return true;
        }
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) {
            return false;
        }
        if (star[row][col]) {
            return false;
        }
        if (board[row][col] == ch[index]) {
            star[row][col] = true;
            if (helper(board, ch, index + 1, row + 1, col, star)
                    || helper(board, ch, index + 1, row - 1, col, star)
                    || helper(board, ch, index + 1, row, col - 1, star)
                    || helper(board, ch, index + 1, row, col + 1, star)) {
                return true;
            }
            star[row][col] = false;
        }
        return false;
    }

    int ans = 0;
    boolean[][] star;

    public int movingCount(int m, int n, int k) {
        star = new boolean[m][n];
        BFS(m, n, k, 0, 0);
        return ans;
    }

    private void BFS(int m, int n, int k, int row, int col) {
        if (row >= m || col >= n) {
            return;
        }
        if (star[row][col]) {
            return;
        }
        int rowNum = bitNum(row);
        int colNum = bitNum(col);
        if (rowNum + colNum <= k) {
            star[row][col] = true;
            ans++;
        }
        BFS(m, n, k, row + 1, col);
        BFS(m, n, k, row, col + 1);
    }

    private int bitNum(int num) {
        int ret = 0;
        while (num != 0) {
            ret = ret + num % 10;
            num = num / 10;
        }
        return ret;
    }

    private void dp(int m, int n, int k) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (bitNum(i) + bitNum(j) <= k) {
                    if (i - 1 >= 0) {
                        dp[i][j] = dp[i][j] | dp[i - 1][j];
                    }
                    if (j - 1 >= 0) {
                        dp[i][j] = dp[i][j] | dp[i][j - 1];
                    }
                }
                ans += dp[i][j];
            }
        }
    }

    public int cuttingRope(int n) {
        if (n <= 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= n; i++) {
            for (int j = 1; j <= (i / 2); j++) {
                dp[i] = Math.max(dp[i], dp[j] * dp[i - j]);
            }
        }
        return dp[n];
    }

    public int cuttingRope0(int n) {
        if (n <= 1) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= (n + 1) / 2; i++) {
            for (int j = i; j <= n; j++) {
                dp[j] = Math.max(dp[j], dp[j - i] * i);
            }
        }
        return dp[n];
    }

    public int cuttingRope1(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = i; j > 0; j--) {
                dp[i] = Math.max(dp[i], dp[i - j] * j);
            }
        }
        return dp[n];
    }

    public int cuttingRope2(int n) {
        if (n <= 3) {
            return n - 1;
        }
        long a = 3;
        long ret = 1;
        int p = n % 3;
        for (int i = n / 3 - 1; i > 0; i /= 2) {
            if (i % 2 == 1) {
                ret = (ret * a) % ((int) 1e9 + 7);
            }
            a = (a * a) % ((int)1e9 + 7);
        }
        if (p == 0) {
            return (int)((ret * 3) % ((int)1e9 + 7));
        }
        if (p == 1) {
            return (int)((ret * 4) % ((int)1e9 + 7));
        }
        return (int)((ret * 6) % ((int)1e9 + 7));
    }

    public int hammingWeight(int n) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            if (n == 0) {
                break;
            }
            if ((n & 1) == 1) {
                ret++;
            }
            n = n >> 1;
        }
        return ret;
    }

    public static double myPow(double x, int n) {
        double ret = 1;
        boolean star = false;
        long b = n;
        if (n < 0) {
            b = -b;
            star = true;
        }
        for (long i = b; i > 0; i = i / 2) {
            if (i % 2 == 1) {
                ret = ret * x;
            }
            x = x * x;
        }
        if (star) {
            ret = 1 / ret;
        }
        return ret;
    }

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        if (head.val == val) {
            return head.next;
        }
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null) {
            if (cur.val == val) {
                prev.next = cur.next;
                break;
            }
            prev = cur;
            cur = cur.next;
        }
        return head;
    }

    public static boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        int len1 = s.length();
        int len2 = p.length();
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;
        for (int i = 0; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                char ch = p.charAt(j - 1);
                if (ch == '*') {
                    if (j >= 2) {
                        dp[i][j] |= dp[i][j - 2];
                    }
                    if (i > 0 &&j >= 2 && (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.') ) {
                        dp[i][j] |= dp[i - 1][j];
                    }
                } else {
                    if (i > 0 && (ch == s.charAt(i - 1) || ch == '.')) {
                        dp[i][j] |= dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {
        isMatch("aa", ".*");
        System.out.println(myPow(2, 10));
    }
}
