package didi;

import java.util.Scanner;

public class Main0 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            long[][] arr = new long[num][num];
            long[] temp = new long[num * num];
            help(temp, num * num);
            int i,j;
            int k = num * num - 1;
            for (i = 0; i <= num / 2; i++) {
                for (j = i; j < num - i; j++) {
                    arr[i][j] = temp[k--];
                }
                for (j = i + 1; j < num - i; j++) {
                    arr[j][num - 1 - i] = temp[k--];
                }
                for (j = num - 2 - i; j > i; j--) {
                    arr[num - 1 - i][j] = temp[k--];
                }
                for (j = num - 1 - i; j > i; j--) {
                    arr[j][i] = temp[k--];
                }
            }
            for (i = 0; i < num; i++) {
                for (j = 0; j < num; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    private static void help(long[] arr, int n) {
        if (n == 0) {
            return;
        }
        arr[0] = 1;
        if (n == 1) {
            return;
        }
        arr[1] = 1;
        for (int i = 2; i < n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
    }
}
