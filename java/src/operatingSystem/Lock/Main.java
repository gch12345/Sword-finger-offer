package operatingSystem.Lock;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        InitProcess initProcess = new InitProcess();
        initProcess.Init();
        Banker banker = new Banker();
        List<process> list = banker.TrialDistribution(initProcess.getList());
        Safety safety = new Safety(banker.SetAvailable(initProcess.getAvailable()));
        if (list != null) {
            Boolean re = safety.distribution(list);
            if (re) {
                System.out.print("安全序列为：");
                for (String x : safety.getSequence()) {
                    System.out.print(x + " ");
                }
            }
        }
    }
}
