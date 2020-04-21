package nowCoder;

import Practice.A;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class phoneNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            sc.nextLine();
            Set<String> set = new HashSet<>();
            for (int i = 0; i < num; i++) {
                String str = sc.nextLine();
                StringBuilder stringBuilder = new StringBuilder();
                int star = 0;
                for (int j = 0; j < str.length(); j++) {
                    char ch = str.charAt(j);
                    if (ch == '-') {
                        continue;
                    }
                    if (ch >= '0' && ch <= '9') {
                        stringBuilder.append(ch);
                    } else {
                        stringBuilder.append((char)((ch - 'A') / 3 + 2 + '0'));
                    }
                    star++;
                    if (star == 3) {
                        stringBuilder.append('-');
                    }
                }
                System.out.println(stringBuilder.toString());
            }
        }
    }
}
