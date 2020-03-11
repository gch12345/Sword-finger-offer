package nowCoder;

import java.util.Scanner;

public class backword {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            StringBuffer string = new StringBuffer();
            while (num != 0) {
                string.append(num % 10 + "");
                num = num / 10;
            }
            if (string.toString().length() == 0) {
                System.out.println("" + num);
            } else {
                System.out.println(string.toString());
            }
        }
    }
}
