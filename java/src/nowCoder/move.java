package nowCoder;

import org.junit.Test;
import java.util.regex.*;
import java.util.Scanner;

public class move {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            String[] strings = str.split(";");
            int X = 0;
            int Y = 0;
            for (String string : strings) {
                if (string.startsWith("A") || string.startsWith("D") || string.startsWith("W") || string .startsWith("S")) {
                    char start = string.charAt(0);
                    int num = 0;
                    for (int i = 1; i < string.length(); i++) {
                        char ch = string.charAt(i);
                        if (ch >= '0' && ch <= '9') {
                            num = num * 10 + ch - '0';
                        } else {
                            num = 0;
                            break;
                        }
                    }
                    if (num == 0) {
                        continue;
                    }
                    if (start == 'A') {
                        X = X - num;
                    } else if (start == 'D') {
                        X = X + num;
                    } else if (start == 'W') {
                        Y = Y + num;
                    } else {
                        Y = Y - num;
                    }
                }
            }
            System.out.printf("%d,%d", X, Y);
        }
    }

    @Test
    public void t0() {
        String str = "22";
        System.out.println(str.matches("[0-9]*"));
    }
}
