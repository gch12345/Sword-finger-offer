package wanmei;

import java.util.*;

public class Main {
    private static int num;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            num = Integer.MAX_VALUE;
            int a = sc.nextInt();
            int b = sc.nextInt();
            int A = sc.nextInt();
            int B = sc.nextInt();
            if (process(a, b, A, B, 0)) {
                System.out.println(num);
            } else {
                System.out.println(-1);
            }
        }
    }
    public static String removeChar (String str) {
        // write code here
        if (str == null) {
            return str;
        }
        Map<Character, Integer> map = new HashMap<>();
        Set<Character> set = null;
        int max = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
            if (map.get(ch) > max) {
                max = map.get(ch);
                set = new HashSet<>();
                set.add(ch);
            } else if (map.get(ch) == max) {
                set.add(ch);
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (set.contains(ch)) {
                continue;
            }
            stringBuffer.append(ch);
        }
        return stringBuffer.toString();
    }

    public static boolean process (int a, int b, int A, int B, int count) {
        if (a > A || b > B) {
            return false;
        }
        if (a == A && b == B) {
            if (count < num) {
                num = count;
            }
            return true;
        }
        boolean ret1 = process(a + 1, b + 1, A, B, count + 1);
        boolean ret2 = process(a * 2, b * 2, A, B, count + 1);
        return ret1 || ret2;
    }
}
