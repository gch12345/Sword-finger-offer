package glodon;

import org.junit.Test;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()) {
//            int nums = sc.nextInt();
//            List<Integer> list = new ArrayList<>();
//            for (int i = 0; i < nums; i++) {
//                int num = sc.nextInt();
//                list.add(num);
//            }
//            Collections.sort(list);
//            int x = 0;
//            int y = 0;
//            for (int i = list.size() - 1; i > 0; i--) {
//                if (x == 0 && list.get(i) == list.get(i - 1)) {
//                    x = list.get(i);
//                    i -= 2;
//                }
//                if (i > 0 && x != 0 && list.get(i) == list.get(i - 1)) {
//                    y = list.get(i);
//                    i -= 2;
//                }
//            }
//            if (x == 0 || y == 0) {
//                System.out.println(-1);
//            } else {
//                System.out.println(x * y);
//            }
//        }
        fun1();
    }

    public void fun() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int nums = sc.nextInt();
            long x = 0;
            long y = 0;
            long max = 0;
            Set<Long> set = new HashSet<>();
            for (int i = 0; i < nums; i++) {
                long num = sc.nextLong();
                if (num <= max) {
                    continue;
                }
                if (set.contains(num)) {
                    set.remove(num);
                    if (x < y) {
                        max = x;
                        x = num;
                    } else {
                        max = y;
                        y = num;
                    }
                } else {
                    set.add(num);
                }
            }
            if (x == 0 || y == 0) {
                System.out.println(-1);
            } else {
                System.out.println(x * y);
            }
        }
    }

    public static void fun0() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            long nums = sc.nextLong();
            long max = 0;
            long count = 0;
            for (long i = 0; i < nums; i++) {
                long num = sc.nextLong();
                if (num < max) {
                    count++;
                } else {
                    max = num;
                }
            }
            System.out.println(count);
        }
    }

    public static void fun1() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            long nums = sc.nextLong();
            long max = 0;
            long count = 0;
            long[] arr = new long[(int)nums];
            for (int i = 0; i < nums; i++) {
                arr[i] = sc.nextLong();
            }
            for (int i = 1; i < nums; i++) {
                long num = arr[i];
                int j = i - 1;
                while (j >= 0 && num < arr[j]) {
                    arr[j + 1] = arr[j];
                    j--;
                }
                if (j == -1) {
                    count++;
                } else {
                    count += i - 1 - j;
                }
                arr[j + 1] = num;
            }
            System.out.println(count);
        }
    }
}
