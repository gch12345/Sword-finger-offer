package kedaxunfei;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            String[] str = sc.next().split(",");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            for (int i = 0; i < n; i++) {
                int min = i;
                for (int j = i + 1; j < n; j++) {
                    if (arr[min] > arr[j]) {
                        min = j;
                    }
                }
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i]);
                if (i != n - 1) {
                    System.out.print(",");
                }
            }
            System.out.println();
        }
    }
}
