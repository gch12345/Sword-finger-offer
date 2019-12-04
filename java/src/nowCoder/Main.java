package nowCoder;

import java.util.HashSet;
import java.util.Scanner;

public class Main {
    private static HashSet<Integer> hashSet = new HashSet<>();
    public static void Fibonacci() {
        hashSet.add(1);
        int a = 1;
        int b = 1;
        int c = 0;
        while (c < 1000000) {
            c = a + b;
            hashSet.add(c);
            a = b;
            b = c;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            Fibonacci();
            int count = 0;
            int count0 = 0;
            int num0 = num;
            while (!hashSet.contains(num)) {
                num--;
                count++;
            }
            while (!hashSet.contains(num0)) {
                num0++;
                count0++;
            }
            if (count < count0) {
                System.out.println(count);
            } else {
                System.out.println(count0);
            }
        }
    }
}
