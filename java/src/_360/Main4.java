package _360;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int person = sc.nextInt();
            int num = sc.nextInt();
            int[][] arr = new int[person][num];
            for (int i = 0; i < person; i++) {
                for (int j = 0; j < num; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            System.out.println(help(arr, num, person));
        }
    }

    private static int help (int[][] arr, int num, int person) {
        int[][] dp = new int[num + 1][person + 1];
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= person; j++) {
                dp[i][j] = dp[i][j - 1];
                for (int k = 1; k <= i; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - k][j - 1] + arr[j - 1][k - 1]);
                }
            }
        }
        return dp[num][person];
    }
}
