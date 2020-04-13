package nowCoder;

import java.util.Scanner;

public class StatisLetters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            int[] map = new int[26];
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (ch >= 'A' && ch <= 'Z') {
                    map[ch - 'A']++;
                }
            }
            for (int i = 0; i < map.length; i++) {
                char ch = (char) (i + 'A');
                System.out.println(ch + ":" + map[i]);
            }
        }
    }
}
