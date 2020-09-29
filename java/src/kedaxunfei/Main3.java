package kedaxunfei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            helper(num, list);
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i));
                if (i != list.size() - 1) {
                    System.out.print("*");
                }
            }
        }
    }

    public static void helper(int num, List<Integer> list) {
        boolean b = false;
        for (int i = 2; i < num ; i++) {
            if (num / i == num / (float)i) {
                b = true;
                helper(i, list);
                helper(num / i, list);
                break;
            }
        }
        if (!b) {
            list.add(num);
        }
    }
}
