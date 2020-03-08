package nowCoder;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class mostNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < s.length(); i+=2) {
                if (map.containsKey((int)(s.charAt(i) - '0')))
                map.put((int)(s.charAt(i) - '0'), map.get((int)(s.charAt(i) - '0')) + 1);
                else {
                    map.put((int)(s.charAt(i) - '0'), 0);
                }
            }
            Set<Integer> set = map.keySet();
            int num = 0;
            int count = 0;
            for (int x : set) {
                if (map.get(x) > count) {
                    num = x;
                    count = map.get(x);
                }
            }
            System.out.println(num);
        }
    }
}
