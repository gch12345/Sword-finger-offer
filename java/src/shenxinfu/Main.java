package shenxinfu;

import Practice.A;

import java.util.Arrays;

public class Main {
    public int getSqrt (int num) {
        // write code here
        if (num <= 1) {
            return num;
        }
        int left = 1;
        int right = num;
        int mid = (right - left) / 2 + left;
        while (left < right) {
            if (mid * mid == num) {
                break;
            }
            if (mid * mid > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            mid = (right - left) / 2 + left;
        }
        if (mid * mid > num) {
            mid--;
        }
        return mid;
    }

    public int minDistance (String a, String b) {
        // write code here
        if (a == null || a.length() == 0) {
            return b.length();
        }
        if (b == null || b.length() == 0) {
            return a.length();
        }
        int[][] dp = new int[a.length() + 1][b.length() + 1];
        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                char ch1 = a.charAt(i - 1);
                char ch2 = b.charAt(j - 1);
                // 相等和替换
                if (ch1 == ch2) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                // 删除
                if (i - 2 >= 0 && a.charAt(i - 2) == ch2) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 2][j] + 1);
                }
                // 插入
                if (j != b.length() && b.charAt(j) == ch1) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
                }
            }
        }
        return dp[a.length()][b.length()];
    }

    public int maxCoins0 (int[] piles) {
        // write code here
        Arrays.sort(piles);
        int ret = 0;
        for (int i = 0; i < piles.length; i += 3) {
            ret += piles[i + 1];
        }
        return ret;
    }

    public int maxCoins (int[] piles) {
        Arrays.sort(piles);
        int i = 0;
        int j = piles.length - 1;
        int ret = 0;
        while (i < j) {
            i++;
            j--;
            ret += piles[j];
            j--;
        }
        return ret;
    }

    public static void main(String[] args) {
        Main main = new Main();
//        System.out.println(main.getSqrt(5));
        System.out.println(main.minDistance("ho", "hor"));
//        int[] arr = {2,4,1,2,7,8};
//        System.out.println(main.maxCoins(arr));
    }
}
