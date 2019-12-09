package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class Test {
    //最长连续序列
    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            set.add(x);
        }
        int ret = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int count = 1;
                while (set.contains(num + 1)) {
                    count++;
                    num++;
                }
                if (count > ret) {
                    ret = count;
                }
            }
        }
        return ret;
    }
}
