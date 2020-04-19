package nowCoder;

import org.junit.Test;

import java.util.Scanner;

public class intervalMaxSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            int[] array = new int[num];
            for (int i = 0; i < num; i++) {
                array[i] = sc.nextInt();
            }
            int max = Integer.MIN_VALUE;
            int curMax = 0;
            for (int i = 0; i < array.length; i++) {
                curMax += array[i];
                if (curMax > max) {
                    max = curMax;
                }
                if (curMax < 0) {
                    curMax = 0;
                }
            }
            System.out.println(max);
        }
    }

    @Test
    public void test() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            int[] array = new int[num];
            for (int i = 0; i < num; i++) {
                array[i] = sc.nextInt();
            }
            int[][] dp = new int[num][num];
            int max = Integer.MIN_VALUE;
            dp[0][0] = array[0];
            if (dp[0][0] < 0) {
                dp[0][0] = 0;
                max = dp[0][0];
            }
            for (int i = 1; i < num; i++){
                for (int j = i; j < num; j++) {
                    dp[i][j] = dp[i][j - 1] + array[j];
                    if (dp[i][j] > max) {
                        max = dp[i][j];
                    }
                    if (dp[i][j] < 0) {
                        dp[i][j] = 0;
                    }
                }
            }
            System.out.println(max);
        }
    }
}
