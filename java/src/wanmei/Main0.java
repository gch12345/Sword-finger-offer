package wanmei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
class node implements Comparable<node> {
    int num;
    int count;

    public node(int num, int count) {
        this.num = num;
        this.count = count;
    }

    @Override
    public int compareTo(node o) {
        if (o.num < this.num) {
            return 1;
        } else if (o.num > this.num){
            return -1;
        } else {
            return 0;
        }
    }
}
public class Main0 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int lenA = sc.nextInt();
            int lenB = sc.nextInt();
            List<node> A = new ArrayList<>();
            List<node> B = new ArrayList<>();
            for (int i = 0; i < lenA; i++) {
                node node = new node(sc.nextInt(), sc.nextInt());
                A.add(node);
            }
            for (int i = 0; i < lenB; i++) {
                node node = new node(sc.nextInt(), sc.nextInt());
                B.add(node);
            }
            Collections.sort(A);
            Collections.sort(B);
            int count = 0;
            int ret = 0;
            int j = 0;
            for (int i = 0; i < A.size(); i++) {
                count += B.get(j).count;
                if (A.get(i).num > B.get(j).num) {
                    ret += A.get(i).count * count;
                    j++;
                }
            }
            System.out.println(ret);
        }
    }
}
