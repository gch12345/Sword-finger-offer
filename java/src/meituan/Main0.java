package meituan;

import java.util.Scanner;
import java.util.Stack;

public class Main0 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<String> strings = new Stack<>();
        while (sc.hasNext()) {
            int count = 0;
            int num = sc.nextInt();
            for (int i = 0; i < num * 2; i++) {
                String s = sc.next();
                if (strings.isEmpty()) {
                    count++;
                    strings.add(s);
                } else {
                    if (strings.peek().equals(s)) {
                        strings.pop();
                    } else {
                        strings.add(s);
                    }
                }
            }
            System.out.println(count);
        }
    }
}
