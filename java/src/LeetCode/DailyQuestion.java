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

    public static void main(String[] args) {
        String[] strings = {"looked","just","like","her","brother"};
        DailyQuestion dailyQuestion = new DailyQuestion();
        dailyQuestion.respace(strings, "jesslookedjustliketimherbrother");
    }
}