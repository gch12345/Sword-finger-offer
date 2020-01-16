package Holiday;

import java.util.HashMap;
import java.util.Map;
//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
//你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
public class day9 {
    public int[] twoSum(int[] nums, int  target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] ret = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            if (map.containsKey(num)) {
                ret[0] = i;
                ret[1] = map.get(num);
                return ret;
            }
            map.put(nums[i], i);
        }
        return null;
    }

//    给定两个二进制字符串，返回他们的和（用二进制表示）。
//    输入为非空字符串且只包含数字 1 和 0。
    public String addBinary(String a, String b) {
        StringBuffer ret = new StringBuffer();
        int ca = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = ca;
            if (i >= 0) {
                sum = sum + a.charAt(i) - '0';
            }
            if (j >= 0) {
                sum = sum + b.charAt(j) - '0';
            }
            ret.append(sum % 2);
            ca = sum / 2;
        }
        if (ca == 1) {
            ret.append(ca);
        }
        return ret.reverse().toString();
    }
    public String addBinary0(String a, String b) {
        char[] s1 = a.toCharArray();
        char[] s2 = b.toCharArray();
        int num1 = helper(s1);
        int num2 = helper(s2);
        int num = num1 + num2;
//        System.out.println(num);
        return help(num);
    }
    private int helper(char[] arr) {
        int ret = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == '1') {
                ret = ret + (int) Math.pow(2, arr.length - i - 1);
            }
        }
        System.out.println(ret);
        return ret;
    }
    private String help(int num) {
        String ret = new String("" + num % 2);
        num = num / 2;
        while (num != 0) {
            if (num % 2 == 0) {
                ret = "0" + ret;
            } else {
                ret = "1" + ret;
            }
            num = num / 2;
        }
        return ret;
    }

    public static void main(String[] args) {
        day9 d = new day9();
        String ret = d.addBinary("11", "1");
        System.out.println(ret);
    }
}
