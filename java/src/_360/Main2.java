package _360;

import java.util.Scanner;

public class Main2 {
    static class node {
        int val;
        node next;
        public node(int val) {
            this.val = val;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            int operaNum = sc.nextInt();
            node head = null;
            node tail = null;
            for (int i = 1; i <= num; i++) {
                if (head == null) {
                    head = new node(i);
                    tail = head;
                } else {
                    tail.next = new node(i);
                    tail = tail.next;
                }
            }
            for (int i = 0; i < operaNum; i++) {
                int n = sc.nextInt();
                if (n == 1) {
                    node cur = head;
                    head = head.next;
                    tail.next = cur;
                    tail = tail.next;
                } else {
                    node cur = head;
                    for (int j = 0; j < num / 2; j++) {
                        int temp = cur.val;
                        cur.val = cur.next.val;
                        cur.next.val = temp;
                        cur = cur.next.next;
                    }
                }
            }
            for (int i = 0; i < num; i++) {
                System.out.print(head.val + " ");
                head = head.next;
            }
        }
    }
}
