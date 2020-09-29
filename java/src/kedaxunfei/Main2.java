package kedaxunfei;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.next();
            StringBuilder stringBuilder = new StringBuilder();
            int i = 0;
            while (i < str.length() && str.charAt(i) == '_') {
                i++;
            }
            int j = str.length() - 1;
            while (j >= 0 && str.charAt(j) == '_') {
                j--;
            }
            for (; i <= j;) {
                while (i <= j && str.charAt(i) != '_') {
                    stringBuilder.append(str.charAt(i));
                    i++;
                }
                if (i <= j && str.charAt(i) == '_') {
                    stringBuilder.append('_');
                    while (i <= j && str.charAt(i) == '_') {
                        i++;
                    }
                }
            }
            System.out.println(stringBuilder.toString());
        }
    }
}
