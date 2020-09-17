package xiaomi;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine().trim();
            if (s.length() == 0){
                System.out.println(true);
            } else {
                Stack<Character> stack = new Stack<>();
                int i = 0;
                for (; i < s.length(); i++) {
                    char ch = s.charAt(i);
                    if (ch == ' ') {
                        continue;
                    }
                    if (ch == '{' || ch == '(' || ch == '[') {
                        stack.add(ch);
                    } else {
                        if (stack.isEmpty()) {
                            break;
                        }
                        char c = stack.peek();
                        if (ch == '}') {
                            if (c != '{') {
                                break;
                            }
                        } else if (ch == ']') {
                            if (c != '[') {
                                break;
                            }
                        } else {
                            if (ch == ')') {
                                if (c != '(') {
                                    break;
                                }
                            }
                        }
                        stack.pop();
                    }
                }
                if (stack.isEmpty() && i == s.length()) {
                    System.out.println(true);
                } else {
                    System.out.println(false);
                }
            }
        }
    }
}
