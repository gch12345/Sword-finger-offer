package operatingSystem.Lock;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class  process {
    private String Name;
    private List<Integer> Need;
    private List<Integer> Allocation;
    private Boolean Finish = false;

    public process(String name, List<Integer> need, List<Integer> allocation) {
        Name = name;
        Need = need;
        Allocation = allocation;
    }
}

public class InitProcess {
    public List<process> Init() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入资源数");
        int num = scanner.nextInt();
        System.out.println("按顺序请输入进程名， 需要的各类资源数, 已分配的各类资源数");
        List<process> list = new ArrayList<>();
        while (scanner.hasNext()) {
            String name = scanner.next();
            List<Integer> need = new ArrayList<>();
            List<Integer> allocation = new ArrayList<>();
            int Num = num;
            while (Num > 0) {
                need.add(scanner.nextInt());
                Num--;
            }
            Num = num;
            while (Num > 0) {
                allocation.add(scanner.nextInt());
                Num--;
            }
            process p = new process(name, need, allocation);
            list.add(p);
        }
        return list;
    }
}
