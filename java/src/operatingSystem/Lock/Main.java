package operatingSystem.Lock;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InitProcess initProcess = null;
        while (true) {
            menu();
            Scanner scanner = new Scanner(System.in);
            int select = scanner.nextInt();
            if (select == 0) {
                System.out.println("再见！！");
                return;
            }
            if (select == 1) {
                System.out.println("初始化");
                initProcess = new InitProcess();
                initProcess.Init();
            }
            Banker banker = new Banker();
            Copy copy = new Copy();
            List<process> list = null;
            Safety safety = null;
            if (select == 2) {
                if (banker.TrialDistribution(initProcess.getList(), initProcess.getAvailable())) {
                    list = copy.copy(initProcess.getList(), banker.getIndex(), banker.getRequest());
                }
                safety  = new Safety(copy.SetAvailable(initProcess.getAvailable(), banker.getRequest()));
            }
            if (select == 3) {
                list = copy.copy(initProcess.getList());
                safety = new Safety(initProcess.getAvailable());
            }
            if (select == 4) {
                initProcess.Printf();
            }
            if (list != null && list.size() == initProcess.getList().size()) {
                Boolean re = safety.distribution(list);
                if (re) {
                    //initProcess.setAvailable(safety.getWork());
                    initProcess.setAvailable(copy.SetAvailable(initProcess.getAvailable(), banker.getRequest()));
                    initProcess.setList(list);
                    if (select == 2) {
                        System.out.println("适分配成功");
                    }
                    System.out.print("安全序列为：");
                    for (String x : safety.getSequence()) {
                        System.out.print(x + " ");
                    }
                    System.out.println();
                } else {
                    System.out.println("适分配失败, 没有找到安全序列，系统处于不安全状态");
                }
            }
        }
    }
    private static void menu() {
        System.out.println("------  避免死锁  -----");
        System.out.println("------1.初始化资源-----");
        System.out.println("------2.银行家算法-----");
        System.out.println("------3.安全性算法-----");
        System.out.println("------4.打印各矩阵-----");
        System.out.println("------  0.退出    -----");

    }
}
