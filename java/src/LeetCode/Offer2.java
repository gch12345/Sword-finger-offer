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

    //  59 - II. 队列的最大值
    private Queue<Integer> queue = new LinkedList<>();
    private Deque<Integer> deque = new LinkedList<>();
    public int max_value() {
        if (deque.isEmpty()) {
            return -1;
        }
        return deque.peekFirst();
    }

    public void push_back(int value) {
        queue.add(value);
        while (!deque.isEmpty() && deque.peekLast() < value) {
            deque.removeLast();
        }
        deque.addLast(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }
        if (queue.peek().equals(deque.peekFirst())) {
            deque.removeFirst();
        }
        return queue.poll();
    }

    // 60. n个骰子的点数
    public double[] twoSum(int n) {
        if (n <= 0) {
            return new double[0];
        }
        double[][] dp = new double[n + 1][6 * n + 1];
        for (int i = 0; i < 7; i++) {
            dp[1][i] = 1 / 6.0;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= i * 6; j++) {
                for (int k = 1; k <= 6; k++) {
                    if (j - k <= 0) {
                        break;
                    }
                    dp[i][j] += dp[i - 1][j - k] / 6.0;
                }
            }
        }
        double[] ret = new double[n * 6 - n + 1];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = dp[n][i + n];
        }
        return ret;
    }

    // 61. 扑克牌中的顺子
    public boolean isStraight0(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return true;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min && nums[i] != 0) {
                min = nums[i];
            }
        }
        int count = 0;
        int[] map = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - min >= map.length) {
                return false;
            }
            if (nums[i] == 0) {
                count++;
                continue;
            }
            map[nums[i] - min] = 1;
        }
        for (int i = 0; i < map.length; i++) {
            if (map[i] == 0) {
                count--;
            }
        }
        if (count < 0) {
            return false;
        }
        return true;
    }

    public boolean isStraight(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return true;
        }
        int len = nums.length;
        int[] map = new int[13];
        int min = 14;
        int max = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                continue;
            }
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
            if (map[nums[i] - 1] == 1) {
                return false;
            }
            map[nums[i] - 1] = 1;
        }
        return max - min < nums.length;
    }

    public static void main(String[] args) {
        Offer2 offer2 = new Offer2();
        offer2.reverseWords(" ");
    }
}
