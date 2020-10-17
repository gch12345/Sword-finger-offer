package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class dp1 {
    public static boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length <= 1) {
            return false;
        }
        int len = nums.length;
        int[] arr = new int[len];
        for (int i = 0; i < len - 1; i++) {
            arr[i] = nums[i];
            for (int j = i + 1; j < len; j++) {
                arr[j] = arr[j - 1] + nums[j];
                if (arr[j] == k || (k != 0 && arr[j] % k == 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean checkSubarraySum0(int[] nums, int k) {
        int sum = 0;
        HashMap< Integer, Integer > map = new HashMap< >();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0)
                sum = sum % k;
            if (map.containsKey(sum)) {
                if (i - map.get(sum) > 1)
                    return true;
            } else
                map.put(sum, i);
        }
        return false;
    }

    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if (triangle == null) {
            return Integer.MIN_VALUE;
        }
        int size = triangle.size();
        int[][] dp = new int[size][size];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < size; i++) {
            for (int j = 0; j <= i; j++) {
                int cur = triangle.get(i).get(j);
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + cur;
                } else if (j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + cur;
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + cur;
                }
            }
        }
        int retNum = dp[size - 1][0];
        for (int i = 1; i < size; i++) {
            if (dp[size - 1][i] < retNum) {
                retNum = dp[size - 1][i];
            }
        }
        return retNum;
    }
    private boolean[][] isPar(String s) {
        if (s == null) {
            return null;
        }
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = i; j >= 0; j--) {
                if (i == j) {
                    dp[j][i] = true;
                } else if (i == j + 1) {
                    dp[j][i] = (s.charAt(i) == s.charAt(j));
                } else {
                    dp[j][i] = dp[j + 1][i - 1] && (s.charAt(i) == s.charAt(j));
                }
            }
        }
        return dp;
    }

    private boolean isPar0(String substring) {
        if (substring.length() == 0) {
            return true;
        }
        int start = 0;
        int end = substring.length() - 1;
        char[] ch = substring.toCharArray();
        while (start < end) {
            if (ch[start] != ch[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) {
            return Integer.MIN_VALUE;
        }
        int retMax = array[0];
        int curSum = array[0];
        for (int i = 1; i < array.length; i++) {
            curSum = Math.max(curSum + array[i], array[i]);
            if (curSum > retMax) {
                retMax = curSum;
            }
        }
        return retMax;
    }

    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || dict == null) {
            return false;
        }
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }
}
