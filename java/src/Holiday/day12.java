package Holiday;

import java.util.Stack;

public class day12 {
//    给定一个整数数组，你需要寻找一个连续的子数组，
//    如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
//    你找到的子数组应是最短的，请输出它的长度。
    public int findUnsortedSubarray(int[] nums) {
        int start = -1;
        int end = -1;
        int i = 0;
        int max = nums[0];
        while (i < nums.length - 1) {
            if (nums[i] > nums[i + 1]) {
                if (max < nums[i]) {
                    max = nums[i];
                }
            }
            i++;
        }
        int min = nums[nums.length - 1];
        while (i > 0) {
            if (nums[i] < nums[i - 1]) {
                if (min > nums[i]) {
                    min = nums[i];
                }
            }
            i--;
        }
        for (; i < nums.length; i++) {
            if (nums[i] > min) {
                start = i;
                break;
            }
        }
        i = nums.length - 1;
        for (; i >= 0; i--) {
            if (nums[i] < max) {
                end = i;
                break;
            }
        }
        if (start == -1 || end == -1) {
            return 0;
        }
        return end - start + 1;
    }

    public int findUnsortedSubarray0(int[] nums) {
        int max = nums[0];
        int min = nums[nums.length - 1];
        int start = -1;
        int end = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < max) {
                end = i;
            } else {
                max = nums[i];
            }
        }
        for (int j = nums.length - 2; j >= 0; j--) {
            if (nums[j] > min) {
                start = j;
            } else {
                min = nums[j];
            }
        }
        if (start == -1) {
            return 0;
        }
        return end - start + 1;
    }

//    根据逆波兰表示法，求表达式的值。
//    有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
//    说明：整数除法只保留整数部分。
//    给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int re = 0;
        for (int i = 0; i < tokens.length; i++) {
            int num = 0;
            String s = tokens[i];
            boolean star = false;
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (c >= '0' && c <= '9') {
                    num = num * 10 + (c - '0');
                } else {
                    star = true;
                }
            }
            if (star) {
                int x = stack.pop();
                int y = stack.pop();
                char ch = s.charAt(0);
                if (ch == '+') {
                   stack.push(y + x);
                } else if (ch == '-') {
                    stack.push(y - x);
                } else if (ch == '*') {
                    stack.push(y * x);
                } else {
                    stack.push(y / x);
                }
            } else {
                stack.push(num);
            }
        }
        return stack.pop();
    }

    public int evalRPN0(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if (s.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (s.equals("-")) {
                stack.push(-stack.pop() + stack.pop());
            } else if (s.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (s.equals("/")) {
                int x = stack.pop();
                int y = stack.pop();
                stack.push(y / x);
            } else {
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.pop();
    }
}
