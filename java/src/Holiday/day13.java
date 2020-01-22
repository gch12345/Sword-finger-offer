package Holiday;

import java.util.LinkedList;
import java.util.List;

public class day13 {
    List<List<Integer>> lists = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> list = new LinkedList<>();
        lists.add(list);
        helper(nums, 0, list);
        return lists;
    }

    private void helper(int[] nums, int start, List<Integer> list) {
        for (int i = start; i < nums.length; i++) {
            List<Integer> l = new LinkedList<>(list);
            l.add(nums[i]);
            lists.add(l);
            helper(nums, i + 1, l);
        }
    }

    private final int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int i = matrix.length;
        int j = matrix[0].length;
        int[][] cache = new int[i][j];
        int ret = 0;
        for (int m = 0; m < i; m++) {
            for (int n = 0; n < j; n++) {
                ret = Math.max(ret, helper(matrix, cache, m, n));
            }
        }
        return ret;
    }

    private int helper(int[][] matrix, int[][] cache, int i, int j) {
        if (cache[i][j] != 0) {
            return cache[i][j];
        }
        for (int[] d : dirs) {
            int m = d[0] + i;
            int n = d[1] + j;
            if (m >= 0 && m < matrix.length && n >= 0
                    && n < matrix[0].length && matrix[i][j] < matrix[m][n]) {
                cache[i][j] = Math.max(cache[i][j], helper(matrix, cache, m, n));
            }
        }
        return ++cache[i][j];
    }

    public int longestIncreasingPath0(int[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int ret = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                ret = Math.max(ret, Recurs(matrix, i, j));
            }
        }
        return ret;
    }

    private int Recurs(int[][] matrix, int i, int j) {
        int ret = 0;
        for (int[] d : dirs) {
            int x = i + d[0];
            int y = j + d[1];
            if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && matrix[i][j] < matrix[x][y]) {
                ret = Math.max(ret, Recurs(matrix, i, j));
            }
        }
        return ++ret;
    }
}