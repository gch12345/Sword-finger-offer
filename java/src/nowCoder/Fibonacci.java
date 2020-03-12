package nowCoder;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Integer> set = new HashSet<>();
        int a = 0;
        int b = 0;
        int c = 1;
        while (sc.hasNext()) {
            int num = sc.nextInt();
            while (c <= num) {
                a = b;
                b = c;
                c = a + b;
                set.add(c);
            }
            int num0 = num;
            int count = 0;
            while (!set.contains(num) && !set.contains(num0)) {
                num--;
                num0++;
                count++;
            }
            System.out.println(count);
        }
    }

}
