package _360;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main0 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            int operaNum = sc.nextInt();
            Queue<Integer> queue1 = new LinkedList<>();
            Queue<Integer> queue2 = new LinkedList<>();
            for (int i = 1; i <= num; i += 2) {
                queue1.add(i);
                queue2.add(i + 1);
            }
            for (int i = 0; i < operaNum; i++) {
                int n = sc.nextInt();
                if (n == 1) {
                    queue2.add(queue1.poll());
                    queue1.add(queue2.poll());
                } else {
                    Queue<Integer> temp = queue1;
                    queue1 = queue2;
                    queue2 = temp;
                }
            }
            for (int i = 0; i < num / 2; i++) {
                System.out.print(queue1.poll() + " " + queue2.poll());
            }
        }
    }
}
