package _360;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.next();
            char ch = (char) (str.charAt(0) - 'a' + 'A');
            System.out.print(ch);
            for (int i = 1; i < str.length(); i++) {
                if (str.charAt(i) == 'n') {
                    System.out.println();
                    System.out.print('N');
                } else {
                    System.out.print(str.charAt(i));
                }
            }
        }
    }
}
