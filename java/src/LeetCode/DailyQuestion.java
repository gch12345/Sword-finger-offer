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
        int mid = (right -left) / 2 + left;
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

    public static void main(String[] args) {
        String[] strings = {"looked","just","like","her","brother"};
        DailyQuestion dailyQuestion = new DailyQuestion();
        int[] nums = {4,2,6,1};
        dailyQuestion.countSmaller(nums);
//        dailyQuestion.respace(strings, "jesslookedjustliketimherbrother");
    }
}