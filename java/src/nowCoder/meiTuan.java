package nowCoder;

import java.util.Arrays;
import java.util.Scanner;

public class meiTuan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int x = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            int ret = 0;
            int left = 0;
            int right = arr.length - 1;
            while (left <= right) {
                if (arr[right] - arr[left] <= x) {
                    break;
                }
                if (x - arr[left] == arr[right] - x) {
                    int Left = left;
                    int Right = right;
                    while (Left < Right && x - arr[Left] == arr[right] - x) {
                        Left++;
                        Right--;
                    }
                    if (Left >= Right) {
                        left = arr.length - 1;
                        right = 0;
                        break;
                    }
                    if (arr[Left] - x > arr[Right] -x) {
                        Left++;
                        left = Left;
                    } else {
                        Right--;
                        right = Right;
                    }
                } else if (arr[left] - x > arr[right] -x) {
                    left++;
                } else {
                    right--;
                }
            }
            ret = left - 0 + arr.length - 1 - right;
            System.out.println(ret);
        }
    }
}
