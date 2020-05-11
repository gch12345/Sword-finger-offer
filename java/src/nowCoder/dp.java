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

    // 回文子串分割
    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        int[] dp = new int[len + 1];
        boolean[][] Mat = isPar(s);
        for (int i = 0; i <= len; i++) {
            dp[i] = i - 1;
        }
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if (Mat[j][i - 1])
                dp[i] = Math.min(dp[i], 1 + dp[j]);
            }
        }
        return dp[len];
    }

    private boolean[][] isPar(String s) {
        int len = s.length();
        boolean[][] ret = new boolean[len][len];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (i == j) {
                    ret[i][j] = true;
                } else if (j == i + 1) {
                    ret[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    ret[i][j] = (s.charAt(i) == s.charAt(j)) && ret[i + 1][j - 1];
                }
            }
        }
        return ret;
    }

    private boolean isPar(String s, int j, int i) {
        while (j < i) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            j++;
            i--;
        }
        return true;
    }

    // 编辑距离
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return -1;
        }
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= len2; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                // 替换
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    // 删除
                    dp[i][j] = 1 + dp[i - 1][j];
                    // 插入
                    dp[i][j] = Math.min(dp[i][j], 1 + dp[i][j - 1]);
                    dp[i][j] = Math.min(dp[i][j], 1 + dp[i -1][j - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[len1][len2];
    }

    public int numDistinct(String S, String T) {
        if (S == null || T == null) {
            return 0;
        }
        int row = S.length();
        int col = T.length();
        int[][] dp = new int[row + 1][col + 1];
        for (int i = 0; i <= row; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= i; j++) {
                if (S.charAt(i - 1) == T.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else  {
                    dp[i][j] = dp[i -1][j];
                }
            }
        }
        return dp[row][col];
    }
}
