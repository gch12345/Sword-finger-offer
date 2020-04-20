package nowCoder;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.SimpleTimeZone;

public class GetOutDay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int year = sc.nextInt();
            int month = sc.nextInt();
            int day = sc.nextInt();
            System.out.println(iConverToDay(year, month, day));
        }
    }

    static int iConverToDay(int year, int month, int day) {
        if (month > 12 && day > 31) {
            return -1;
        }
        boolean bool = isLeapYear(year);
        int ret = 0;
        for (int i = 1; i < month; i++) {
            if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
                ret += 31;
            } else if (i == 2) {
                if (bool) {
                    ret += 29;
                } else {
                    ret += 28;
                }
            } else {
                ret += 30;
            }
        }
        ret = ret + day;
        return ret;
    }

    static boolean isLeapYear(int year) {
        if (((year % 4 == 0) && (year % 100 != 0)) ||
                (year % 400 == 0)) {
            return true;
        }
        return false;
    }
}
