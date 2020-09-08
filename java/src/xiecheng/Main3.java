package xiecheng;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.next();
            Set<String> strings = new HashSet<>();
            helper(str.toCharArray(), 0, strings);
            sc.nextLine();
            String s = sc.nextLine();
            StringBuilder stringBuilder = new StringBuilder();
            s = s + " ";
            String s0 = sc.nextLine();
            for (int i = 0; i < s.length();) {
                int end = i;
                for (int j = i; j < s.length(); j++) {
                    if (s.charAt(j) == ' ' || s.charAt(j) == ',') {
                        end = j;
                        break;
                    }
                }
                String s1 = s.substring(i, end + 1);
                if (strings.contains(s1.substring(0, s1.length() - 1))) {
                    s1 = s0 + s1.charAt(s1.length() - 1);
                }
                stringBuilder.append(s1);
                i = end + 1;
            }
            System.out.println(stringBuilder);
        }
    }

    private static void helper(char[] chars, int n, Set<String> set) {
        if (n >= chars.length) {
            set.add(new String(chars));
            return;
        }
        for (int i = n; i < chars.length; i++) {
            swap(chars, n, i);
            helper(chars, n + 1, set);
            swap(chars, n, i);
        }
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}