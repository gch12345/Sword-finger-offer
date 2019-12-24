package operatingSystem.Lock;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            menu();
            Scanner scanner = new Scanner(System.in);
            int select = scanner.nextInt();
            if (select == 0) {
                System.out.println("再见！！");
                return;
            }
            InitProcess initProcess = new InitProcess();
            initProcess.Init();
            Banker banker = new Banker();
            Copy copy = new Copy();
            List<process> list = null;
            Safety safety = null;
            if (select == 1) {
                if (banker.TrialDistribution(initProcess.getList(), initProcess.getAvailable())) {
                    list = copy.copy(initProcess.getList(), banker.getIndex(), banker.getRequset());
                }
                Safety s = new Safety(copy.SetAvailable(initProcess.getAvailable(), banker.getRequset()));
                safety = s;
            }
            if (select == 2) {
                list = copy.copy(initProcess.getList());
                Safety s = new Safety(initProcess.getAvailable());
                safety = s;
            }
            if (list != null && list.size() == initProcess.getList().size()) {
                Boolean re = safety.distribution(list);
                if (re) {
                    System.out.print("安全序列为：");
                    for (String x : safety.getSequence()) {
                        System.out.print(x + " ");
                    }
                    System.out.println();
                }
            } else {
                System.out.println("没有找到安全序列，系统处于不安全状态");
            }
        }
    }
    private static void menu() {
        System.out.println("------  避免死锁  -----");
        System.out.println("------1.银行家算法-----");
        System.out.println("------2.安全性算法-----");
        System.out.println("------  0.退出    -----");

    }
}
