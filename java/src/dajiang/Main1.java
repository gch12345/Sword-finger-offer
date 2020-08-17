package dajiang;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            int nums = sc.nextInt();
            int[][] point = new int[num][num];
            for (int i = 0; i < nums; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                int p = sc.nextInt();
                point[x][y] = p;
            }
            for (int i = 0; i < num; i++) {
                System.out.println(Arrays.toString(point[i]));
            }
            int last = sc.nextInt();
            int[][] ret = help(point, num);
            System.out.println(ret[0][last]);
            for (int i = 0; i < num; i++) {
                System.out.println(Arrays.toString(ret[i]));
            }
        }
    }

    public static int[][] help(int[][] point, int num) {
        int[][] dp = new int[num][num];
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if (point[i][j] == 0) {
                    dp[i][j] = -1;
                } else {
                    dp[i][j] = point[i][j];
                }
                if (i == j) {
                    dp[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                for (int k = 0; k < num; k++) {
                    if (dp[j][i] == -1 || dp[i][k] == -1) {
                        continue;
                    } else if (dp[j][k] > dp[j][i] + dp[i][k]) {
                        dp[j][k] = dp[j][i] + dp[i][k];
                    }
                }
            }
        }
        return dp;
    }
}
