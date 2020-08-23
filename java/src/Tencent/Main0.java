package Tencent;

import java.util.Scanner;

public class Main0 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int len = sc.nextInt();
            int num = sc.nextInt();
            for (int i = 1; i <= len; i++) {
                if (i == num) {
                    sc.nextInt();
                    continue;
                }
                int n = sc.nextInt();
                System.out.print(n + " ");
            }
        }
    }
}
