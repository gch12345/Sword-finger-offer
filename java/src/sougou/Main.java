package sougou;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public int numberofprize0 (int a, int b, int c) {
        // write code here
        int[] arr = {a, b, c};
        int min = a;
        for (int i = 0; i < 3; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        int ret = min;
        int count = 0;
        while (true) {
            int star = 0;
            for (int i = 0; i < 3; i++) {
                if (arr[i] - 2 >= min) {
                    count++;
                    arr[i]--;
                    star++;
                }
            }
            if (star == 0) {
                break;
            }
            if (count == 4) {
                ret++;
                count = 0;
                min++;
            }
            if (count == 2 && star == 2) {
                ret++;
                count -= 2;
                min++;
            }
        }
        return ret;
    }

    public int getHouses (int t, int[] xa) {
        // write code here
        int ret = 2;
        for (int i = 0; i < xa.length - 2; i += 2) {
            int a1 = xa[i];
            int b1 = xa[i + 1];
            int a2 = xa[i + 2];
            int b2 = xa[i + 3];
            double count = (a2 - a1) - (b1 / 2.0 + b2 / 2.0);
            if (count > t) {
                ret += 2;
            } else if (count == t) {
                ret++;
            }
        }
        return ret;
    }

    public long getPasswordCount (String password) {
        // write code here
        Set<String> set = new HashSet<>();
        set.add(password);
        for (int i = 0; i < 10; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(i);
            helper(password, 1, stringBuilder, set);
        }
        return set.size() - 1;
    }

    public void helper(String password, int n, StringBuilder str, Set<String> set) {
        if (str.length() == password.length()) {
            set.add(str.toString());
            return;
        }
        int a = password.charAt(n) - '0';
        int b = str.charAt(str.length() - 1) - '0';
        int c = a + b;
        if (c % 2 == 0) {
            helper(password, n + 1, str.append(c / 2), set);
            str.deleteCharAt(str.length() - 1);
        } else {
            helper(password, n + 1, str.append(c / 2), set);
            str.deleteCharAt(str.length() - 1);
            helper(password, n + 1, str.append(c / 2 + 1), set);
            str.deleteCharAt(str.length() - 1);
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
//        System.out.println(main.numberofprize(9, 3, 3));
        int[] arr = {-1,4,5,2};
//        System.out.println(main.getHouses(2, arr));
        System.out.println(main.getPasswordCount("12345"));
    }
}
