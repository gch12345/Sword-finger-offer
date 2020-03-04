package nowCoder;

import java.util.Scanner;

public class buyApple {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            int ret = -1;
            int six = 0;
            int eight = num / 8;
            num = num % 8;
            while (eight >= 0 && num != 0) {
                if (num % 6 == 0) {
                    six = num / 6;
                    break;
                }
                eight = eight - 1;
                num = num + 8;
            }
            ret = six + eight;
            System.out.println(ret);
        }
    }
}
