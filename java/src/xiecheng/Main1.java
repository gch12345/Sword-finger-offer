package xiecheng;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.next();
            Set<String> strings = new HashSet<>();
            helper(str.toCharArray(), 0, strings);
            sc.nextLine();
            String[] strs = sc.nextLine().split(" ");
            StringBuilder stringBuilder = new StringBuilder();
            str = sc.next();
            for (int i = 0; i < strs.length; i++) {
                String[] s = strs[i].split(",");
                for (int j = 0; j < s.length; j++) {
                    if (strings.contains(s[j])) {
                        stringBuilder.append(str);
                    } else {
                        stringBuilder.append(s[j]);
                    }
                    if (j != s.length - 1) {
                        stringBuilder.append(",");
                    }
                }
                if (i != strs.length - 1) {
                    stringBuilder.append(" ");
                }
            }
            System.out.println(stringBuilder.toString());
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
