package aiqiyi;

import java.util.*;

class node implements Comparable<node>{
    int a;
    int b;
    int c;
    public node(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        node node = (node) o;
        return a == node.a &&
                b == node.b &&
                c == node.c;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c);
    }

    @Override
    public int compareTo(node o) {
        if (this.a < o.a) {
            return -1;
        } else if (this.a > o.a) {
            return 1;
        } else if (this.b < o.b) {
            return -1;
        } else if (this.b > o.b) {
            return 1;
        } else if (this.c < o.c) {
            return -1;
        } else if (this.c > o.c) {
            return 1;
        }
        return 0;
    }
}

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] s = sc.nextLine().split(" ");
            int[] arr = new int[s.length];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }
            List<node> list = new ArrayList<>();
            Set<node> set = new HashSet<>();
            helper(arr, list, set);
            Collections.sort(list);
            for (int i = 0; i < list.size(); i++) {
                node n = list.get(i);
                System.out.println(n.a + " " + n.b + " " + n.c);
            }
        }
    }

    private static void helper(int[] arr, List<node> list, Set<node> set) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                for (int k = 0; k < arr.length; k++) {
                    if (i == j || i == k || j == k) {
                        continue;
                    }
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        int max = Math.max(arr[i], Math.max(arr[j], arr[k]));
                        int min = Math.min(arr[i], Math.min(arr[j], arr[k]));
                        node n = new node(min, -min - max, max);
                        if (!set.contains(n)) {
                            set.add(n);
                            list.add(n);
                        }
                    }
                }
            }
        }
    }
}