package wangyi;

import org.junit.Test;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int N = sc.nextInt();
            int S = sc.nextInt();
            int X = sc.nextInt();
            int ret = 0;
            for (int i = 10; i < (int)Math.pow(10, N); i++) {
                if (i != 0 && i < X) {
                    continue;
                }
                int num = 0;
                int I = i;
                int[] bit = new int[N];
                for (int j = N - 1; j >= 0; j--) {
                    if (I / 10 == I / 10.0) {
                        I = I / 10;
                        continue;
                    }
                    num = num + I % 10;
                    bit[j] = I % 10;
                    I /= 10;
                    if (I == 0) {
                        break;
                    }
                }
                if (num != S) {
                    continue;
                }
                int j = 0;
                for (; j < N - 2; j++) {
                    int count = bit[j] * 100 + bit[j + 1] * 10 + bit[j + 2];
                    if (count % X != 0) {
                        break;
                    }
                }
                if (j == N - 2) {
                    ret++;
                }
            }
            System.out.println(ret % 1000009);
        }
    }

    @Test
    public void t() {
        int num = 10;
        double num0 = 10.0;
        System.out.println(num == num0);
    }
}
