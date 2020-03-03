package nowCoder;

import java.util.Stack;

public class Parenthesis {
    public static boolean chkParenthesis(String A, int n) {
        // write code here
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            char c = A.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else if (c == ')' && !stack.isEmpty()) {
                char ch = stack.pop();
                if (ch != '(') {
                    return false;
                }
            } else {
                return false;
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(chkParenthesis("(()())", 6));
    }
}