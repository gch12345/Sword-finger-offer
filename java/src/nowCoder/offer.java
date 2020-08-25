package nowCoder;

import java.util.Scanner;

public class offer {
    public static void main0() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            int[] arr = new int[num];
            for (int i = 0; i < num; i++) {
                arr[i] = sc.nextInt();
            }
            int left = 0;
            int right = num - 1;
            int mid = (right - left) / 2 + left;
            while (left < right) {
                mid = (right - left) / 2 + left;
                if (mid + 1 <= right && arr[mid + 1] < arr[mid]) {
                    left = mid + 1;
                } else if (mid - 1 >= left && arr[mid - 1] < arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid;
                    break;
                }
            }
            System.out.println(left);
        }
    }

    public static void main(String[] args) {
        main0();
    }
}
