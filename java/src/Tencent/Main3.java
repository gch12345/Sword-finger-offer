package Tencent;

import java.util.*;

public class Main3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            long num = sc.nextLong();
            for (long i = 0; i < num; i++) {
                long ret = help(sc.nextLong());
                System.out.println(ret);
            }
        }
    }

    private static long help(long num) {
        if (num < 10) {
            return num;
        }
        long ret = 0;
        long count = 9;
        while (num > count) {
            count = count * 10 + 9;
            ret += 9;
        }
        count /= 10;
        count = num - count;
        while (count != 0) {
            ret += count % 10;
            count /= 10;
        }
        return ret;
    }
}