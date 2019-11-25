package operatingSystem;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class RRdemo {
    static class process {
        String name;
        int rest;
        int time;
        int arrive;
        int exit;
        process next;

        public process(String name, int time, int arrive, int rest) {
            this.name = name;
            this.time = time;
            this.arrive = arrive;
            this.rest = rest;
        }
    }
    public static process arriveList;
    public static process readyQueue;
    public static int RR;

    public RRdemo(int RR) {
        this.RR = RR;
    }

    public static void ArriveList(Queue<process> queue) {
        while (!queue.isEmpty()) {
            process cur = queue.poll();
            if (arriveList == null) {
                arriveList = cur;
            } else {
                if (cur.arrive <= arriveList.arrive) {
                    cur.next = arriveList;
                    arriveList = cur;
                    continue;
                }
                process node = arriveList;
                process prev = null;
                while (node != null && node.arrive < cur.arrive) {
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
    public static Queue<process> queue = new LinkedList<>();
    public static void ReadyQueue() {
        for (int time = 0;;) {
            while (arriveList == null && readyQueue == null) {
                return;
            }
            while (arriveList != null && time >= arriveList.arrive) {
                process cur = arriveList;
                arriveList = arriveList.next;
                cur.next = null;
                if (readyQueue == null) {
                    readyQueue = cur;
                } else {
                    process readyNode = readyQueue;
                    while (readyNode.next != null) {
                        readyNode = readyNode.next;
                    }
                    readyNode.next = cur;
                }
            }
            if (readyQueue == null) {
                time++;
                continue;
            }
            process cur = readyQueue;
            if (cur.rest <= RR) {
                cur.exit = time + cur.rest;
                queue.add(cur);
                time = time + cur.rest;
                cur.rest = 0;
                cur.exit = time;
                readyQueue = readyQueue.next;
            } else {
                time += RR;
                while (arriveList != null && time >= arriveList.arrive) {
                    process Cur = arriveList;
                    arriveList = arriveList.next;
                    Cur.next = null;
                    if (readyQueue == null) {
                        readyQueue = Cur;
                    } else {
                        process readyNode = readyQueue;
                        while (readyNode.next != null) {
                            readyNode = readyNode.next;
                        }
                        readyNode.next = Cur;
                    }
                }
                cur.rest = cur.rest - RR;
                if (cur.next == null){
                    continue;
                }
                process node = cur;
                while (cur.next != null) {
                    cur = cur.next;
                }
                readyQueue = readyQueue.next;
                node.next = null;
                cur.next = node;
            }
        }
    }

    public static void Printf() {
        while (!queue.isEmpty()) {
            process cur = queue.poll();
            int num = cur.exit - cur.arrive;
            System.out.println("进程名：" + cur.name + " " + "到达时间：" + cur.arrive + " "
                    + "服务时间：" + cur.time + "完成时间：" + cur.exit + " " + "周转时间：" + num);
        }
    }

    public static void main(String[] args) {
        RRdemo rr = new RRdemo(1);
        String name = null;
        Integer time = null;
        Integer arrive = null;
        Queue<process> queue = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNext("#")) {
            name = sc.next();
            time = sc.nextInt();
            arrive = sc.nextInt();
            process cur = new process(name, time, arrive, time);
            queue.add(cur);
        }
        sc.close();
        rr.ArriveList(queue);
        rr.ReadyQueue();
        rr.Printf();
    }
}
