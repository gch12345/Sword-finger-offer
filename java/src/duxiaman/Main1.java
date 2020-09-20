package duxiaman;

import org.junit.Test;

import java.util.Scanner;

public class Main1 {
    static int[][] p = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            char[][] arr = new char[n][n];
            for (int i = 0; i < n; i++) {
                String s = sc.next();
                for (int j = 0; j < n; j++) {
                    arr[i][j] = s.charAt(j);
                }
            }
            int ret = helper(arr, k);
            if (ret == Integer.MAX_VALUE) {
                System.out.println("\"No solution\"");
            } else {
                System.out.println(ret);
            }
        }
    }

    private static int helper(char[][] arr, int k) {
        int[][] dp = new int[arr.length + 1][arr.length + 1];
        for (int i = 0; i <= arr.length; i++) {
            dp[0][i] = Integer.MAX_VALUE;
            dp[i][0] = Integer.MAX_VALUE;
        }
        for (int i = 1; i <= arr.length; i++) {
            for (int j = 1; j <= arr.length; j++) {
                if (i == 1 && j == 1) {
                    dp[i][j] = 0;
                    continue;
                }
                if (dp[i - 1][j] == Integer.MAX_VALUE && dp[i][j - 1] == Integer.MAX_VALUE) {
                    dp[i][j] = Integer.MAX_VALUE;
                    continue;
                }
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]);
                if (arr[i - 1][j - 1] == '#') {
                    dp[i][j] += k;
                } else if (arr[i - 1][j - 1] == '0') {
                    dp[i][j]++;
                } else {
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }
        }
//        if (arr[arr.length - 1][arr.length - 1] == '#') {
//            dp[arr.length][arr.length] += 4;
//        }
        return dp[arr.length][arr.length];
    }
}
