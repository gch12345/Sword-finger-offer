package xiecheng;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            String[] strings = str.split(" ");
            Set<Character> set = new HashSet<>();
            List<String> list = new ArrayList<>();
            StringBuilder stringBuilder = new StringBuilder();
            helper(set, strings, 0, stringBuilder, false, list);
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
        }
    }

    private static void helper(Set<Character> set, String[] strings, int n, StringBuilder stringBuilder, boolean star, List<String> list) {
        if (n >= strings.length) {
            if (star) {
                String s = new String(stringBuilder) + "--circular dependency";
                if (!list.contains(s)) {
                    list.add(s);
                }
            } else {
                String s = new String(stringBuilder);
                if (!list.contains(s)) {
                    list.add(s);
                }
            }
            return;
        }
        for (int i = 0; i < strings[n].length(); i++) {
            char ch = strings[n].charAt(i);
            boolean b = false;
            if (set.contains(ch)) {
                star = true;
            } else {
                set.add(ch);
                b = true;
            }
            stringBuilder.append(ch);
            helper(set, strings, n + 1, stringBuilder, star, list);
            if (b) {
                set.remove(ch);
            } else {
                star = false;
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }
}
