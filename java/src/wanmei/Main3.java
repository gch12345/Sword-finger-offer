package wanmei;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int ret = 0;
            if (n == 1) {
                ret = 1;
            } else {
                ret = 1 + (n - 1) * (m / 2);
            }
            System.out.println(ret);
        }
    }
}
