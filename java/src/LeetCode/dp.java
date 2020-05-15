package LeetCode;

import java.util.ArrayList;
import java.util.Set;

public class dp {
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) {
            return Integer.MIN_VALUE;
        }
        int retMax = array[0];
        int curSum = array[0];
        for (int i = 1; i < array.length; i++) {
            curSum = Math.max(curSum + array[i], array[i]);
            if (curSum > retMax) {
                retMax = curSum;
            }
        }
        return retMax;
    }

    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || dict == null) {
            return false;
        }
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }

    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if (triangle == null) {
            return Integer.MIN_VALUE;
        }
        int size = triangle.size();
        int[][] dp = new int[size][size];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < size; i++) {
            for (int j = 0; j <= i; j++) {
                int cur = triangle.get(i).get(j);
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + cur;
                } else if (j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + cur;
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + cur;
                }
            }
        }
        int retNum = dp[size - 1][0];
        for (int i = 1; i < size; i++) {
            if (dp[size - 1][i] < retNum) {
                retNum = dp[size - 1][i];
            }
        }
        return retNum;
    }

    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null) {
            return 0;
        }
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        if (col == 0) {
            return 0;
        }
        int[][] dp = new int[row][col];
        for (int i = 0; i < col; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            }
            dp[0][i] = 1;
        }
        for (int i = 0; i < row; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            dp[i][0] = 1;
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[row - 1][col - 1];
    }

    public int minPathSum(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        int sum = 0;
        for (int i = 0; i < col; i++) {
            sum += grid[0][i];
            dp[0][i] = sum;
        }
        sum = grid[0][0];
        for (int i = 1; i < row; i++) {
            sum += grid[i][0];
            dp[i][0] = sum;
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[row - 1][col - 1];
    }

    public int backPackII(int m, int[] A, int[] V) {
        if (m == 0 || A == null || V == null) {
            return 0;
        }
        if (A.length == 0 || V.length == 0) {
            return 0;
        }
        int len = A.length;
        int[][] dp = new int[m + 1][len + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= len; j++) {
                if (i < A[j - 1]) {
                    dp[i][j] = dp[i][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - A[j - 1]][j - 1] + V[j - 1]);
                }
            }
        }
        return dp[m][len];
    }

    public int minCut(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = -1;
        for (int i = 1; i <= len; i++) {
            dp[i] = i - 1;
        }
        boolean[][] star = new boolean[len][len];
        for (int i = 1; i <= len; i++) {//aa  2
            for (int j = 0; j < i; j++) {
                if (star[j][i - 1]) {//0 2
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[len];
    }

    private boolean[][] isPar(String s) {
        if (s == null) {
            return null;
        }
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = i; j >= 0; j--) {
                if (i == j) {
                    dp[j][i] = true;
                } else if (i == j + 1) {
                    dp[j][i] = (s.charAt(i) == s.charAt(j));
                } else {
                    dp[j][i] = dp[j + 1][i - 1] && (s.charAt(i) == s.charAt(j));
                }
            }
        }
        return dp;
    }

    private boolean isPar0(String substring) {
        if (substring.length() == 0) {
            return true;
        }
        int start = 0;
        int end = substring.length() - 1;
        char[] ch = substring.toCharArray();
        while (start < end) {
            if (ch[start] != ch[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return -1;
        }
        int len1 = word1.length();
        int len2 = word2.length();
        if (len1 == 0) {
            return len2;
        }
        if (len2 == 0) {
            return len1;
        }
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= len2; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                // 插入
                dp[i][j] = dp[i][j - 1] + 1;
                // 删除
                dp[i][j] = Math.min(dp[i -  1][j] + 1, dp[i][j]);
                // 替换
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                } else {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }
        return dp[len1][len2];
    }

    public int numDistinct(String S, String T) {
        if (S == null || T == null) {
            return -1;
        }
        int len1 = S.length();
        int len2 = T.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= Math.min(i, len2); j++) {
                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[len1][len2];
    }
}
