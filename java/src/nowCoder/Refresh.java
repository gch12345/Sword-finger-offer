package nowCoder;

import java.util.Scanner;

public class Refresh {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNextInt()) {
            int num = s.nextInt();
            System.out.println(helper(num));
        }
    }
    private static int helper(int num) {
        if (num <= 2) {
            return 0;
        }
        int ret = 0;
        while (num > 2) {
            int temp = num / 3;
            ret = ret + temp;
            num = num % 3;
            num = temp + num;
        }
        if (num == 2) {
            ret++;
        }
        return ret;
    }
}
