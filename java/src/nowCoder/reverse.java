package nowCoder;

import java.util.Scanner;

public class reverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            char[] chars = str.toCharArray();
            for (int i = 0; i < chars.length;) {
                while (i < chars.length &&chars[i] == ' ') {
                    i++;
                }
                int start = i;
                int end = i;
                while (end < chars.length &&chars[end] != ' ') {
                    end++;
                }
                i = end;
                end--;
                if (start < chars.length) {
                    while (start < end) {
                        char ch = chars[start];
                        chars[start] = chars[end];
                        chars[end] = ch;
                        start++;
                        end--;
                    }
                }
            }
            int start = 0;
            int end = chars.length - 1;
            while (start < end) {
                char ch = chars[start];
                chars[start] = chars[end];
                chars[end] = ch;
                start++;
                end--;
            }
            System.out.println(new String(chars));
        }
    }
}
