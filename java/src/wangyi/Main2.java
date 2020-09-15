package wangyi;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            String s1 = scanner.next();
            String s2 = scanner.next();
            char[] chars = s2.toCharArray();
            List<String> list = new LinkedList<>();
            helper(chars, list, 0, s1);
            System.out.println(list.get(0));
        }
    }

    public static void helper(char[] chars, List<String> list, int index, String  s1) {
        if (index >= chars.length) {
            String s = new String(chars);
            if (s.compareTo(s1) > 0) {
                if (list.isEmpty() || list.get(0).compareTo(s) > 0) {
                    list.add(0, s);
                }
            }
            return;
        }
        for (int i = index; i < chars.length; i++) {
            swap(chars, index, i);
            String s = new String(chars, 0, index);
            if (s.compareTo(s1.substring(0, index + 1)) > 0) {
                helper(chars, list, index + 1, s1);
            }
            swap(chars, index, i);
        }
    }

    public static void swap(char[] chars, int i, int j) {
        char c = chars[i];
        chars[i] = chars[j];
        chars[j] = c;
    }
}
