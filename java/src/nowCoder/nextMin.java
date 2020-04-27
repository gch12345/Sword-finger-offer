package nowCoder;

import java.util.Scanner;
import java.util.Stack;

public class nextMin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            int[] arr = new int[num];
            for (int i = 0; i < num; i++) {
                arr[i] = sc.nextInt();
            }
            Stack<Integer> stack = new Stack<>();
            int[] left = new int[num];
            for (int i = 0; i < num; i++) {
                while (true) {
                    if (stack.isEmpty()) {
                        left[i] = -1;
                        stack.push(i);
                        break;
                    } else if (arr[stack.peek()] < arr[i]) {
                        left[i] = stack.peek();
                        stack.push(i);
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
            stack.clear();
            int[] right = new int[num];
            for (int i = num - 1; i >= 0; i--) {
                while (true) {
                    if (stack.isEmpty()) {
                        right[i] = -1;
                        stack.push(i);
                        break;
                    } else if (arr[stack.peek()] < arr[i]) {
                        right[i] = stack.peek();
                        stack.push(i);
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
            for (int i = 0; i < num; i++) {
                System.out.println(left[i] + " " + right[i]);
            }
        }
    }
}
