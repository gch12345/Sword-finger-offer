package LeetCode;

import operatingSystem.MemoryAllocation.BF;

import java.util.*;

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

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord)) {
            return 0;
        }
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int size = beginWord.toCharArray().length;
        int ret = 0;
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int k = 0; k < queueSize; k++) {
                String str = queue.poll();
                char[] cur = str.toCharArray();
                for (int i = 0; i < size; i++) {
                    char ch = cur[i];
                    for (int j = 0; j < 26; j++) {
                        cur[i] = (char) ('a' + j);
                        String curStr = new String(cur);
                        if (curStr.equals(endWord)) {
                            return ++ret;
                        }
                        if (set.contains(curStr)) {
                            set.remove(curStr);
                            queue.add(curStr);
                        }
                    }
                    cur[i] = ch;
                }
            }
            ret++;
        }
        return 0;
    }

    public int openLock(Set<String> set, String target) {
        //Set<String> set = new HashSet<>();
        //Collections.addAll(set, deadends);
        if (set.contains(target)) {
            return -1;
        }
        Queue<String> queue = new LinkedList<>();
        queue.add("0000");
        int ret = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String str = queue.poll();
                char[] chars = str.toCharArray();
                for (int j = 0; j < 4; j++) {
                    char ch = chars[j];
                    chars[j] = (char)((ch - '0' + 1) % 10 + '0');
                    String cur = new String(chars);
                    if (cur.equals(target)) {
                        return ++ret;
                    }
                    if (!set.contains(cur)) {
                        queue.add(cur);
                        set.add(cur);
                    }
                    chars[j] = (char)((ch - '0' - 1 + 10) % 10 + '0');
                    cur = new String(chars);
                    if (cur.equals(target)) {
                        return ++ret;
                    }
                    if (!set.contains(cur)) {
                        queue.add(cur);
                        set.add(cur);
                    }
                    chars[j] = ch;
                }
            }
            ret++;
        }
        return -1;
    }

    public int minMutation(String start, String end, String[] bank) {
        if (start == null || end == null || bank == null) {
            return -1;
        }
        if (start.equals(end)) {
            return 0;
        }
        Set<String> set = new HashSet<>();
        Collections.addAll(set, bank);
        if (!set.contains(end)) {
            return -1;
        }
        int size = start.length();
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        char[] next = {'A', 'T', 'C', 'G'};
        int ret = 0;
        while (!queue.isEmpty()) {
            int curLen = queue.size();
            for (int i = 0; i < curLen; i++) {
                String cur = queue.poll();
                char[] chars = cur.toCharArray();
                for (int j = 0; j < size; j++) {
                    char ch = chars[j];
                    for (int k = 0; k < 4; k++) {
                        if (ch == next[k]) {
                            continue;
                        }
                        chars[j] = next[k];
                        String curStr = new String(chars);
                        if (curStr.equals(end)) {
                            return ++ret;
                        }
                        if (set.contains(curStr)) {
                            queue.add(curStr);
                            set.remove(curStr);
                        }
                    }
                    chars[j] = ch;
                }
            }
            ret++;
        }
        return -1;
    }

    public static void main(String[] args) {
        BFS bfs = new BFS();
        Set<String> set = new HashSet<>();
        //["8887","8889","8878","8898","8788","8988","7888","9888"]
        set.add("8887");
        set.add("8878");
        set.add("8898");
        set.add("8788");
        set.add("8889");
        set.add("8988");
        set.add("7888");
        set.add("9888");
        System.out.println(bfs.openLock(set, "8888"));
    }
}
