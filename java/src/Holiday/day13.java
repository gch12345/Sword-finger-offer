package Holiday;

import java.util.LinkedList;
import java.util.List;

public class day13 {
    List<List<Integer>> lists = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> list = new LinkedList<>();
        lists.add(list);
        helper(nums, 0, list);
        return lists;
    }

    private void helper(int[] nums, int start, List<Integer> list) {
        for (int i = start; i < nums.length; i++) {
            List<Integer> l = new LinkedList<>(list);
            l.add(nums[i]);
            lists.add(l);
            helper(nums, i + 1, l);
        }
    }
}
