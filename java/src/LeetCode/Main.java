package LeetCode;

import org.junit.Test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    class desk implements Comparable<desk>{
        int max;
        @Override
        public int compareTo(desk o) {
            if (o.max < this.max) {
                return 1;
            } else if (o.max == this.max) {
                return 0;
            } else {
                return -1;
            }
        }
    }
    class customer implements Comparable<customer>{
        int num;
        int money;

        @Override
        public int compareTo(customer o) {
            if (o.money > this.money) {
                return 1;
            } else if (o.money == this.money) {
                return 0;
            } else {
                return -1;
            }
        }
    }
    public int Restaurant() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedList<desk> Desk = new LinkedList<>();
        int m = sc.nextInt();
        LinkedList<customer> Cus = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            desk d = new desk();
            d.max = sc.nextInt();
            Desk.add(d);
        }
        Collections.sort(Desk);
        for (int i = 0; i < m; i++) {
            customer c = new customer();
            c.num = sc.nextInt();
            c.money = sc.nextInt();
            if (c.num <= Desk.get(Desk.size() -1).max)
                Cus.add(c);
        }
        Collections.sort(Cus);
        int ret = 0;
        while (!Cus.isEmpty() && !Desk.isEmpty()) {
            customer c = Cus.get(0);
            if (c.num > Desk.get(Desk.size() -1).max) {
                Cus.remove(0);
                continue;
            }
            int left = 0;
            int right = Desk.size() - 1;
            while (left < right) {
                int mid = (right - left) / 2 + left;
                if (Desk.get(mid).max < c.num) {
                    left = mid + 1;
                } else if (Desk.get(mid).max > c.num) {
                    right = mid - 1;
                } else {
                    break;
                }
            }
            if (left < Desk.size()) {
                ret = ret + c.money;
                Desk.remove(left);
            }
            Cus.remove(0);
        }
        return ret;
    }

    public static void main(String[] args) {
        Main m = new Main();
        System.out.println(m.Restaurant());
    }
}
