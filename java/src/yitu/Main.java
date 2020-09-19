package yitu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int num = sc.nextInt();
            double max = 0;
            int maxIndex = 0;
            int t = 0;
            int x = 0;
            int y = 0;
            int z = 0;
            for (int i = 0; i < num; i++) {
                int t0 = sc.nextInt();
                int x0 = sc.nextInt();
                int y0 = sc.nextInt();
                int z0 = sc.nextInt();
                double d =  Math.sqrt(Math.pow(x0 - x, 2) + Math.pow(y0 - y, 2) + Math.pow(z0 - z, 2)) / (t0 - t);
                if (d > max) {
                    max = d;
                    maxIndex = i;
                }
                t = t0;
                x = x0;
                y = y0;
                z = z0;
            }
            System.out.print(maxIndex);
        }
    }
}
