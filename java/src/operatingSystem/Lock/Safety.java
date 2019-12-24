package operatingSystem.Lock;

import java.util.ArrayList;
import java.util.List;

public class Safety {
    private List<Integer> Work;
    private List<String> Sequence;

    public Safety(List<Integer> work) {
        Sequence = new ArrayList<>();
        Work = new ArrayList<>();
        for (int i = 0; i < work.size(); i++) {
            Work.add(work.get(i));
        }
    }

    public List<String> getSequence() {
        return Sequence;
    }

    public Boolean distribution(List<process> p) {
        while (true) {
            int size = Sequence.size();
            int i = 0;
            while (i < p.size()) {
                if (!p.get(i).Finish) {
                    find(p.get(i));
                }
                i++;
                if (helper(p)) {
                    return true;
                }
            }
            if (size == Sequence.size()) {
                return false;
            }
        }
    }
    private void find(process p) {
        for (int i = 0; i < p.Need.size(); i++) {
            if (p.Need.get(i) > Work.get(i)) {
                return;
            }
        }
        Sequence.add(p.Name);
    }
    private Boolean helper(List<process> p) {
        for (int i = 0; i < p.size(); i++) {
            if (!p.get(i).Finish) {
                return false;
            }
        }
        return true;
    }
}
