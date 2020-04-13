package nowCoder;

import java.util.Scanner;

public class HexToDec {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            int num = 1;
            int dec = 0;
            for (int i = str.length() - 1; i > 1; i--) {
                char ch = str.charAt(i);
                if (ch >= 'A') {
                    dec = dec + num * (ch - 'A' + 10);
                } else {
                    dec = dec + num * (ch - '0');
                }
                num = num * 16;
            }
            System.out.println(dec);
        }
    }
}
