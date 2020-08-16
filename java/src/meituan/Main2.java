package meituan;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            int[][] arr = new int[num][2];
            for (int i = 0; i < num; i++) {
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
            }
        }
    }
}
