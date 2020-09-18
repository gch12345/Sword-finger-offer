package bianlifeng;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] s = sc.next().split(",");
            int[][] arr = new int[s.length / 2][2];
            List<Integer> list = new ArrayList<>();
            boolean b = false;
            for (int i = 0; i < s.length; i++) {
                if (i == 0) {
                    list.add(Integer.parseInt(s[i].substring(2)));
                } else if (s[i] == "") {
                    continue;
                } else if (i == s.length - 1) {
                    list.add(Integer.parseInt(s[i].substring(0, s[i].length() - 2)));
                } else if (b){
                    list.add(Integer.parseInt(s[i].substring(1)));
                    b = false;
                } else {
                    list.add(Integer.parseInt(s[i].substring(0, s[i].length() - 1)));
                    b = true;
                }
            }
            int index = 0;
            for (int i = 0; i < arr.length; i++) {
                arr[i][0] = list.get(index++);
                arr[i][1] = list.get(index++);
            }

//            int[][] arr = {{1,2},{2,3},{3,4},{4,5}};
            String str = removeOneConnection(arr);
            System.out.println(str);;
        }
    }

    public static String removeOneConnection(int[][] edges) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(edges[0][1]);
        int count = edges.length - 1;
        Set<Integer> set = new HashSet<>();
        set.add(edges[0][0]);
        for (int i = 1; i < edges.length; i++) {
            if (edges[i][0] == edges[0][0]) {
                if (set.contains(edges[i][1])) {
                    return "Y";
                }
                queue.add(edges[i][1]);
                count--;
            }
        }
        while (!queue.isEmpty() && count != 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int num = queue.poll();
                set.add(num);
                for (int j = 0; j < edges.length; j++) {
                    if (num == edges[j][0]) {
                        if (set.contains(edges[j][1])) {
                            return "Y";
                        }
                        queue.add(edges[j][1]);
                        count--;
                    }
                }
            }
        }
        if (queue.size() == 1) {
            return "N";
        }
        return "Y";
    }
}
