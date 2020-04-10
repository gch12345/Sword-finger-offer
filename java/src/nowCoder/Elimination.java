package nowCoder;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//bronken keyoard
public class Elimination {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s1 = sc.nextLine().toLowerCase();
            String s2 = sc.nextLine().toLowerCase();
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < s2.length(); i++) {
                char ch = s2.charAt(i);
                set.add(ch);
            }
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < s1.length(); i++) {
                char ch = s1.charAt(i);
                if (!set.contains(ch)) {
                    stringBuffer.append(ch);
                    set.add(ch);
                }
            }
            System.out.println(stringBuffer.toString().toUpperCase());
        }
    }
}
