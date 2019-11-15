package Heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class TopK {
    static class Pair implements Comparable<Pair>{
        int num1;
        int num2;
        int sum;

        public Pair(int num1, int num2) {
            this.num1 = num1;
            this.num2 = num2;
            this.sum = num1 + num2;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.sum < o.sum) {
                return 1;
            }
            if (this.sum > o.sum) {
                return -1;
            }
            return 0;
        }
    }
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ret = new ArrayList<>();
        if (k < 1) {
            return ret;
        }
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        for (int i = 0; i < nums1.length && i < k; i++) {
            for (int j = 0; j < nums2.length && j < k; j++) {
                if (queue.size() == k && nums1[i] + nums2[j] > queue.peek().sum ) {
                    continue;
                }
                queue.offer(new Pair(nums1[i], nums2[j]));
                if (queue.size() > k) {
                    queue.poll();
                }
            }
        }
        while (!queue.isEmpty()) {
            Pair cur = queue.poll();
            List<Integer> tmp = new ArrayList<>();
            tmp.add(cur.num1);
            tmp.add(cur.num2);
            ret.add(0, tmp);
        }
        return ret;
    }
}
