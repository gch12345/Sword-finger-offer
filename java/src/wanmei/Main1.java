package wanmei;

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.next();
            StringBuilder stringBuilder = new StringBuilder();
            Map<Character, Integer> map = new HashMap<>();
            int count = 0;
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (map.containsKey(ch)) {
                    if (map.get(ch) == -1) {
                        continue;
                    }
                    stringBuilder.deleteCharAt(map.get(ch) - count);
                    map.put(ch, -1);
                    count++;
                } else {
                    map.put(ch, stringBuilder.length());
                    count = 0;
                    stringBuilder.append(ch);
                }
            }
            System.out.println(stringBuilder.toString());
        }
    }
}
