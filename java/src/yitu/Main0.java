package yitu;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class node{
    int x;
    int y;
    int num;
    public node(int x, int y, int num) {
        this.x = x;
        this.num = num;
        this.y = y;
    }
}

public class Main0 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            for (int i = 1; i <= num; i++) {
                int n = sc.nextInt();
                int m = sc.nextInt();
                int x = sc.nextInt();
                int y = sc.nextInt();
                int a = sc.nextInt();
                int b = sc.nextInt();
                int c = sc.nextInt();
                int d = sc.nextInt();
                char[][] chars = new char[n][m];
                for (int j = 0; j < n; j++) {
                    char[] ch = sc.next().toCharArray();
                    chars[j] = ch;
                }
                int[] arr = {a, b, c, d};
//                Case #1: 560
//                Case #2: -1
//                helper(chars, x, y, arr, 0, 0, 0);
                int min = help(chars, x, y, arr);
                if (min == Integer.MAX_VALUE) {
                    System.out.println("Case #" + i + ": " + -1);
                } else {
                    System.out.println("Case #" + i + ": " + min);
                }
            }
        }
    }
    public static int help(char[][] chars, int x, int y, int[] arr) {
        Queue<node> queue = new LinkedList<>();
        int[][] dp = new int[chars.length][chars[0].length];
        queue.add(new node(0, 0, 0));
        int min = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                node node = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int curX = node.x + p[j][0];
                    int curY = node.y + p[j][1];
                    if (curX >= 0 && curX < chars.length && curY >= 0 && curY < chars[0].length && chars[curX][curY] != 'x') {
                        if (chars[curX][curY] == '-' && dp[curX][curY] <= node.num + arr[j]) {
                            continue;
                        }
                        queue.add(new node(curX, curY, node.num + arr[j]));
                        dp[curX][curY] = node.num + arr[j];
                        chars[curX][curY] = '-';
                        if (curX == x && curY == y && min > dp[curX][curY]) {
                            min = dp[curX][curY];
                        }
                    }
                }
            }
        }
        return min;
    }

    static int min = Integer.MAX_VALUE;
    static int[][] p = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void helper(char[][] chars, int x, int y, int[] arr,  int curX, int curY, int curNum) {
        if (curX == x && curY == y) {
            if (min > curNum) {
                min = curNum;
            }
            return;
        }
        for (int i = 0; i < 4; i++) {
            int X = curX + p[i][0];
            int Y = curY + p[i][1];
            if (X >= 0 && X < chars.length && Y >= 0 && Y < chars[0].length && chars[X][Y] == 'o') {
                chars[X][Y] = '-';
                helper(chars, x, y, arr, X, Y, curNum + arr[i]);
                chars[X][Y] = 'o';
            }
        }
    }
}
