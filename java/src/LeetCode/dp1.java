package LeetCode;

import java.util.HashMap;

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
}
