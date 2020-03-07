package nowCoder;

import java.util.Scanner;

public class ABC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int A_B = sc.nextInt();
            int B_C = sc.nextInt();
            int AB = sc.nextInt();
            int BC = sc.nextInt();
            int A = (A_B + AB) / 2;
            int B = A - A_B;
            int C = B - B_C;
            if (A + B == AB && B + C == BC) {
                System.out.printf("%d %d %d\n", A, B, C);
            } else {
                System.out.println("No");
            }
        }
    }
}
