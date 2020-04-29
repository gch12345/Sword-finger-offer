package nowCoder;

import java.util.List;

public class dp {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; ++i) {
            if (obstacleGrid[i][0] == 0) {
                dp[i][0] = 1;
            } else {
                break;
            }
        }
        for (int i = 0; i < col; ++i) {
            if(obstacleGrid[0][i] == 0) {
                dp[0][i] = 1;
            } else {
                break;
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i][j - 1] + dp[i -1][j];
                }
            }
        }
        return dp[row - 1][col - 1];
    }

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < row; ++i) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < col; ++i) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[row - 1][col - 1];
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return false;
        }
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j + 1, i + 1))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }

    public int backPackII(int m, int[] A, int[] V) {
        // write your code here
        if (m == 0) {
            return 0;
        }
        if (A == null || A.length == 0) {
            return 0;
        }
        if (V == null || V.length == 0) {
            return 0;
        }
        int len = A.length;
        int[][] dp = new int[len + 1][m + 1];
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= m; j++) {
                if (A[i] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - A[i - 1] + V[i - 1]]);
                }
            }
        }
        return dp[len][m];
    }
}
