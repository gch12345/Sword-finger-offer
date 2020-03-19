package nowCoder;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class studentGroup {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int studentNum = sc.nextInt();
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < studentNum; i++) {
                int num = sc.nextInt();
                if (map.containsKey(num)) {
                    map.put(num, map.get(num) + 1);
                } else {
                    map.put(num, 1);
                }
            }
            int num = sc.nextInt();
            System.out.println(map.get(num));
        }
    }

}
