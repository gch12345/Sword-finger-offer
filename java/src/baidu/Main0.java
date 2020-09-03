package baidu;

import java.util.Scanner;

public class Main0 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            int _0 = 0;
            int _5 = 0;
            for (int i = 0; i < num; i++) {
                int n = sc.nextInt();
                if (n == 0) {
                    _0++;
                } else {
                    _5++;
                }
            }
            if (_0 == 0 || _5 < 9) {
                System.out.println(-1);
            } else {
                int count = _5 / 9;
                for (int i = 0; i < count; i++) {
                    System.out.print("555555555");
                }
                for (int i = 0; i < _0; i++) {
                    System.out.print("0");
                }
                System.out.println();
            }
        }
    }
}
