package duxiaman;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            long n = sc.nextLong();
            long m = sc.nextLong();
            long ret = ((n * 3) * (m + (n * 3) * m)) / 2;
            System.out.println(ret);
        }
    }
}
