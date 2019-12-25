package operatingSystem.Lock;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Banker {
    private List<Integer> Request;
    private Integer index;
    public Banker(){
        Request = new ArrayList<>();
    }

    public Integer getIndex() {
        return index;
    }

    public List<Integer> getRequest() {
        return Request;
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
        int Num = available.size();
        while (Num > 0) {
            int num = scanner.nextInt();
            if (num >= 0) {
                Request.add(num);
                Num--;
            } else {
                System.out.println("输入不合法，请重新输入");
            }
        }
//        System.out.println(Request.isEmpty());
        process cur = list.get(index);
        boolean re = Premise(cur, available);
        if (re) {
            for (int i = 0; i < Request.size(); i++) {
                //System.out.println(available.get(i));
                available.set(i, available.get(i) - Request.get(i));
            }
        }
        return re;
    }

    private boolean Premise(process cur, List<Integer> available) {
        for (int i = 0; i < cur.Need.size(); i++) {
            if (cur.Need.get(i) < Request.get(i)) {
                System.out.println("进程 " + cur.Name + " 所需要的资源数已超过它所宣布的最大值");
                return false;
            }
            if (available.get(i) < Request.get(i)) {
                System.out.println("进程 " + cur.Name + " 尚无足够的资源，" + cur.Name + " 须等待");
                return false;
            }
        }
        return true;
    }
}
