package operatingSystem.Lock;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class  process {
    String Name;
    List<Integer> Need;
    List<Integer> Allocation;
    Boolean Finish = false;

    public process(String name, List<Integer> need, List<Integer> allocation) {
        Name = name;
        Need = need;
        Allocation = allocation;
    }
}

public class InitProcess {
    private List<process> list;
    private List<Integer> Available;
    public InitProcess() {
        list = new ArrayList<>();
        Available = new ArrayList<>();
    }

    public List<Integer> getAvailable() {
        return Available;
    }

    public void setList(List<process> list) {
        this.list = list;
    }

    public void setAvailable(List<Integer> available) {
        Available = available;
    }

    public List<process> getList() {
        return list;
    }

    public void Init() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入资源数");
        int num = scanner.nextInt();
        System.out.println("请输入可利用资源向量");
        int NUM = num;
        while (NUM > 0) {
            Available.add(scanner.nextInt());
            NUM--;
        }
        System.out.println("按顺序请输入进程名，已分配的各类资源数，需要的各类资源数，以 # 结束");
        while (!scanner.hasNext("#")) {
            String name = scanner.next();
            List<Integer> need = new ArrayList<>();
            List<Integer> allocation = new ArrayList<>();
            int Num = num;
            while (Num > 0) {
                allocation.add(scanner.nextInt());
                Num--;
            }
            Num = num;
            while (Num > 0) {
                need.add(scanner.nextInt());
                Num--;
            }
            process p = new process(name, need, allocation);
            list.add(p);
        }
    }
    public void Printf() {
        for (int i = 0; i < list.size(); i++) {
            process cur = list.get(i);
            System.out.print("进程名:" + cur.Name + " ");
            System.out.print("Allocation矩阵 [");
            for (int j = 0; j < cur.Allocation.size(); j++) {
                System.out.print(cur.Allocation.get(j) + " ");
            }
            System.out.print("] ");
            System.out.print("Need矩阵 [");
            for (int k = 0; k < cur.Need.size(); k++) {
                System.out.print(cur.Need.get(k) + " ");
            }
            System.out.println("]");
        }
    }
}
