package didi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int a = 0; a < 10; a++) {
                for (int b = 0; b < 10; b++) {
                    if (a == b) {
                        continue;
                    }
                    for (int c = 0; c < 10; c++) {
                        if (c == a || c == b) {
                            continue;
                        }
                        int num1 = a * 100 + b * 10 + c;
                        int num2 = a * 100 + c * 10 + c;
                        if (num1 + num2 == num) {
                            list.add(num1);
                        }
                    }
                }
            }
            Collections.sort(list);
            System.out.println(list.size());
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
                System.out.println(num - list.get(i));
            }
        }
    }
}
