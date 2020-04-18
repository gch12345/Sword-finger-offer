package nowCoder;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class deleteSame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String src = sc.nextLine();
            String dic = sc.nextLine();
            StringBuilder stringBuilder = new StringBuilder();
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < dic.length(); i++) {
                set.add(dic.charAt(i));
            }
            for (int i = 0; i < src.length(); i++) {
                char ch = src.charAt(i);
                if (!set.contains(ch)) {
                    stringBuilder.append(ch);
                }
            }
            System.out.println(stringBuilder.toString());
        }
    }
}
