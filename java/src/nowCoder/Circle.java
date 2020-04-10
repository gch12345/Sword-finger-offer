package nowCoder;

import java.util.Scanner;

public class Circle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int x0 = sc.nextInt();
            int y0 = sc.nextInt();
            int z0 = sc.nextInt();
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int z1 = sc.nextInt();
            double r = Math.pow(Math.pow(Math.abs(x1 - x0), 2) + Math.pow(Math.abs(y1 - y0), 2) + Math.pow(Math.abs(z1 - z0), 2), 0.5);
            double capacity = Math.pow(r, 3) * 4 / 3 * Math.PI;
            System.out.printf("%3.3f %3.3f", r, capacity);
        }
    }
}
