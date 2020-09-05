package _58;

import java.util.*;

public class Main {
    public ArrayList<String> findCommonString (ArrayList<ArrayList<String>> values) {
        // write code here
        if (values == null || values.size() == 0) {
            return new ArrayList<>();
        }
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < values.size(); i++) {
            int size = values.get(i).size();
            Set<String> set = new HashSet<>();
            ArrayList<String> list = values.get(i);
            if (list == null || list.size() == 0) {
                return new ArrayList<>();
            }
            for (int j = 0; j < size; j++) {
                String str = list.get(j);
                if (set.contains(str)) {
                    continue;
                }
                set.add(str);
                if (map.containsKey(str)) {
                    map.put(str, map.get(str) + 1);
                } else {
                    map.put(str, 1);
                }
            }
        }
        int size = values.size();
        ArrayList<String> ret = new ArrayList<>();
        for (int i = 0; i < values.get(0).size(); i++) {
            String str = values.get(0).get(i);
            if (map.get(str) == size) {
                ret.add(str);
            }
        }
        return ret;
    }

//    public int question (int a, int b) {
//        // write code here
//        Math.
//    }

    public int translateNum (int num) {
        // write code here
        String str = String.valueOf(num);
        help(str.toCharArray(), 0);
        return count;
    }
    int count = 0;
    public void help(char[] chars, int index) {
        if (index >= chars.length - 1) {
            count++;
            return;
        }
        if (((chars[index] - '0') * 10 + chars[index + 1] - '0') > 25 || chars[index] - '0' == 0) {
            help(chars, index + 1);
        } else {
            help(chars, index + 1);
            help(chars, index + 2);
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.translateNum(101));
    }
}
