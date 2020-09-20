package duxiaman;

import java.util.Scanner;

public class Main0 {
    static int[][] p = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            min = Integer.MAX_VALUE;
            int n = sc.nextInt();
            int k = sc.nextInt();
            char[][] arr = new char[n][n];
            for (int i = 0; i < n; i++) {
                String s = sc.next();
                for (int j = 0; j < n; j++) {
                    arr[i][j] = s.charAt(j);
                }
            }
            helper(arr, 0, k, 0, 0, new int[n][n]);
            System.out.println(min);
        }
    }
    static int min = Integer.MAX_VALUE;
    private static void helper(char[][] arr, int sum, int k, int i, int j, int[][] map) {
        if (i < 0 || j < 0 || i >= arr.length || j >= arr.length) {
            return;
        }
        if (map[i][j] == 1) {
            return;
        }
        if (arr[i][j] == '1') {
            return;
        }
        if (i == arr.length - 1 && j == arr.length - 1) {
            if (arr[i][j] == '#') {
                sum += k;
            }
            if (sum < min) {
                min = sum;
            }
            return;
        }
        map[i][j] = 1;
        for (int n = 0; n < 4; n++) {
            if (arr[i][j] == '#') {
                helper(arr, sum + k, k, i + p[n][0], j + p[n][1], map);
            } else {
                helper(arr, sum + 1, k, i + p[n][0], j + p[n][1], map);
            }
        }
        map[i][j] = 0;
    }
}
