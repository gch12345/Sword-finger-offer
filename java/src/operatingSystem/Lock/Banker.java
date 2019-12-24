package operatingSystem.Lock;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Banker {
    private List<Integer> Requset;
    public Banker(){
        Requset = new ArrayList<>();
    }
    public List<process> TrialDistribution(List<process> list) {
        System.out.println("银行家算法");
        Scanner scanner = new Scanner(System.in);
        int index = list.size();
        while (true) {
            System.out.println("请输入请求进程名");
            String name = scanner.next();
            for (int i = 0; i < index; i++) {
                if (list.get(i).Name.equals(name)) {
                    index = i;
                    break;
                }
            }
            if (index >= list.size()) {
                System.out.println("没有此进程，请重新输入");
            } else {
                break;
            }
        }
        System.out.println("请输入请求向量");
        while (!scanner.hasNext("#")) {
            Requset.add(scanner.nextInt());
        }
//        System.out.println(Requset.isEmpty());
        process cur = list.get(index);
        boolean re = Premise(cur);
        List<process> p = null;
        if (re) {
            p = copy(list, index);
        }
        scanner.close();
        return p;
    }
    public List<Integer> SetAvailable(List<Integer> available) {
        //System.out.println(available.isEmpty());
        List<Integer> Available = new ArrayList<>();
        for (int i = 0; i < Requset.size(); i++) {
            Available.add(available.get(i) - Requset.get(i));
        }
        System.out.println(Available.isEmpty());
        return Available;
    }
    private List<process> copy(List<process> list, int index) {
        List<process> p = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            process cur = list.get(i);
            p.add(new process(cur.Name, cur.Need, cur.Allocation));
        }
        for (int j = 0; j < Requset.size(); j++) {
            process process = p.get(index);
            process.Need.set(j, process.Need.get(j) - Requset.get(j));
            process.Allocation.set(j, process.Allocation.get(j) + Requset.get(j));
        }
        return p;
    }
    private boolean Premise(process cur) {
        for (int i = 0; i < cur.Need.size(); i++) {
            if (cur.Need.get(i) > Requset.get(i)) {
                System.out.println("进程 " + cur.Name + " 所需要的资源数已超过它所宣布的最大值");
                return false;
            }
            if (cur.Allocation.get(i) > Requset.get(i)) {
                System.out.println("进程 " + cur.Name + " 尚无足够的资源，" + cur.Name + " 须等待");
                return false;
            }
        }
        return true;
    }
}
