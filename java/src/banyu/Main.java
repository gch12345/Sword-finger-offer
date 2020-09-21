package banyu;

import java.util.Stack;

public class Main {
    public static int minInsertions (String s) {
        // write code here
        if (s == null) {
            return 0;
        }
        Stack<Character> stack = new Stack<>();
        int index = 0;
        int count = 0;
        while (index < s.length()) {
            char ch = s.charAt(index);
            if (ch == '(') {
                if (!stack.isEmpty() && stack.peek() == ')') {
                    count++;
                    stack.pop();
                    stack.pop();
                }
                stack.push('(');
            } else {
                if (stack.isEmpty()) {
                    stack.add('(');
                    count++;
                }
                if (stack.peek() == ')'){
                    stack.pop();
                    stack.pop();
                } else {
                    stack.add(')');
                }
            }
            index++;
        }
        if (!stack.isEmpty()) {
            if (stack.peek() == ')') {
                count = count + (stack.size() - 1) * 2 - 1;
            } else {
                count = count + stack.size() * 2;
            }
        }
        return count;
    }

    public static int movingCount (int m, int n, int k) {
        // write code here
        if (k == 0) {
            return 0;
        }
        num = 0;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int num1 = help(i);
                int num2 = help(j);
                if (num1 + num2 <= k) {
                    dp[i][j] = 1;
                }
            }
        }
        int ret = 0;
        int[][] p = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int h = 0; h < 4; h++) {
                    int x = i + p[h][0];
                    int y = j + p[h][1];
                    if (x >= 0 && x < m && y >= 0 && y < n && dp[i][j] == 1) {
                        ret++;
                        break;
                    }
                }
            }
        }
//        helper(dp, 0, 0);
        return ret;
    }
    static int num = 0;
    private static void helper(int[][] dp, int i, int j) {
        if (i < 0 || j < 0 || i >= dp.length || j >= dp[0].length || dp[i][j] == 0 || dp[i][j] == -1) {
            return;
        }
        num++;
        dp[i][j] = -1;
        if (i + 1 < dp.length && dp[i + 1][j] != -1 && dp[i + 1][j] != 0) {
            helper(dp, i + 1, j);
        }
        if (i - 1 >= 0 && dp[i - 1][j] != - 1 && dp[i - 1][j] != 0) {
            helper(dp, i - 1, j);
        }
        if (j + 1 < dp[0].length && dp[i][j + 1] != -1 && dp[i][j + 1] != 0) {
            helper(dp, i, j + 1);
        }
        if (j - 1 >= 0 && dp[i][j - 1] != -1 && dp[i][j - 1] != 0) {
            helper(dp, i, j - 1);
        }
    }

    private static int help(int num) {
        if (num <= 9) {
            return num;
        }
        int ret = 0;
        while (num != 0) {
            ret += num % 10;
            num /= 10;
        }
        return ret;
    }

    public static void main(String[] args) {
//        System.out.println(minInsertions(")()"));
        System.out.println(movingCount(100, 100, 100));
    }
}
