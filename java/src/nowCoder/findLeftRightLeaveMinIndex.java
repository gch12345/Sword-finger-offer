package nowCoder;

import java.util.Scanner;

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
}
