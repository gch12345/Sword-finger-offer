package LeetCode;

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
}
