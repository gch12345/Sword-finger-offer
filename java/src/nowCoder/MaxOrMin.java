package nowCoder;

import java.util.Scanner;

public class MaxOrMin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int ret = 0;
            if (n == 1) {
                ret = 0;
            } else if (n == 2) {
                ret = arr[0] ^ arr[1];
            } else {
                for (int i = 0; i < n; i++) {
                    for (int j = i + 1; j < n; j++) {
                        ret = ret ^ helper(arr, i, j);
                    }
                }
            }
            System.out.println(ret);
        }
    }

    private static int helper (int[] arr, int start, int end) {
        int down = arr[start] ^ arr[start + 1];
        int maxDown = arr[start];
        int minDown = arr[start + 1];
        if (arr[start] < arr[start + 1]) {
            maxDown = arr[start + 1];
            minDown = arr[start];
        }
        int retDown = down;
        for (int i = start + 2; i <= end; i++) {
            if (arr[i] < minDown) {
                down = down ^ minDown ^ arr[i];
                retDown = retDown ^ down;
                minDown = arr[i];
            }
            if (arr[i] > maxDown) {
                down = down ^ maxDown ^ arr[i];
                retDown = retDown ^ down;
                maxDown = arr[i];
            }
        }
        int up = arr[end] ^ arr[end -1];
        int minUp = arr[end];
        int maxUp = arr[end - 1];
        int retUp = up;
        if (arr[end] < arr[end - 1]) {
            minUp = arr[end - 1];
            maxUp = arr[end];
        }
        for (int i = end - 2; i > start; i--) {
            if (arr[i] < minUp) {
                up = up ^ minUp ^ arr[i];
                retUp = retUp ^ up;
                minUp = arr[i];
            }
            if (arr[i] > maxUp) {
                up = up ^ maxUp ^ arr[i];
                retUp = retUp ^ up;
                maxUp = arr[i];
            }
        }
        return retDown ^ retUp;
    }
}
