package wangyi;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            String s1 = scanner.next();
            String s2 = scanner.next();
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < s2.length(); i++) {
                int n = s2.charAt(i) - '0';
                if (map.containsKey(n)) {
                    map.put(n, map.get(n) + 1);
                } else {
                    map.put(n, 1);
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            int count = 0;
            for (int i = 0; i < s1.length(); i++) {
                int n = s1.charAt(i) - '0';
                int j = n;
                for (; j <= 9; j++) {
                    if (map.containsKey(j) && map.get(j) > 0) {
                        stringBuilder.append(j);
                        if (j != n) {
                            count++;
                        }
                        map.put(j, map.get(j) - 1);
                        break;
                    }
                }
            }
            int n = stringBuilder.toString().compareTo(s1);
            if (n > 0) {
                System.out.println(stringBuilder.toString());
            } else {

                System.out.println(-1);
            }
        }
    }
}
