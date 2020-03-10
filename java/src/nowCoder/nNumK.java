package nowCoder;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class nNumK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            int k = str.charAt(str.length() - 1) - '0';
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < str.length() - 2; i++) {
                char Str = str.charAt(i);
                if (Str == ' ') {
                    continue;
                }
                boolean bool = false;
                if (Str == '-') {
                    bool = true;
                    i++;
                    Str = str.charAt(i);
                }
                int count = 0;
                while (' ' != Str) {
                    count = count * 10 + Str - '0';
                    i++;
                    Str = str.charAt(i);
                }
                if (bool) {
                    count = -count;
                }
                list.add(count);
            }
            list.sort(Comparator.naturalOrder());
            for (int i = 0; i < k; i++) {
                System.out.printf("%d ", list.get(i));
            }
        }
    }
}
