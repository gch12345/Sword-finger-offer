package Holiday;

public class day10 {
//    请你来实现一个 atoi 函数，使其能将字符串转换成整数。
    public int myAtoi(String str) {
        if ("".equals(str)) {
            return 0;
        }
        int start = 0;
        boolean b = true;
        while (start < str.length()) {
            char ch = str.charAt(start);
            if (ch == ' ') {
                start++;
            } else if (ch == '-') {
                b = false;
                start++;
                break;
            } else if (ch == '+') {
                start++;
                break;
            }
            else if (ch < '0' || ch > '9') {
                return 0;
            } else {
                break;
            }
        }
        if (start >= str.length()) {
            return 0;
        }
        char ch = str.charAt(start);
        if (ch < '0' || ch > '9') {
            return 0;
        }
        long num = 0;
        while (start < str.length()) {
            char c = str.charAt(start);
            if (c >= '0' && c <= '9') {
                num = num * 10 + c - '0';
                if (num > Integer.MAX_VALUE) {
                    break;
                }
            } else {
                break;
            }
            start++;
        }
        if (!b) {
            num = -num;
        }
        if (num > Integer.MAX_VALUE) {
            num =Integer.MAX_VALUE;
        }
        if (num < Integer.MIN_VALUE) {
            num = Integer.MIN_VALUE;
        }
        return (int)num;
    }

//    给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
//    你的算法时间复杂度必须是 O(log n) 级别。
//    如果数组中不存在目标值，返回 [-1, -1]。

    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = -1;
        while (left < right) {
            mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                break;
            }
        }
        int[] ret = new int[2];
        if (nums[mid] != target) {
            ret[0] = -1;
            ret[1] = -1;
            return ret;
        }
        while (nums[left] != target) {
            left++;
        }
        while (nums[right] != target) {
            right--;
        }
        ret[0] = left;
        ret[1] = right;
        return ret;
    }

    public static void main(String[] args) {
        day10 obj = new day10();
        obj.myAtoi("   -42");
    }
}
