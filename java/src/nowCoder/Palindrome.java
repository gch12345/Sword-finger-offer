package nowCoder;

import java.util.Scanner;

public class Palindrome {
    public void Palindrome_number() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s1 = scanner.next();
            String s2 = scanner.next();
            helper(s1, s2);
        }
    }
    private int helper(String s1, String s2) {
        int ret = 0;
        for (int i = 0; i < s1.length() + 1; i++) {
            StringBuffer string = new StringBuffer();
            string.append(s1.substring(0, i));
            string.append(s2);
            string.append(s1.substring(i));
            if (is_palindrome(string.toString())) {
                ret++;
            }
        }
        return ret;
    }
    private boolean is_palindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Palindrome p = new Palindrome();
        p.Palindrome_number();
    }
}
