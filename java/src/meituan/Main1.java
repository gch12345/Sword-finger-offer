package meituan;

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            int sol = sc.nextInt();
            List<List<Integer>> list = new ArrayList<>();
            for (int i = 0; i < sol; i++) {
                int j = 0;
                int a = sc.nextInt();
                int b = sc.nextInt();
                for (; j < list.size(); j++) {
                    List<Integer> integerList = list.get(j);
                    if (integerList.contains(a) && integerList.contains(b)) {
                        break;
                    }
                    if (integerList.contains(a)) {
                        if (a == b) {
                            break;
                        }
                        integerList.add(b);
                        break;
                    }
                    if (integerList.contains(b)) {
                        if (a == b) {
                            break;
                        }
                        integerList.add(a);
                        break;
                    }
                }
                if (j == list.size()) {
                    List<Integer> list1 = new ArrayList<>();
                    list1.add(a);
                    if (a != b) {
                        list1.add(b);
                    }
                    list.add(list1);
                }
            }
            System.out.println(list.size());
            for (int i = 0; i < list.size(); i++) {
                List<Integer> list1 = list.get(i);
                Collections.sort(list1);
            }
            list.sort(new Comparator<List<Integer>>() {
                @Override
                public int compare(List<Integer> o1, List<Integer> o2) {
                    if (o1.get(0) < o2.get(0)) {
                        return -1;
                    }
                    return 1;
                }
            });
            for (int i = 0; i < list.size(); i++) {
                List<Integer> list1 = list.get(i);
                for (int j = 0; j < list1.size(); j++) {
                    if (j == list1.size() - 1) {
                        System.out.println(list1.get(j));
                    } else {
                        System.out.print(list1.get(j) + " ");
                    }
                }
            }
        }
    }
}
