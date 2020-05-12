package LeetCode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};

public class DFS {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            map.put(employee.id, employee);
        }
        return getImportanceDFS(id, map);
    }
    private int getImportanceDFS(int id, Map<Integer, Employee> map) {
        Employee employee = map.get(id);
        int ret = employee.importance;
        List<Integer> list = employee.subordinates;
        for (int i = 0; i < list.size(); i++) {
            ret = ret + getImportanceDFS(list.get(i), map);
        }
        return ret;
    }

    private int[][] nextP = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int row;
    private int col;
    private int start;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null) {
            return image;
        }
        row = image.length;
        col = image[0].length;
        start = image[sr][sc];
        floodFillDFS(image, sr, sc, newColor);
        return image;
    }
    private void floodFillDFS(int[][] image, int sr, int sc, int newColor) {
        if (sr >= row || sc >= col || sr < 0 || sc < 0) {
            return;
        }
        if (image[sr][sc] == newColor) {
            return;
        }
        if (image[sr][sc] != start) {
            return;
        }
        image[sr][sc] = newColor;
        for (int i = 0; i < 4; i++) {
            floodFillDFS(image, sr + nextP[i][0], sc + nextP[i][1], newColor);
        }
    }

    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        row = grid.length;
        col = grid[0].length;
        int sr = -1;
        int sc = -1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    sr = i;
                    sc = j;
                    break;
                }
            }
        }
        return islandPerimeterDFS(grid, sr, sc);
    }

    private int islandPerimeterDFS(int[][] grid, int sr, int sc) {
        if (sr >= row || sc >= col || sr < 0 || sc < 0) {
            return 1;
        }
        if (grid[sr][sc] == 0) {
            return 1;
        }
        if (grid[sr][sc] == -1) {
            return 0;
        }
        grid[sr][sc] = -1;
        int ret = 0;
        for (int i = 0; i < 4; i++) {
            ret += islandPerimeterDFS(grid, sr + nextP[i][0], sc + nextP[i][1]);
        }
        return ret;
    }

    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        row = board.length;
        col = board[0].length;
        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'o')
                solveDFS(board, i, 0);
            if (board[i][col - 1] == 'o')
                solveDFS(board, i, col - 1);
        }
        for (int i = 1; i < col; i++) {
            if (board[0][i] == 'o')
                solveDFS(board, 0, i);
            if (board[col - 1][i] == 'o')
                solveDFS(board, col - 1, i);
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == '*') {
                    board[i][j] = 'o';
                } else if (board[i][j] == 'o') {
                    board[i][j] = 'x';
                }
            }
        }
    }
    private void solveDFS(char[][] board, int sr, int sc) {
        if (sr >= row || sc >= col || sr < 0 || sc < 0) {
            return;
        }
        if (board[sr][sc] == '*' || board[sr][sc] == 'x') {
            return;
        }
        board[sr][sc] = '*';
        for (int i = 0; i < 4; i++) {
            solveDFS(board, sr + nextP[i][0], sc + nextP[i][1]);
        }
    }
}
