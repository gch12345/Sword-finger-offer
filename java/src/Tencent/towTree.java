package Tencent;

import java.util.Scanner;

public class towTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            for (int i = 0; i < num; i++) {
                int x = sc.nextInt();
                int k = sc.nextInt();
                System.out.println(helper(x, k));
            }
        }
    }

    private static int helper(int x, int k) {
        int num = x;
        int lower = 0;
        while (num != 0) {
            lower++;
            num = num >> 1;
        }
        if (lower <= k) {
            return -1;
        }
        int count = (int) Math.pow(2, lower - 2);
        for (int i = lower; i > k; i--) {
            x = count + (x - count * 2) / 2;
            count = count / 2;
        }
        return x;
    }
}
