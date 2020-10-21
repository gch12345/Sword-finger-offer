package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class practice {
    // 最长不重复子串
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int max = 0;
        int curLen = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!map.containsKey(ch) || i - curLen > map.get(ch)) {
                curLen++;
            } else {
                curLen = i - map.get(ch);
            }
            map.put(ch, i);
            if (curLen > max) {
                max = curLen;
            }
        }
        return max;
    }
}
