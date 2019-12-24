package operatingSystem.Lock;

import java.util.ArrayList;
import java.util.List;

public class Copy {
    public List<process> copy(List<process> list) {
        List<process> p = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            process cur = list.get(i);
            p.add(new process(cur.Name, cur.Need, cur.Allocation));
        }
        return p;
    }
    public List<Integer> SetAvailable(List<Integer> available, List<Integer> Requset) {
        //System.out.println(available.isEmpty());
        List<Integer> Available = new ArrayList<>();
        for (int i = 0; i < Requset.size(); i++) {
            Available.add(available.get(i) - Requset.get(i));
        }
        return Available;
    }
    public List<process> copy(List<process> list, int index, List<Integer> Requset) {
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
}
