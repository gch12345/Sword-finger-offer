package nowCoder;

import java.util.Scanner;

public class hungry {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            int ret = 0;
            if (num % 1000000007 == 0 && num == 0) {
                System.out.println(ret);
            } else {
                int ret4 = helper(0, num, 4);
                int ret8 = helper(0, num, 8);
                if (ret4 == -1) {
                    System.out.println(-1);
                } else {
                    System.out.println(ret4 > ret8 ? ret8 : ret4);
                }
            }
        }
    }

    public static int helper(int ret, long num, int count) {
        if (ret > 100000) {
            return -1;
        }
        long Num = num * count + 3;
        if (count == 8) {
            Num = Num + 4;
        }
        if (Num % 1000000007 == 0) {
            ret++;
            return ret;
        }
        int ret4 = helper(ret + 1, Num, 4);
        int ret8 = helper(ret + 1, Num, 8);
        if (ret4 == -1) {
            return ret8;
        }
        return ret4 > ret8 ? ret8 : ret4;
    }
}
