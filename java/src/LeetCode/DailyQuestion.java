package LeetCode;

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
    public boolean isBalanced(TreeNode root) {
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