package nowCoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class towDelect {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(i);
            }
            int j = 0;
            while (list.size() != 1) {
                j = j + 2;
                if (j >= list.size()) {
                    j = j % list.size();
                }
                list.remove(j);
            }
            System.out.println(list.get(0));
        }
    }
}
