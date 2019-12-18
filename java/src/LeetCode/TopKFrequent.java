package LeetCode;

import java.util.*;

public class TopKFrequent {
    class Node implements Comparable<Node>{
        int num;
        int count;

        public Node(int num, int count) {
            this.num = num;
            this.count = count;
        }

        @Override
        public int compareTo(Node o) {
            if (o.count > this.count) {
                return -1;
            } else if (o.count < this.count) {
                return 1;
            } else {
                return 0;
            }
        }
    }
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        Set<Integer> set = map.keySet();
        PriorityQueue<Node> queue = new PriorityQueue<>();
        for (Integer x : set) {
            if (queue.size() >= k) {
                if (map.get(x) > queue.peek().count) {
                    queue.poll();
                    queue.add(new Node(x, map.get(x)));
                }
            } else {
                queue.add(new Node(x, map.get(x)));
            }
        }
        List<Integer> list = new ArrayList<>();
        while (queue.size() > 0) {
            list.add(queue.poll().num);
        }
        return list;
    }
}
