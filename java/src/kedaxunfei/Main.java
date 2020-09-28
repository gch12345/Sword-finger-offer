package kedaxunfei;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] s = sc.next().split(",");
            int row = Integer.parseInt(s[0]);
            int col = Integer.parseInt(s[1]);
            int[][] arr = new int[row][col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            int[][] dp = new int[row + 1][col + 1];
            for (int i = 1; i <= row; i++) {
                for (int j = 1; j <= col; j++) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + arr[i - 1][j - 1];
                }
            }
            System.out.println(dp[row][col]);
        }
    }
}
