package nowCoder;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class delectSameString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < s2.length(); i++) {
                set.add(s2.charAt(i));
            }
            StringBuffer buff = new StringBuffer();
            for (int i = 0; i < s1.length(); i++) {
                char ch = s1.charAt(i);
                if (!set.contains(ch)) {
                    buff.append(ch);
                }
            }
            System.out.println(buff.toString());
        }
    }
}
