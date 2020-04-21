package nowCoder;

import org.junit.Test;

import java.util.Scanner;

public class duXiaoMan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            int ret = 0;
            for (int i = 0; i < n - a + 1; i++) {
                for (int j = 0; j < m - b + 1; j++) {
                    int num = (i + b - 1) * (j + a - 1) % 10;
                    ret += num;
                }
            }
            System.out.println(ret);
        }
    }

    @Test
    public void t0() {
        StringBuilder stringBuilder = new StringBuilder("a").append("a");
        String str1 = stringBuilder.toString();
        String str2 = str1.intern();
        System.out.println(str2 == str1);
    }
}
