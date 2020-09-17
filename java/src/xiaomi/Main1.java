package xiaomi;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            Set<Character> set = new HashSet<>();
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (set.contains(ch)) {
                    continue;
                }
                stringBuilder.append(ch);
                set.add(ch);
            }
            System.out.println(stringBuilder.toString());
        }
    }
}
