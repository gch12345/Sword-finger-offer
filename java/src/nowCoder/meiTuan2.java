package nowCoder;

import java.util.Scanner;

public class meiTuan2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int ret = 0;
            int k = 0;
            for (int i = 0; i < n;) {
                if (m > arr[i]) {
                    m = m - arr[i];
                    k = 0;
                    ret++;
                    i++;
                } else if (m == arr[i]) {
                    ret++;
                    break;
                } else {
                    i++;
                    k++;
                    Math.
                }
                if (i == n) {
                    i = 0;
                }
                if (k > n) {
                    break;
                }
            }
            System.out.println(ret);
        }
    }
}
