package yongyou;

import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static String compress (String str) {
        // write code here
        if (str == null || str.length() < 1) {
            return str;
        }
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (i < str.length()) {
            int count = 1;
            char ch = str.charAt(i);
            while (i < str.length() - 1) {
                if (str.charAt(i) == str.charAt(i + 1)) {
                    count++;
                    i++;
                } else {
                    break;
                }
            }
            stringBuilder.append(ch);
            stringBuilder.append(count);
            i++;
        }
        if (stringBuilder.length() > str.length()) {
            return str;
        }
        return stringBuilder.toString();
    }

    public int[][] convert (int[][] matrix) {
        // write code here
        if (matrix == null || matrix.length <= 1) {
            return matrix;
        }
        int len = matrix.length;
        for (int i = 0; i < len / 2; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[len - 1 - i][j];
                matrix[len - 1 - i][j] = temp;
            }
        }
        return matrix;
    }

    public static int[] findAllCheapestPrice (int n, int[][] flights, int src) {
        // write code here
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] =Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < flights.length; i++) {
            dp[flights[i][0]][flights[i][1]] = flights[i][2];
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (dp[j][i] == Integer.MAX_VALUE || dp[i][k] == Integer.MAX_VALUE) {
                        continue;
                    }
                    if (dp[j][k] > dp[j][i] + dp[i][k]) {
                        dp[j][k] = dp[j][i] + dp[i][k];
                    }
                }
            }
        }
        int[] ret = new int[n];
        for (int i = 0; i < n; i++) {
            if (dp[src][i] == Integer.MAX_VALUE) {
                ret[i] = -1;
            } else {
                ret[i] = dp[src][i];
            }
        }
        ret[src] = 0;
        return ret;
    }

    public static void main(String[] args) {
        int[][] arr = { {0, 1, 10},
                        {0, 3, 40},
                        {1, 2, 20},
                        {1, 3, 100},
                        {1, 4, 30},
                        {2, 3, 50},
                        {3, 4, 60}};
        int[] ret = findAllCheapestPrice(5, arr, 1);
        System.out.println(Arrays.toString(ret));
    }
}
