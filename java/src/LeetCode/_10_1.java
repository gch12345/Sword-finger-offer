package LeetCode;

public class _10_1 {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int ret = helper(grid, i, j);
                    if (ret > max) {
                        max = ret;
                    }
                }
            }
        }
        return max;
    }
    int max = 0;
    int[][] p = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    public int helper(int[][] grid, int i, int j) {
        int count = 0;
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0 || grid[i][j] == -1) {
            return 0;
        }
        grid[i][j] = -1;
        for (int k = 0; k < 4; k++) {
            if (i + p[k][0] >= 0 && i + p[k][0] < grid.length && j + p[k][1] >= 0 && j + p[k][1] < grid[0].length &&  grid[i + p[k][0]][j + p[k][1]] == 1) {
                count++;
                 count += helper(grid, i + p[k][0], j + p[k][1]);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        _10_1 sol = new _10_1();
        int[][] arr = {{1},{1}};
        sol.maxAreaOfIsland(arr);
    }
}
