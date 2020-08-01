package QiAnXin;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()) {
//            int T = sc.nextInt();
//            int num = sc.nextInt();
//            int[] P = new int[num];
//            int[] W = new int[num];
//            for (int i = 0; i < num; i++) {
//                P[i] = sc.nextInt();
//                W[i] = sc.nextInt();
//            }
//            int[][] dp = new int[T + 1][num + 1];
//            for (int i = 1; i <= T; i++) {
//                for (int j = 1; j <= num; j++) {
//                    if (P[j - 1] > i) {
//                        dp[i][j] = dp[i][j - 1];
//                    } else {
//                        dp[i][j] = Math.max(dp[i][j - 1], dp[i - P[j - 1]][j] + W[j - 1]);
//                    }
//                }
//            }
//            System.out.println(dp[T][num]);
//        }
        Main main = new Main();
        int[] arr = {1,1,2};
        System.out.println(main.reletive_7(arr));
    }

    int count = 0;
    public int reletive_7 (int[] digit) {
        // write code here
        char[] arr = new char[digit.length];
        for (int i = 0; i < digit.length; i++) {
            arr[i] = (char)(digit[i] + '0');
        }
        helper(arr, 0);
        return count;
    }

    private void swap(char[] digit, int x, int y) {
        char temp = digit[x];
        digit[x] = digit[y];
        digit[y] = temp;
    }

    private void helper(char[] digit, int index) {
        if (index == digit.length) {
            String s = new String(digit);
            System.out.println(s);
            if (Long.parseLong(s) % 7 == 0) {
                count++;
            }
        }
        for (int i = index; i < digit.length; i++) {
            swap(digit, index, i);
            helper(digit, index + 1);
            swap(digit, index, i);
        }
    }
}
