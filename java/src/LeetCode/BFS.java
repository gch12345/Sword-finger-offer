package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

public class BFS {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while (size != 0) {
                Node node = queue.poll();
                list.add(node.val);
                for (Node child : node.children) {
                    if (child != null) {
                        queue.offer(child);
                    }
                }
                size--;
            }
            if (list.size() != 0)
                lists.add(list);
        }
        return lists;
    }

    private int[][] nextP = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public int orangesRotting(int[][] grid) {
        class Pair {
            int x;
            int y;
            public Pair(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }
        if (grid == null) {
            return -1;
        }
        Queue<Pair> queue = new LinkedList<>();
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Pair(i, j));
                }
            }
        }
        int ret = 0;
        while (!queue.isEmpty()) {
            int size =queue.size();
            for (int i = 0; i < size; i++) {
                Pair pair = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int newX = pair.x + nextP[j][0];
                    int newY = pair.y + nextP[j][1];
                    if (newX < 0 || newX >= row || newY < 0 || newY >= col || grid[newX][newY] == 2 || grid[newX][newY] == 0) {
                        continue;
                    }
                    grid[newX][newY] = 2;
                    queue.add(new Pair(newX, newY));
                }
            }
            ret++;
        }
        for (int[] ints : grid) {
            for (int j = 0; j < col; j++) {
                if (ints[j] == 1) {
                    return -1;
                }
            }
        }
        if (ret == 0) {
            return ret;
        }
        return ret - 1;
    }
}
