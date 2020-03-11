package nowCoder;

import java.util.Scanner;

public class factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int count = 0;
            long num = 1;
            for (int i = 1; i <= n; i++) {
                num = num * i;
                while ((double)(num / 10) == num / 10.0) {
                    num = num / 10;
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
