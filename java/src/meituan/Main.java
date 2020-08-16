package meituan;

import java.util.*;

public class Main {
    static List<Long> longs = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            longs.clear();
            long num = sc.nextLong();
            for (long i = 1; i <= num; i++) {
                help(i);
            }
            if (longs.isEmpty()) {
                System.out.println(0);
            } else {
                System.out.println(longs.size() / 2);
                while (!longs.isEmpty()) {
                    System.out.print(longs.remove(0) + " ");
                    System.out.println(longs.remove(0));
                }
            }
        }
    }

    private static void help(long num) {
        long reserve = 0;
        long curNum = num;
        while (curNum != 0) {
            reserve = reserve * 10 + curNum % 10;
            curNum = curNum / 10;
        }
        if (num * 4 == reserve) {
            longs.add(num);
            longs.add(reserve);
        }
    }
}
