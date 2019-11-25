package operatingSystem;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SJFdemo {
    static class process {
        String name;
        int time;
        process next;

        public process(String name, int time) {
            this.name = name;
            this.time = time;
        }
    }
    public static process head = null;

    public static void init(Queue<process> queue) {
        while (!queue.isEmpty()) {
            process cur = queue.poll();
            if (head == null) {
                head = cur;
            } else {
                if (cur.time <= head.time) {
                    cur.next = head;
                    head = cur;
                    continue;
                }
                process node = head;
                process prev = null;
                while (node != null && node.time < cur.time) {
                    prev = node;
                    node = node.next;
                }
                prev.next = cur;
                if (node != null) {
                    cur.next = node;
                }
            }
        }
    }

    public static void Print() {
        int arrive = 0;
        while (head != null) {
            int num = arrive;
            arrive += head.time;
            System.out.println("进程名：" + head.name + " " + "服务时间：" + head.time + " " + "到达时间：" + num + " " + "完成时间：" + arrive);
            head = head.next;
        }
    }
    public static void main(String[] args) {
        SJFdemo cur = new SJFdemo();
        Queue<process> queue = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        String name = null;
        Integer time = null;
        while (!sc.hasNext("#")) {
            name = sc.next();
            time = sc.nextInt();
            process pro = new process(name, time);
            queue.add(pro);
        }
        sc.close();
        //queue.add(new process("A", 10));
        //queue.add(new process("B", 1));
        //queue.add(new process("C", 2));
        //queue.add(new process("D", 5));
        cur.init(queue);
        cur.Print();
    }
}
