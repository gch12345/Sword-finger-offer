package operatingSystem;

import java.util.*;

public class SJFdemo{
    static class process implements Comparable<process> {
        String name;
        int time;
        int arrive;
        int exit;
        process next;

        @Override
        public int compareTo(process o) {
            return this.time - o.time;
        }
        public process(String name, int time, int arrive) {
            this.name = name;
            this.time = time;
            this.arrive = arrive;
        }
    }
    public static process arriveList = null;
    public static List<process> readyList = new ArrayList<>();
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
    static Queue<process> queue = new LinkedList<>();
    public static void ReadyList() {
        for (int time = 0;;) {
            if (arriveList == null && readyList.isEmpty()) {
                return;
            }
            load(time);
            if (readyList.isEmpty()) {
                time++;
                continue;
            }
            process cur = readyList.get(0);
            readyList.remove(0);
            time += cur.time;
            cur.exit = time;
            queue.add(cur);
        }
    }
    private static void load(int time) {
        while (arriveList != null && time >= arriveList.arrive) {
            process cur = arriveList;
            arriveList = arriveList.next;
            cur.next = null;
            readyList.add(cur);
            Collections.sort(readyList);
        }
    }
    public static void Print() {
        while (!queue.isEmpty()) {
            process cur = queue.poll();
            int num = cur.exit - cur.arrive;
            System.out.println("进程名：" + cur.name + " " + "到达时间：" + cur.arrive + " "
                    + "服务时间：" + cur.time + "完成时间：" + cur.exit + " " + "周转时间：" + num);
        }
    }
    public static void main(String[] args) {
        SJFdemo cur = new SJFdemo();
        Queue<process> queue = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        String name = null;
        Integer time = null;
        Integer arrive = null;
        while (!sc.hasNext("#")) {
            name = sc.next();
            arrive = sc.nextInt();
            time = sc.nextInt();
            process pro = new process(name, time, arrive);
            queue.add(pro);
        }
        sc.close();
        cur.ArriveList(queue);
        cur.ReadyList();
        cur.Print();
    }
}
