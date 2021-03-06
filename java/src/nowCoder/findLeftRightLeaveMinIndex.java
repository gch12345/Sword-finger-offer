package nowCoder;

import org.junit.Test;

import java.util.Scanner;
import java.util.Stack;

public class findLeftRightLeaveMinIndex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int len = sc.nextInt();
            int[] arr = new int[len];
            for (int i = 0; i < len; i++) {
                arr[i] = sc.nextInt();
            }
            for (int i = 0; i < len; i++) {
                int left = i;
                int right = i;
                while (left >= 0 && arr[left] >= arr[i]) {
                    left--;
                }
                while (right < len && arr[right] >= arr[i]) {
                    right++;
                }
                if (right >= len) {
                    right = -1;
                }
                System.out.println(left + " " + right);
            }
        }
    }

    @Test
    public void t0() {
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
                        stack.push(arr[i]);
                        break;
                    } else if (arr[stack.peek()] < arr[i]) {
                        left[i] = stack.peek();
                        stack.push(arr[i]);
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
                        stack.push(arr[i]);
                        break;
                    } else if (arr[stack.peek()] < arr[i]) {
                        right[i] = stack.peek();
                        stack.push(arr[i]);
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

    @Test
    public void t() {
        System.out.println("FG");
    }
}
