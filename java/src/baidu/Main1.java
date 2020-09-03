package baidu;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            count = 0;
            int n = sc.nextInt();
            int m = sc.nextInt();
            help(n, m, 0, 0, 0);
            System.out.println(count);
        }
    }
    static int count = 0;
    public static void help(int n, int m, int firstLast, int secondLast, int curN) {
        if (curN == n) {
            count++;
            count = count % ((int)Math.pow(10, 9) + 7);
        }
        for (int i = 1; i <= m; i++) {
            if (i == firstLast || i == secondLast) {
                continue;
            }
            if (curN + i > n) {
                break;
            }
            help(n, m, i, firstLast, curN + i);
        }
    }
}
