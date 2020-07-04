package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class program0 {
    // 01. 判定字符是否唯一
    // 位图
    public boolean isUnique(String astr) {
        long high64 = 0;
        long low64 = 0;
        for (char c : astr.toCharArray()) {
            if (c > 64) {
                long bit = 1L << c - 64;
                if ((bit & high64) > 0) {
                    return false;
                }
                high64 |= bit;
            } else {
                long bit = 1L << c;
                if ((bit & low64) > 0) {
                    return false;
                }
                low64 |= bit;
            }
        }
        return true;
    }

    // 02. 判定是否互为字符重排
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] map = new int[128];
        for (int i = 0; i < s1.length(); i++) {
            map[s1.charAt(i)]++;
            map[s2.charAt(i)]--;
        }
        for (int i = 0; i < 128 ;i++) {
            if (map[i] != 0) {
                return false;
            }
        }
        return true;
    }

    // 格雷编码
    public List<Integer> grayCode0(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = list.size() - 1; j >= 0; j--) {
                list.add(list.get(j) + head);
            }
            head <<= 1;
        }
        return list;
    }

    public static String[] grayCode(int n) {
        String[] Strings = new String[(int)Math.pow(2, n)];
        if (n == 1) {
            Strings[0] = "0";
            Strings[1] = "1";
            return Strings;
        }
        String[] strings = grayCode(n - 1);
        for (int i = 0; i < strings.length; i++) {
            Strings[i] = "0" + strings[i];
            Strings[Strings.length - 1 - i] = "1" + strings[i];
        }
        return Strings;
    }

    public static void main(String[] args) {
        String[] strings = grayCode(3);
        for (String s : strings) {
            System.out.println(s);
        }
    }
}
