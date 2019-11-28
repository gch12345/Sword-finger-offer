package operatingSystem;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class RRdemo {
     static class process {
        String name; // 进程名
        int rest;   // 剩余服务时间
        int time;   // 服务时间
        int arrive; // 到达时间
        int exit;   // 完成时间
        process next;

        public process(String name, int time, int arrive, int rest) {
            this.name = name;
            this.time = time;
            this.arrive = arrive;
            this.rest = rest;
        }
    }
    public  process arriveList;
    public  process readyList;
    public  int RR;

    public RRdemo(int RR) {
        this.RR = RR;
    }

    public void ArriveList(Queue<process> queue) {
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
    public Queue<process> queue = new LinkedList<>();
    public void ReadyList() {
        for (int time = 0;;) {
            while (arriveList == null && readyList == null) {
                return;
            }
            load(time);
            if (readyList == null) {
                time++;
                continue;
            }
            process cur = readyList;
            if (cur.rest <= RR) {
                cur.exit = time + cur.rest;
                queue.add(cur);
                time = time + cur.rest;
                cur.rest = 0;
                cur.exit = time;
                readyList = readyList.next;
            } else {
                time += RR;
                load(time);
                cur.rest = cur.rest - RR;
                if (cur.next == null){
                    continue;
                }
                process node = cur;
                while (cur.next != null) {
                    cur = cur.next;
                }
                readyList = readyList.next;
                node.next = null;
                cur.next = node;
            }
        }
    }

    public void load(int time) {
        while (arriveList != null && time >= arriveList.arrive) {
            process cur = arriveList;
            arriveList = arriveList.next;
            cur.next = null;
            if (readyList == null) {
                readyList = cur;
            } else {
                process readyNode = readyList;
                while (readyNode.next != null) {
                    readyNode = readyNode.next;
                }
                readyNode.next = cur;
            }
        }
    }

    public void Printf() {
        while (!queue.isEmpty()) {
            process cur = queue.poll();
            int num = cur.exit - cur.arrive;
            System.out.println("进程名：" + cur.name + " " + "到达时间：" + cur.arrive + " "
                    + "服务时间：" + cur.time + "完成时间：" + cur.exit + " " + "周转时间：" + num);
        }
    }

    public void main(String[] args) {
        RRdemo rr = new RRdemo(4);
        String name = null;
        Integer time = null;
        Integer arrive = null;
        Queue<process> queue = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNext("#")) {
            name = sc.next();
            arrive = sc.nextInt();
            time = sc.nextInt();
            process cur = new process(name, time, arrive, time);
            queue.add(cur);
        }
        sc.close();
        rr.ArriveList(queue);
        rr.ReadyList();
        rr.Printf();
    }
}
