package Tencent;

import java.util.*;

public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            List<Long> list = new ArrayList<>();
            for (int i = 0; i < num; i++) {
                list.add(sc.nextLong());
            }
            long count = 0;
            while (true) {
                int i = 0;
                while (!list.isEmpty() && list.get(i) == 0) {
                    list.remove(0);
                }
                if (list.isEmpty()) {
                    break;
                }
                for (; i < list.size(); i++) {
                    if (list.get(i) == 0) {
                        break;
                    }
                }
                count++;
                if (i <= list.get(0)) {
                    list.remove(0);
                } else {
                    for (int j = 0; j < i; j++) {
                        list.set(j, list.get(j) - 1);
                    }
                }
            }
            System.out.println(count);
        }
    }
}