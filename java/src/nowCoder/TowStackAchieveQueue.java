package nowCoder;

import java.util.Scanner;
import java.util.Stack;

public class TowStackAchieveQueue {
    static Stack<Integer> stack1 = new Stack<Integer>();
    static Stack<Integer> stack2 = new Stack<Integer>();

    public static void push(int node) {
        stack1.push(node);
    }

    public static int poll() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public static int peek() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            sc.nextLine();
            for (int i = 0; i < num; i++) {
                String str = sc.nextLine();
                if (str.equals("peek")) {
                    System.out.println(peek());
                } else if(str.equals("poll")) {
                    poll();
                } else {
                    push(Integer.parseInt(str.substring(4)));
                }
            }
        }
    }
}
