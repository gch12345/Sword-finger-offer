package dajiang;

import java.util.Scanner;
import java.util.Stack;

public class Main0 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String string = sc.next();
            int num = sc.nextInt();
            Stack<Character> stack = new Stack<>();
            char[] chars = string.toCharArray();
            int i = 0;
            while (num != 0) {
                if (i >=  chars.length) {
                    stack.pop();
                    num--;
                    continue;
                }
                if (stack.isEmpty() || stack.peek() <= chars[i]) {
                    stack.add(chars[i++]);
                } else {
                    while (num != 0 && !stack.isEmpty() && stack.peek() > chars[i]) {
                        stack.pop();
                        num--;
                    }
                    stack.add(chars[i++]);
                }
            }
            char[] ch = new char[stack.size()];
            for (int j = stack.size() - 1; j >= 0; j--) {
                ch[j] = stack.pop();
            }
            string = new String(ch) + string.substring(i);
            int j = 0;
            while (j < string.length() &&  string.charAt(j) == '0') {
                j++;
            }
            if (j >= string.length()) {
                System.out.println(0);
            } else {
                System.out.println(string.substring(j));
            }
        }
    }
}
