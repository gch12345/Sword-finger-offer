package wangyi._2020_08_5;

import java.util.Scanner;

public class Main {

    private static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int t = sc.nextInt();//组数
        for (int a = 0; a < t; a++) {
            int n = sc.nextInt();//广场长(宽)
            int m = sc.nextInt();//广场长(宽)
            int k = sc.nextInt();//障碍物个数
            int[][] grid = new int[n + 10][m + 10];
            for (int i = 0; i < k; i++) {//填入障碍物坐标
                grid[sc.nextInt()][sc.nextInt()] = 1;
            }
            for (int row = 1; row <= n; row++) {
                for (int col = 1; col <= m; col++) {
                    grid[row][col] += grid[row - 1][col] + grid[row][col - 1] - grid[row - 1][col - 1];
                }
            }
            int c = sc.nextInt();//货物长(宽)
            int d = sc.nextInt();//货物长(宽)
            boolean findPosition = false;
            for (int row = 1; row <= n - c + 1; row++) {
                for (int col = 1; col <= m - d + 1; col++) {
                    int ok = grid[row + c - 1][col + d - 1] - grid[row + c - 1][col - 1] - grid[row - 1][col + d - 1] + grid[row - 1][col - 1];
                    if (ok == 0) {
                        System.out.println("YES");
                        findPosition = true;
                        break;
                    }
                }
                if (findPosition) {
                    break;
                }
            }
            if (!findPosition) {
                System.out.println("NO");
            }
        }
    }
}
