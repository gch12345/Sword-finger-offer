package nowCoder;

import java.util.Scanner;

public class Square {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int col = sc.nextInt();
            char ch = sc.next().charAt(0);
            int row = (int)Math.round(col / 2.0);
            for (int i = 1; i <= row; i++) {
                if (i == 1 || i == row) {
                    for (int j = 1; j <= col; j++) {
                        System.out.print(ch);
                    }
                    System.out.println();
                } else {
                    System.out.println(ch + " " + ch);
                }
            }
        }
    }
}
