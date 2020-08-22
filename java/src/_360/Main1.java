package _360;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            int operaNum = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i <= num; i++) {
                list.add(i);
            }
            for (int i = 0; i < operaNum; i++) {
                int n = sc.nextInt();
                if (n == 1) {
                    int cur = list.remove(0);
                    list.add(cur);
                } else {
                    for (int j = 0; j < num; j += 2) {
                        int temp = list.get(j);
                        list.set(j, list.get(j + 1));
                        list.set(j + 1, temp);
                    }
                }
            }
            for (int i = 0; i < num; i++) {
                System.out.print(list.get(i) + " ");
            }
        }
    }
}
