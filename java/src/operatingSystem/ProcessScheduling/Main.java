package operatingSystem.ProcessScheduling;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void menu() {
        System.out.println("************************");
        System.out.println("******1. SJF算法 *******");
        System.out.println("******2. RR算法  *******");
        System.out.println("******0. 退出    *******");
    }
    public static void RR() {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入时间片：");
        int RR = sc.nextInt();
        RRdemo rr = new RRdemo(RR);
        String name = null;
        Integer time = null;
        Integer arrive = null;
        Queue<RRdemo.process> queue = new LinkedList<>();
        System.out.println("输入进程名   到达时间   服务时间，最后以 # 结束");
        while (!sc.hasNext("#")) {
            name = sc.next();
            arrive = sc.nextInt();
            time = sc.nextInt();
            RRdemo.process cur = new RRdemo.process(name, time, arrive, time);
            queue.add(cur);
        }
        rr.ArriveList(queue);
        rr.ReadyList();
        rr.Printf();
    }
    public static void SJF() {
        SJFdemo cur = new SJFdemo();
        Queue<SJFdemo.process> queue = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        String name = null;
        Integer time = null;
        Integer arrive = null;
        System.out.println("输入进程名   到达时间   服务时间，以 # 结束");
        while (!sc.hasNext("#")) {
            name = sc.next();
            arrive = sc.nextInt();
            time = sc.nextInt();
            SJFdemo.process pro = new SJFdemo.process(name, time, arrive);
            queue.add(pro);
        }
        cur.ArriveList(queue);
        cur.ReadyList();
        cur.Print();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            menu();
            int num = sc.nextInt();
            if (num == 1) {
                SJF();
            } else if (num == 2) {
                RR();
            } else if (num == 0) {
                sc.close();
                System.out.println("再见！");
                return;
            }
        }
    }

}
