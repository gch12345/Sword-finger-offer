package LeetCode;

import com.sun.org.apache.bcel.internal.generic.ARETURN;
import org.junit.Test;

import java.util.*;

public class DailyQuestion {
    // 63. 不同路径 II
    int count = 0;
    int[][] point = {{0, 1}, {1, 0}};

    public int uniquePathsWithObstacles0(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        dfs(obstacleGrid, 0, 0);
        return count;
    }

    private void dfs(int[][] arr, int row, int col) {
        if (row == arr.length && col == arr[0].length) {
            count++;
            return;
        }
        if (row >= arr.length || col >= arr[0].length || arr[row][col] == 1) {
            return;
        }
        for (int i = 0; i < point.length; i++) {
            dfs(arr, row + point[i][0], col + point[i][1]);
        }
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[row - 1][col - 1] == 1) {
            return 0;
        }
        int[][] dp = new int[row + 1][col + 1];
        dp[0][1] = 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }
                dp[i + 1][j + 1] = dp[i][j + 1] + dp[i + 1][j];
            }
        }
        return dp[row][col];
    }

    // 112. 路径总和
    public boolean hasPathSum0(TreeNode root, int sum) {
        return helper(root, sum, 0);
    }

    private boolean helper(TreeNode root, int sum, int curSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return curSum + root.val == sum;
        }
        if (curSum + root.val > sum) {
            return false;
        }
        return helper(root.left, sum, curSum + root.val) || helper(root.right, sum, curSum + root.val);
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> treeQueue = new LinkedList<>();
        Queue<Integer> treeSum = new LinkedList<>();
        treeQueue.add(root);
        treeSum.add(root.val);
        while (!treeQueue.isEmpty()) {
            for (int i = 0; i < treeQueue.size(); i++) {
                TreeNode curNode = treeQueue.poll();
                int curSum = treeSum.poll();
                if (curNode.left == null && curNode.right == null) {
                    if (curSum == sum) {
                        return true;
                    }
                    continue;
                }
                if (curNode.left != null) {
                    treeQueue.add(curNode.left);
                    treeSum.add(curSum + curNode.left.val);
                }
                if (curNode.right != null) {
                    treeQueue.add(curNode.right);
                    treeSum.add(curSum + curNode.right.val);
                }
            }
        }
        return false;
    }

    // 面试题 17.13. 恢复空格
    public int respace0(String[] dictionary, String sentence) {
        Set<String> set = new HashSet<>();
        set.addAll(Arrays.asList(dictionary));
        int[] dp = new int[sentence.length() + 1];
        dp[0] = 0;
        for (int i = 1; i <= sentence.length(); i++) {
            dp[i] = dp[i - 1] + 1;
            for (int j = 1; j <= i; j++) {
                if (set.contains(sentence.substring(j - 1, i))) {
                    dp[i] = Math.min(dp[i], dp[j - 1]);
                }
            }
        }
        return dp[sentence.length()];
    }

    public int respace(String[] dictionary, String sentence) {
        int[] dp = new int[sentence.length() + 1];
        dp[0] = 0;
        for (int i = 1; i <= sentence.length(); i++) {
            dp[i] = dp[i - 1] + 1;
            for (int j = 0; j < dictionary.length; j++) {
                if (sentence.substring(0, i).endsWith(dictionary[j])) {
                    dp[i] = Math.min(dp[i], dp[i - dictionary[j].length()]);
                }
            }
        }
        return dp[sentence.length()];
    }

    // 309. 最佳买卖股票时机含冷冻期
    // dp[i][j][k]
    // i -> 第几天
    // j -> 是否有股票
    // k -> 是否交易
    public int maxProfit0(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int[][][] dp = new int[prices.length + 1][2][2];
        dp[0][1][0] = Integer.MIN_VALUE;
        for (int i = 1; i <= prices.length; i++) {
            dp[i][0][1] = dp[i - 1][1][0] + prices[i - 1];
            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][0][0] - prices[i - 1]);
            dp[i][0][0] = Math.max(dp[i - 1][0][0], dp[i - 1][0][1]);
        }
        return Math.max(dp[prices.length][0][0], dp[prices.length][0][1]);
    }

    // dp[i][j]
    // i -> 第几天
    // j -> 是否持有股票
    // dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
    // dp[i][1] = max(dp[i - 1][1], dp[i - 2][0] - prides[i]);
    // 当买入的时候 前天就不能有股票
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int[][] dp = new int[prices.length + 1][2];
        dp[0][1] = Integer.MIN_VALUE;
        for (int i = 1; i <= prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 1]);
            if (i < 2) {
                dp[i][1] = Math.max(dp[i - 1][1], -prices[i - 1]);
            } else {
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i - 1]);
            }
        }
        return dp[prices.length][0];
    }

    // 315. 计算右侧小于当前元素的个数
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if (nums == null || nums.length <= 0) {
            return list;
        }
        int len = nums.length;
        int[] count = new int[len];
        int[] index = new int[len];
        for (int i = 0; i < len; i++) {
            index[i] = i;
        }
        merge(nums, 0, len - 1, count, index);
        for (int i = 0; i < len; i++) {
            list.add(count[i]);
        }
        return list;
    }

    private void merge(int[] nums, int left, int right, int[] count, int[] index) {
        if (left >= right) {
            return;
        }
        int[] temp = new int[right - left + 1];
        int mid = (right - left) / 2 + left;
        merge(nums, left, mid, count, index);
        merge(nums, mid + 1, right, count, index);
        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i > mid) {
                temp[k - left] = index[j++];
            } else if (j > right) {
                temp[k - left] = index[i++];
            } else if (nums[index[i]] <= nums[index[j]]) {
                temp[k - left] = index[j++];
            } else {
                temp[k - left] = index[i];
                count[index[i]] += right - j + 1;
                i++;
            }
        }
        for (i = left; i <= right; i++) {
            index[i] = temp[i - left];
        }
    }

    // 350. 两个数组的交集 II
    public int[] intersect0(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            if (map.containsKey(nums1[i])) {
                map.put(nums1[i], map.get(nums1[i]) + 1);
            } else {
                map.put(nums1[i], 1);
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i]) && map.get(nums2[i]) > 0) {
                list.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i]) - 1);
            }
        }
        int[] ret = new int[list.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                list.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] ret = new int[list.size()];
        for (i = 0; i < list.size(); i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }


    //143. 重排链表(折叠链表)
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode cur = null;
        ListNode node = slow.next;
        while (node != null) {
            ListNode list = node.next;
            node.next = cur;
            cur = node;
            node = list;
        }
        slow.next = null;
        ListNode newHead = new ListNode(-1);
        ListNode newTail = newHead;
        while (cur != null && head != null) {
            newTail.next = head;
            newTail = newTail.next;
            head = head.next;
            newTail.next = cur;
            newTail = newTail.next;
            cur = cur.next;
        }
        if (cur == null) {
            newTail.next = head;
        } else {
            newTail.next = cur;
        }
        head = newHead.next;
    }

    // 120. 三角形最小路径和
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return -1;
        }
        int[] cur = new int[triangle.size()];
        for (int i = 0; i < triangle.size(); i++) {
            List<Integer> list = triangle.get(i);
            int temp = cur[0];
            cur[0] = cur[0] + list.get(0);
            for (int j = 1; j < list.size(); j++) {
                int num = cur[j];
                if (j == list.size() - 1) {
                    cur[j] = temp + list.get(j);
                    break;
                }
                cur[j] = Math.min(temp, cur[j]) + list.get(j);
                temp = num;
            }
        }
        int ret = Integer.MAX_VALUE;
        for (int i = 0; i < cur.length; i++) {
            if (cur[i] < ret) {
                ret = cur[i];
            }
        }
        return ret;
    }

    // 96. 不同的二叉搜索树
    public int numTrees(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[i - j - 1] * dp[j];
            }
        }
        return dp[n];
    }

    // 100. 相同的树
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        boolean left = isSameTree(p.left, q.left);
        boolean right = isSameTree(p.right, q.right);
        return left && right;
    }

    // 572. 另一个树的子树
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null || t == null) {
            return false;
        }
        return isSameTree(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    // 104. 二叉树的最大深度
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    // 110. 平衡二叉树
    public boolean isBalanced0(TreeNode root) {
        return helper(root) != -1;
    }
    private int helper0(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = helper0(root.left);
        if (left == -1) {
            return -1;
        }
        int right = helper0(root.right);
        if (right == -1) {
            return -1;
        }
        if (Math.abs(left - right) < 2) {
            return 1 + Math.max(left, right);
        }
        return -1;
    }

    // 101. 对称二叉树
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val == right.val) {
            return helper(left.left, right.right) &&
            helper(left.right, right.left);
        }
        return false;
    }

    // 236. 二叉树的最近公共祖先
    TreeNode node = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        helper(root, p, q);
        return node;
    }

    private boolean helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        int left = helper(root.left, p, q) ? 1 : 0;
        int right = helper(root.right, p, q) ? 1 : 0;
        int mid = (root == p || root == q) ? 1 :0;
        if (left + right + mid >= 2) {
            node = root;
            return true;
        }
        return (left + right + mid) >= 1;
    }

    // 114. 二叉树展开为链表
    TreeNode next;
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.right = next;
        root.left = null;
        next = root;
    }

    @Test
    public void test() {
        DailyQuestion dailyQuestion = new DailyQuestion();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        dailyQuestion.flatten(root);
    }

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };

    // 剑指 Offer 36. 二叉搜索树与双向链表
    Node head = null;
    Node prev = null;
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        helper(root);
        head.left = prev;
        prev.right = head;
        return head;
    }
    private void helper(Node root) {
        if (root == null) {
            return;
        }
        helper(root.left);
        if (head == null) {
            head = root;
        } else {
            prev.right = root;
            root.left = prev;
        }
        prev = root;
        helper(root.right);
    }

    //35. 搜索插入位置
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // 剑指 Offer 11. 旋转数组的最小数字
    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (numbers[right] < numbers[mid]) {
                left = mid + 1;
            } else if (numbers[right] > numbers[mid]) {
                right = mid;
            } else {
                right--;
            }
        }
        return numbers[left];
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return false;
        }
        return helper(root) != -1;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left);
        if (left == -1) {
            return -1;
        }
        int right = helper(root.right);
        if (right == -1) {
            return -1;
        }
        return Math.abs(left - right) <= 1 ? 1 + Math.max(left, right) : -1;
    }

    // 97. 交错字符串
    class point {
        int x;
        int y;
        public point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public boolean isInterleave0(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null) {
            return false;
        }
        char[] S1 = s1.toCharArray();
        char[] S2 = s2.toCharArray();
        char[] S3 = s3.toCharArray();
        List<List<point>> lists = new ArrayList<>();
        List<point> list = new ArrayList<>();
        if (S1[0] == S3[0]) {
            list.add(new point(0, -1));
        }
        if (S2[0] == S3[0]) {
            list.add(new point(-1, 0));
        }
        lists.add(list);
        if (lists.isEmpty()) {
            return false;
        }
        for (int i = 1; i < s3.length(); i++) {
            list = lists.get(i - 1);
            List<point> list1 = new ArrayList<>();
            for (int j = 0; j < list.size(); j++) {
                point point = list.get(j);
                if (point.x + 1 < S1.length && S3[i] == S1[point.x + 1]) {
                    list1.add(new point(point.x + 1, point.y));
                }
                if (point.y + 1 < S2.length && S3[i] == S2[point.y + 1]) {
                    list1.add(new point(point.x, point.y + 1));
                }
            }
            lists.add(list1);
        }
        if (lists.get(lists.size() - 1).isEmpty()) {
            return false;
        }
        return true;
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null) {
            return false;
        }
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        int len1 = s1.length();
        int len2 = s2.length();
        boolean dp[][] = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++){
                if (i > 0) {
                    dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                }
                if (j > 0) {
                    dp[i][j] = dp[i][j]  || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                }
            }
        }
        return dp[len1][len2];
    }

    // 167. 两数之和 II - 输入有序数组
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
            return new int[0];
        }
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            if (numbers[i] + numbers[j] == target) {
                break;
            } else if (numbers[i] + numbers[j] < target) {
                i++;
            } else {
                j--;
            }
        }
        int[] ret = new int[2];
        ret[0] = i + 1;
        ret[1] = j + 1;
        return ret;
    }

    // 奇偶分离，并保证奇偶各自的相对位置不变
    public static void reOrderArray(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int num = array[i];
            if (array[i] % 2 == 0) {
                continue;
            }
            int j = i - 1;
            while (j >= 0 && array[j] % 2 == 0) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = num;
        }
    }

    @Test
    public void test0() {
        int[] array = {1,2,3,4,5,6,7,8};
        reOrderArray(array);
        System.out.println(Arrays.toString(array));
    }

    // 95. 不同的二叉搜索树 II
    public static List<TreeNode> generateTrees(int n) {
        List<TreeNode>[] dp = new ArrayList[n + 1];
        dp[0] = new ArrayList<>();
        dp[0].add(null);
        dp[1] = new ArrayList<>();
        dp[1].add(new TreeNode(1));
        if (n <= 1) {
            return dp[n];
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                for (int k = 0; k < dp[j].size(); k++) {
                    for (int m = 0; m < dp[i - j - 1].size(); m++) {
                        TreeNode root = new TreeNode(j + 1);
                        root.left = dp[j].get(k);
                        root.right = dp[i - j - 1].get(m);
                        if (dp[i] == null) {
                            dp[i] = new ArrayList<>();
                        }
                        dp[i].add(root);
                    }
                }
            }
        }
        return dp[n];
    }

    @Test
    public void test1() {
        generateTrees(3);
    }

    //64. 最小路径和
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < col; i++) {
            dp[0][i] = grid[0][i] + dp[0][i - 1];
        }
        for (int i = 1; i < row; i++) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++ ) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[row - 1][col - 1];
    }

    // 1025. 除数博弈
    public boolean divisorGame0(int N) {
        int count = 0;
        for (int i = N - 1; i > 0; i--) {
            if (N % i == 0) {
                count = N / i;
                break;
            }
        }
        return count % 2 != 0;
    }

    public boolean divisorGame(int N) {
        boolean[] dp = new boolean[N + 1];
        dp[1] = false;
        for (int i = 2; i <= N; i++) {
            for (int j = i - 1; j > 0; j--) {
                if (i % j == 0 && !dp[i - j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[N];
    }

    // 二叉搜索树和双向链表
    TreeNode Head = null;
    TreeNode Prev = null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        Head.left = Prev;
        Prev.right = Head;
        return Head;
    }

    private void help(TreeNode root) {
        if (root == null) {
            return;
        }
        help(root.left);
        if (Head == null) {
            Head = root;
        } else {
            Prev.right = root;
            root.left = Prev;
        }
        Prev = root;
        help(root.right);
    }

    // 中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack =  new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }
        return list;
    }

    //410. 分割数组的最大值
    public int splitArray0(int[] nums, int m) {
        if (nums == null || nums.length == 0 || m > nums.length) {
            return 0;
        }
        int len = nums.length;
        int[][] dp = new int[len + 1][m + 1];
        int[] sum = new int[len + 1];
        for (int i = 0; i <= len; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < len; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= Math.min(i, m); j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = j - 1; k < i; k++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j - 1], sum[i] - sum[k]));
                }
            }
        }
        return dp[len][m];
    }

    //(最大值的最小)二分
    public int splitArray(int[] nums, int m) {
        int sum = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        int left = max;
        int right = sum;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            int count = 1;
            int curSum = 0;
            for (int i = 0; i < nums.length; i++) {
                if (curSum + nums[i] > mid) {
                    count++;
                    curSum = nums[i];
                } else {
                    curSum += nums[i];
                }
            }
            if (count > m) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    // 875. 爱吃香蕉的珂珂
    public int minEatingSpeed(int[] piles, int H) {
        int left = 1;
        int right = piles[0];
        for (int i = 1; i < piles.length; i++) {
            if (right < piles[i]) {
                right = piles[i];
            }
        }
        while (left < right) {
            int mid = (right - left) / 2 + left;
            int count = 0;
            for (int i = 0; i < piles.length; i++) {
                count += (piles[i] - 1)/ mid + 1;
            }
            if (count > H) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    // 1011. 在 D 天内送达包裹的能力
    public int shipWithinDays(int[] weights, int D) {
        int left = weights[0];
        int right = weights[0];
        for (int i = 1; i < weights.length; i++) {
            if (left < weights[i]) {
                left = weights[i];
            }
            right += weights[i];
        }
        while (left < right) {
            int count = 1;
            int sum = 0;
            int mid = (right - left) / 2 + left;
            for (int i = 0; i < weights.length; i++) {
                if (sum + weights[i] > mid) {
                    count++;
                    sum = weights[i];
                } else {
                    sum += weights[i];
                }
            }
            if (count > D) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    int[][] p = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int ret = 0;
        int[][] cache = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                ret = Math.max(ret, help(matrix, cache, i, j));
            }
        }
        return ret;
    }

    private int help(int[][] matrix, int[][] cache, int i, int j) {
        if (cache[i][j] != 0) {
            return cache[i][j];
        }
        for (int k = 0; k < 4; k++) {
            if (i + p[k][0] >= 0 && i + p[k][0] < matrix.length
                    && j + p[k][1] >= 0 && j + p[k][1] < matrix[0].length
                    && matrix[i][j] < matrix[i + p[k][0]][j + p[k][1]]) {
                cache[i][j] = Math.max(cache[i][j], help(matrix, cache, i + p[k][0], j + p[k][1]));
            }
        }
        return ++cache[i][j];
    }

    // 105. 从前序与中序遍历序列构造二叉树
    int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }
        return helper(preorder, inorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int[] inorder,int start, int end) {
        if (index > preorder.length || end < start) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[index]);
        int curIndex = -1;
        for (int i = start; i <= end; i++) {
            if (inorder[i] == preorder[index]) {
                curIndex = i;
            }
        }
        index++;
        root.left = helper(preorder, inorder, start, curIndex - 1);
        root.right = helper(preorder, inorder, curIndex + 1, end);
        return root;
    }

    // 删除重复元素
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode head = new ListNode(Integer.MIN_VALUE);
        head.next = pHead;
        ListNode slow = head;
        ListNode fast = pHead;
        while (fast != null) {
            if (slow.val != fast.val) {
                slow.next = fast;
                slow = fast;
            }
            fast = fast.next;
        }
        slow.next = null;
        return head.next;
    }

    // 只保留没有重复的元素
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode Head = new ListNode(Integer.MIN_VALUE);
        Head.next = head;
        ListNode prev = Head;
        ListNode cur = head;
        // 1 2 2 3
        while (cur != null) {
            int num = cur.val;
            boolean star = false;
            while (cur.next != null && cur.next.val == num) {
                cur = cur.next;
                star = true;
            }
            if (star) {
                prev.next = cur.next;
            } else {
                prev.next = cur;
                prev = cur;
                cur = cur.next;
            }
        }
        return Head.next;
    }

    // 392. 判断子序列
    public boolean isSubsequence0(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        int sLen = s.length();
        int tLen = t.length();
        boolean[][] dp = new boolean[tLen + 1][sLen + 1];
        for (int i = 0; i <= sLen; i++) {
            dp[0][i] = true;
        }
        for (int i = 1; i <= tLen; i++) {
            for (int j = 1; j <= sLen; j++) {
                if (s.charAt(j - 1) == t.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[tLen][sLen];
    }

    public boolean isSubsequence(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        int sLen = s.length();
        int tLen = t.length();
        int p1 = 0;
        int p2 = 0;
        while (p1 < sLen &&p2 < tLen) {
            if (s.charAt(p1) == t.charAt(p2)) {
                p1++;
            }
            p2++;
        }
        return p1 == sLen;
    }

    // 把数组排成最小的数
    public String PrintMinNumber(int [] numbers) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            list.add(numbers[i]);
        }
        Collections.sort(list, new Comparator<Integer>(){
            @Override
            public int compare(Integer x, Integer y) {
                String a = x + "" + y;
                String b = y + "" + x;
                return a.compareTo(b);
            }
        });
        String ret = new String();
        for(Integer x : list) {
            ret = ret + "" + x;
        }
        return ret;
    }

    // 108. 将有序数组转换为二叉搜索树
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int start, int end) {
        if (start < end) {
            return null;
        }
        int mid = (end - start) / 2 + start;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, start, mid - 1);
        root.right = helper(nums, mid + 1, end);
        return root;
    }

    // 有序链表转搜索二叉树
    ListNode root;
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        root = head;
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return helper(0, size - 1);
    }

    private TreeNode helper(int left, int right) {
        if (left > right) {
            return null;
        }
        int mid  = (right - left) / 2 + left;
        TreeNode leftChild = helper(left, mid - 1);
        TreeNode Root = new TreeNode(root.val);
        Root.left = leftChild;
        root = root.next;
        Root.right = helper(mid + 1, right);
        return Root;
    }

    // 343. 整数拆分
    public int integerBreak(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = i - 1; j >= 1; j--) {
                dp[i] = Math.max(dp[i], Math.max(j, dp[j]) * Math.max(i - j, dp[i - j]));
            }
        }
        return dp[n];
    }

    //面试题 08.03. 魔术索引
    public int findMagicIndex(int[] nums) {
        return help(nums, 0, nums.length - 1);
    }

    private int help(int[] nums, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = (right - left) / 2 + left;
        int leftRet = help(nums, left, mid - 1);
        if (leftRet != -1) {
            return leftRet;
        }
        if (nums[mid] == mid) {
            return mid;
        }
        return help(nums, mid + 1, right);
    }

    // 415. 字符串相加
    public String addStrings0(String num1, String num2) {
        if (num1 == null || num1.equals("")) {
            return num2;
        }
        if (num2 == null || num2.equals("")) {
            return num1;
        }
        StringBuilder stringBuilder = new StringBuilder();
        boolean star = false;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        while (i >= 0 && j >= 0) {
            char ch1 = num1.charAt(i);
            char ch2 = num2.charAt(j);
            int num = ch1 + ch2 - '0' - '0';
            if (star) {
                num++;
            }
            if (num >= 10) {
                num = num % 10;
                star = true;
            } else {
                star = false;
            }
            stringBuilder.append(num);
            i--;
            j--;
        }
        stringBuilder.reverse();
        if (star) {
            if (i >= 0)
                return addStrings0("1", num1.substring(0, i + 1)) + stringBuilder.toString();
            else
                return addStrings0("1", num2.substring(0, j + 1)) + stringBuilder.toString();
        } else if (i >= 0) {
            return num1.substring(0, i + 1) + stringBuilder.toString();
        } else
            return num2.substring(0, j + 1) + stringBuilder.toString();
    }

    public String addStrings(String num1, String num2) {
        int cur = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0 || cur > 0) {
            int x = i >= 0 ? num1.charAt(i--) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j--) - '0' : 0;
            x = x + y + cur;
            cur = x / 10;
            x = x % 10;
            sb.append(x);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String[] strings = {"looked","just","like","her","brother"};
        DailyQuestion dailyQuestion = new DailyQuestion();
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list0 = new ArrayList<>();
        list0.add(2);
        List<Integer> list1 = new ArrayList<>();
        list1.add(3);
        list1.add(4);
        List<Integer> list2 = new ArrayList<>();
        list2.add(6);
        list2.add(5);
        list2.add(7);
        List<Integer> list3 = new ArrayList<>();
        list3.add(4);
        list3.add(1);
        list3.add(8);
        list3.add(3);
        lists.add(list0);
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        dailyQuestion.minimumTotal(lists);
//        int[] nums = {1,2,2,1};
//        int[] nums1 = {2,2};
//        dailyQuestion.intersect(nums1, nums);
//        dailyQuestion.countSmaller(nums);
//        dailyQuestion.respace(strings, "jesslookedjustliketimherbrother");
    }
}