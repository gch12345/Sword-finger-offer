package dajiang;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            int day = sc.nextInt();
            int[] game = new int[num];
            int[] need = new int[num];
            for (int i = 0; i < num; i++) {
                game[i] = sc.nextInt();
                need[i] = sc.nextInt();
            }
            int[][] dp = new int[day + 1][num + 1];
            for (int i = 1; i <= day; i++) {
                for (int j = 1; j <= num; j++) {
                    if (need[j - 1] <= i) {
                        dp[i][j] = Math.max(dp[i][j - 1], dp[i - need[j - 1]][j] + game[j - 1]);
                    } else {
                        dp[i][j] = dp[i][j - 1];
                    }
                }
            }
            System.out.println(dp[day][num]);
        }
    }
}
