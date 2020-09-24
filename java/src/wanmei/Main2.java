package wanmei;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.next();
            String[] str = s.split("_");
            StringBuilder ret = new StringBuilder();
            for (int i = 0; i < str.length; i++) {
                StringBuilder cur = new StringBuilder(str[i]);
                cur.reverse();
                ret.append(cur.toString());
                ret.append("_");
            }
            if (ret.length() >= 1) {
                ret.deleteCharAt(ret.length() - 1);
            }
            int i = s.length() - 1;
            while (i >= 0 && s.charAt(i) == '_') {
                ret.append("_");
                i--;
            }
            System.out.println(ret.toString());
        }
    }
}
