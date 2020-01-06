package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int ret = 0;
        if (s == null) {
            return 0;
        }
        if (s.length() <= 1) {
            return s.length();
        }
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) >= start) {
                int num = i - start;
                if (num > ret) {
                    ret = num;
                }
                start = map.get(s.charAt(i)) + 1;
            }
            map.put(s.charAt(i), i);
        }
        int len = s.length() - start;
        if (ret < len) {
            ret = len;
        }
        return ret;
    }

    public class Solution {
        public int lengthOfLongestSubstring(String s) {
            int n = s.length(), ans = 0;
            Map<Character, Integer> map = new HashMap<>(); // current index of character
            // try to extend the range [i, j]
            for (int j = 0, i = 0; j < n; j++) {
                if (map.containsKey(s.charAt(j))) {
                    i = Math.max(map.get(s.charAt(j)), i);
                }
                ans = Math.max(ans, j - i + 1);
                map.put(s.charAt(j), j + 1);
            }
            return ans;
        }
    }
}
