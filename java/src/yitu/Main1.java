package yitu;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int k0 = sc.nextInt();
            int k2 = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int money = a * 17 * 29 + b * 29 + c;
            int[] arr = new int[n];
            int[] p = new int[n];
            for (int i = 0; i < n; i++) {
                p[i] = sc.nextInt() * 17 * 29 + sc.nextInt() * 29 + sc.nextInt();
                arr[i] = sc.nextInt();
            }
             int ret = help(p, arr, k0 - k2, money);
            if (ret == Integer.MAX_VALUE) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
                if (ret / (17 * 29) > 0) {
                    System.out.print(ret / (17 * 29) + " ");
                    ret = ret % (17 * 29);
                } else {
                    System.out.print(0 + " ");
                }
                if (ret / 29 > 0) {
                    System.out.print(ret / 29 + " ");
                    ret = ret % 29;
                } else {
                    System.out.print(0 + " ");
                }
                System.out.println(ret);
            }

        }
    }

    public static int help(int[] arr, int[] p, int n, int money) {
        int[][] dp = new int[money + 1][arr.length + 1];
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= money; i++) {
            for (int j = 1; j <= arr.length; j++) {
                dp[i][j] = dp[i][j - 1];
                if (i >= arr[j - 1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - arr[j - 1]][j - 1] + p[j - 1]);
                }
                if (dp[i][j] >= n && i < min) {
                    min = i;
                }
            }
        }
        return min;
    }
}
