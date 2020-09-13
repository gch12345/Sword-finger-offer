package aiqiyi;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.next();
            int ret = helper(s);
            System.out.println(ret);
        }
    }

    private static int helper(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                count = i - map.get(ch);
            } else {
                count++;
            }
            if (count > max) {
                max = count;
            }
            map.put(ch, i);
        }
        return max;
    }
}
