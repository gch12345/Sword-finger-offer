package LeetCode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Offer2 {
    // 58 - I. 翻转单词顺序
    public String reverseWords0(String s) {
        if (s == null || s.length() < 1) {
            return s;
        }
        s = s.trim();
        String[] strings = s.split(" ");
        StringBuffer stringBuffer = new StringBuffer();
        for (String string : strings) {
            if (string.equals(" ")) {
                continue;
            }
            int index = string.length() - 1;
            while (index >= 0) {
                stringBuffer.append(string.charAt(index));
                index--;
            }
            stringBuffer.append(" ");
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        return stringBuffer.reverse().toString();
    }

    public String reverseWords(String s) {
        if (s == null || s.length() < 1) {
            return s;
        }
        String[] strings = s.trim().split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = strings.length - 1; i > 0; i--) {
            if (strings[i].equals("")) {
                continue;
            }
            stringBuilder.append(strings[i] + " ");
        }
        stringBuilder.append(strings[0]);
        return stringBuilder.toString();
    }

    // 58 - II. 左旋转字符串
    public String reverseLeftWords(String s, int n) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = n; i < s.length() + n; i++ ) {
            stringBuilder.append(s.charAt(i % s.length()));
        }
        return stringBuilder.toString();
    }

    // 59 - I. 滑动窗口的最大值
    public int[] maxSlidingWindow0(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        Deque<Integer> deque = new LinkedList<>();
        int[] ret = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.pollLast();
            }
            deque.addLast(nums[i]);
        }
        ret[0] = deque.peekFirst();
        for (int i = k; i < nums.length; i++) {
            if (deque.peekFirst() == nums[i - k]) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.pollLast();
            }
            deque.addLast(nums[i]);
            ret[i - k + 1] = deque.peekFirst();
        }
        return ret;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length <= 0) {
            return new int[0];
        }
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        int[] ret = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length - k + 1; i++) {
            if (maxIndex >= i) {
                if (max < nums[i + k - 1]) {
                    maxIndex = i + k - 1;
                    max = nums[i + k - 1];
                }
            } else {
                for (int j = i; j < i + k; j++) {
                    if (max < nums[j]) {
                        max = nums[j];
                        maxIndex = j;
                    }
                }
            }
            ret[i] = max;
        }
        return ret;
    }

    public static void main(String[] args) {
        Offer2 offer2 = new Offer2();
        offer2.reverseWords(" ");
    }
}
