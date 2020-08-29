package LeetCode;

import java.util.Scanner;

public class _26 {
    public static void fun(int num) {
        if (num < 0) {
            return;
        }
        while (num >= 26) {
            char count = (char) ((num / 26) + 'A' - 1);
            int n = num % 26;
            System.out.print(count);
            num = n;
        }
        char count = (char)(num + 'A');
        System.out.println(count);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            fun(scanner.nextInt());
        }
    }
}
