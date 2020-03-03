package nowCoder;

import java.util.Scanner;

public class longString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            helper(s);
        }
    }
    public static void helper (String s) {
        int star = 0;
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int count = 0;
            int start = i;
            while (c >= '0' && c <= '9') {
                count++;
                i++;
                if (i >= s.length())
                    break;
                c = s.charAt(i);
            }
            if (count > len) {
                star = start;
                len = count;
            }
        }
        System.out.println(s.substring(star, star + len));
    }
}
