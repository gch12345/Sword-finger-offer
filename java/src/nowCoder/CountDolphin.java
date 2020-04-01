package nowCoder;

import Practice.A;

import java.util.ArrayList;
import java.util.Scanner;
//n（初始海豚数）
//        m（海豚寿命）
//        海豚生宝宝的年份数量(假设为p)
//        海豚生宝宝的年份1
//        ...//
//        海豚生宝宝的年份p
//        x（几年后）
public class CountDolphin {
    private static int endNum;
    private static int Year;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int initNum = sc.nextInt();
            endNum = 1;
            if (initNum == 0) {
                endNum = 0;
            }
            int life = sc.nextInt();
            int p = sc.nextInt();
            int[] birthYear = new int[p];
            for (int i = 0; i < birthYear.length; i++) {
                birthYear[i] = sc.nextInt();
            }
            int x = sc.nextInt();
            Year = x;
            helper(0, birthYear, life, 0, 0);
            System.out.println(endNum * initNum);
        }
    }

    private static void helper (int x, int[] birthYear, int life, int year, int start) {
        if (x >= life || year >= Year) {
            if (x >= life) {
                endNum--;
            }
            return;
        }
        for (int i = start; i < birthYear.length; i++) {
            if (x == birthYear[i]) {
                endNum++;
                helper(0, birthYear, life, year, 0);
            }
            helper(x + 1, birthYear, life, year + 1, start + 1);
        }
    }
}
