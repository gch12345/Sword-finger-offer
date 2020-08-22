package _360;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            int count = 0;
            for (int i = 0; i < num; i++) {
                String s = sc.next();
                if (s.length() > 10) {
                    continue;
                }
                count++;
                for (int j = 0; j < s.length(); j++) {
                    char ch = s.charAt(j);
                    if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {

                    } else {
                        count--;
                        break;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
