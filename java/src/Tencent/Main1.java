package Tencent;

import java.util.*;

public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String string = sc.next();
            Set<String> set = new HashSet<>();
            help(string, set);
            for (String s : set) {
                System.out.println(s);
            }
            List<String> list = new ArrayList<>(set);
            Collections.sort(list, new Comparator<String>(){
                @Override
                public int compare(String o1, String o2) {
                    int i = 0;
                    while (i < o1.length() && i < o2.length()) {
                        if (o1.charAt(i) == o2.charAt(i)) {
                            i++;
                        } else if (o1.charAt(i) < o2.charAt(i)) {
                            return -1;
                        } else {
                            return 1;
                        }
                    }
                    if (o1.length() < o2.length()) {
                        return -1;
                    } else {
                        return 1;
                    }
                }
            });
            System.out.println(list.get(sc.nextInt() - 1));
        }
    }

    private static void help(String str, Set<String> set) {
        for (int i = 1; i <= str.length(); i++) {
            for (int j = 0; j < str.length() - i + 1; j++) {
                set.add(str.substring(j, j + i));
            }
        }
    }
}