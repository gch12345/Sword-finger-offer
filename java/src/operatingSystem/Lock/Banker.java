package operatingSystem.Lock;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Banker {
    private List<Integer> Requset;
    private Integer index;
    public Banker(){
        Requset = new ArrayList<>();
    }

    public Integer getIndex() {
        return index;
    }

    public List<Integer> getRequset() {
        return Requset;
    }

    public boolean TrialDistribution(List<process> list, List<Integer> available) {
        System.out.println("银行家算法");
        Scanner scanner = new Scanner(System.in);
        index = list.size();
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
        return Premise(cur, available);
    }

    private boolean Premise(process cur, List<Integer> available) {
        for (int i = 0; i < cur.Need.size(); i++) {
            if (cur.Need.get(i) < Requset.get(i)) {
                System.out.println("进程 " + cur.Name + " 所需要的资源数已超过它所宣布的最大值");
                return false;
            }
            if (available.get(i) < Requset.get(i)) {
                System.out.println("进程 " + cur.Name + " 尚无足够的资源，" + cur.Name + " 须等待");
                return false;
            }
        }
        return true;
    }
}
