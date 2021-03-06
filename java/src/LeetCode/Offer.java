package LeetCode;

import java.util.*;

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

    public static boolean isNumber(String s) {
        if (s == null) {
            return false;
        }
        int i = 0;
        s = s.toLowerCase().trim();
        if (s.equals("-.") || s.equals("+.")) {
            return false;
        }
        if (s.length() == 0) {
            return false;
        }
        int len = s.length();
        boolean place = false;
        int star = -2;
        char c = s.charAt(0);
        if (c == '-' || c == '+' || c == '.' || c == 'e') {
            if (len == 1 || c == 'e') {
                return false;
            }
            if (c != '.') {
                i++;
            }
        }
        c = s.charAt(len - 1);
        if (c == 'e' || s.charAt(i) == 'e') {
            return false;
        }
        boolean starE = false;
        for (; i < len; i++) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') {
                continue;
            }
            if (!place && ch == '.') {
                if (star == i - 1) {
                    return false;
                }
                star = i;
                place = true;
                continue;
            }
            if (!starE && ch == 'e') {
                star = i;
                starE = true;
                continue;
            }
            return false;
        }
        return true;
    }

    // 调整数组顺序使奇数位于偶数前面
    public int[] exchange(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        int fast = 0;
        int slow = 0;
        for (; fast < nums.length; fast++) {
            if (nums[fast] % 2 == 1) {
                int temp = nums[fast];
                nums[fast] = nums[slow];
                nums[slow] = temp;
                slow++;
            }
        }
        return nums;
    }

    // 链表中倒数第k个节点
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && k > 0) {
            fast = fast.next;
            k--;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    // 反转链表
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }

    // 合并两个排序的链表
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = new ListNode(-1);
        ListNode tail = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        if (l1 == null) {
            tail.next = l2;
        } else {
            tail.next = l1;
        }
        return head.next;
    }

    // 树的子结构
    // 遍历+判断
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        return helper(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean helper(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null) {
            return false;
        }
        if (A.val == B.val) {
            boolean left = helper(A.left, B.left);
            boolean right = helper(A.right, B.right);
            return left && right;
        }
        return false;
    }

    // 二叉树的镜像
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }

    // 对称的二叉树
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return help(root.left, root.right);
    }

    private boolean help(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val == right.val) {
            return help(left.left, right.right) && help(left.right, right.left);
        }
        return false;
    }

    // 顺时针打印矩阵
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null) {
            return null;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int r = 0;
        int c = 0;
        int[] ret = new int[row * col];
        int index = 0;
        row--;
        col--;
        while (true) {
            for (int i = c; i <= col; i++) {
                ret[index++] = matrix[r][i];
            }
            r++;
            if (index >= ret.length) {
                break;
            }
            for (int i = r; i <= row; i++) {
                ret[index++] = matrix[i][col];
            }
            col--;
            if (index >= ret.length) {
                break;
            }
            for (int i = col; i >= c; i--) {
                ret[index++] = matrix[row][i];
            }
            row--;
            if (index >= ret.length) {
                break;
            }
            for (int i = row; i >= r; i--) {
                ret[index++] = matrix[i][c];
            }
            c++;
            if (index >= ret.length) {
                break;
            }
        }
        return ret;
    }

    // 栈的压入、弹出序列
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed == null || popped == null) {
            return false;
        }
        int lenPush = pushed.length;
        int lenPop = popped.length;
        if (lenPop != lenPush) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int value : pushed) {
            stack.push(value);
            while (!stack.isEmpty() && stack.peek() == popped[index]) {
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }

//    从上到下打印二叉树 I
    public int[] levelOrder0(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            if (treeNode != null) {
                arrayList.add(treeNode.val);
                queue.add(treeNode.left);
                queue.add(treeNode.right);
            }
        }
        int[] ret = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            ret[i] = arrayList.get(i);
        }
        return ret;
    }
//    从上到下打印二叉树 II
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                list.add(treeNode.val);
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
            ret.add(list);
        }
        return ret;
    }

    //    从上到下打印二叉树 III
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int star = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                if (star == - 1) {
                    list.add(treeNode.val);
                } else {
                    list.add(treeNode.val, 0);
                }
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
            star = star * -1;
            ret.add(list);
        }
        return ret;
    }

//    二叉搜索树的后序遍历序列
    public boolean verifyPostorder0(int[] postorder) {
        if (postorder == null || postorder.length == 0) {
            return false;
        }
        return isTrue(postorder, 0, postorder.length - 1);
    }

    private boolean isTrue(int[] postorder, int start, int end) {
        if (start >= end) {
            return true;
        }
        int num = postorder[end];
        int i = start;
        for (; i < end; i++) {
            if (postorder[i] > num) {
                break;
            }
        }
        for (int j = i; j < end; j++) {
            if (postorder[j] < num) {
                return false;
            }
        }
        return isTrue(postorder, start, i - 1) && isTrue(postorder, i, end - 1);
    }

    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;
        // 根->右子树->左子树
        for (int i = postorder.length - 1; i >= 0; i--) {
            if (postorder[i] > root) {
                return false;
            }
            while (!stack.isEmpty() && stack.peek() > postorder[i]) {
                root = stack.pop();
            }
            stack.push(postorder[i]);
        }
        return true;
    }

    // 二叉树中和为某一值的路径。
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> lists = new LinkedList<>();
        if (root == null) {
            return lists;
        }
        helper(root, new LinkedList<Integer>(), lists, sum, 0);
        return lists;
    }

    private void helper(TreeNode root, LinkedList<Integer> list, List<List<Integer>> lists, int sum, int curSum) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        if (curSum + root.val == sum && root.left == null && root.right == null) {
            lists.add(new LinkedList<>(list));
        }
        helper(root.left, list, lists, sum, curSum + root.val);
        helper(root.right, list, lists, sum, curSum + root.val);
        list.removeLast();
    }

    // 复杂链表的复制
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList0(Node head) {
        Map<Node, Node> map = new HashMap<>();
        for (Node cur = head; cur != null; cur = cur.next) {
            map.put(cur, new Node(cur.val));
        }
        for (Node cur = head; cur != null; cur = cur.next) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
        }
        return map.get(head);
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        // 复制next指针
        for (Node cur = head; cur != null; cur = cur.next) {
            Node node = new Node(cur.val);
            Node next = cur.next;
            cur.next = node;
            node.next = next;
            cur = cur.next;
        }
        // 复制随机指针
        for (Node cur = head; cur != null; cur = cur.next.next) {
            if (cur.random != null)
                cur.next.random = cur.random.next;
        }
        // 一分为二
        Node ret = head.next;
        Node node = ret;
        head.next = head.next.next;
        for (Node cur = ret.next; cur != null; cur = cur.next) {
            node.next = cur.next;
            cur.next = cur.next.next;
            node = node.next;
        }
        return ret;
    }

    public static void main(String[] args) {
        isNumber("2e0");
    }
}
