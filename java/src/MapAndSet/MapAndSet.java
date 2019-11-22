package MapAndSet;

import java.util.*;

class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }

    @Override
    public boolean equals(Object obj) {
        return this.val == ((Node)obj).val
                && this.random == ((Node)obj).random;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 37 * result + val;
        result = 37 * result + (next == null ? 0 :next.hashCode());
        return result;
    }
};
public class MapAndSet{
    public static void main(String[] args) {
        Map<Node, Integer> map = new HashMap<>();
        map.put(new Node(1, null, null), 2);
        map.put(new Node(1, null, null), 1);
        for (Node x : map.keySet()) {
            System.out.println(map.get(x));
        }
    }
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        for (Integer i : map.keySet()) {
            Integer count = map.get(i);
            if (count == 1) {
                return i;
            }
        }
        return -1;
    }

    // 复制带随机指针的链表
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        for (Node cur = head; cur != null; cur = cur.next) {
            map.put(cur, new Node(cur.val, null, null));
        }
        for (Node cur = head; cur != null; cur = cur.next) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
        }
        return map.get(head);
    }
    //宝石与石头
    public int numJewelsInStones(String J, String S) {
        int result = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < J.length(); i++) {
            set.add(J.charAt(i));
        }
        for (int i = 0; i < S.length(); i++) {
            if (set.contains(S.charAt(i))) {
                result++;
            }
        }
        return result;
    }
    //坏键盘打字
    public static void Main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String expextString = null;
        String actualString = null;
        while (sc.hasNext()) {
            expextString = sc.next().toUpperCase();
            actualString = sc.next().toUpperCase();
        }
        Set<Character> actualSet = new HashSet<>();
        for (int i = 0; i < actualString.length(); i++) {
            actualSet.add(actualString.charAt(i));
        }
        Set<Character> printfSet = new HashSet<>();
        for (int i = 0; i < expextString.length(); i++) {
            char c = expextString.charAt(i);
            if (!actualSet.contains(c)) {
                if (!printfSet.contains(c)) {
                    System.out.print(c);
                    printfSet.add(c);
                }
            }
        }
    }
    //前K个高频单词
    public List<String> topKFrequent(String[] words, int k) {
        List<String> list = new ArrayList<>();
        if (k <= 0) {
            return list;
        }
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }
        Set<String> set = map.keySet();
        for (String string : set) {
            list.add(string);
        }
        Collections.sort(list, new myComp(map));
        return list.subList(0, k);
    }
    class myComp implements Comparator<String> {
        private Map<String, Integer> map;
        public myComp(Map<String, Integer> map) {
            this.map = map;
        }
        @Override
        public int compare(String o1, String o2) {
            int count1 = map.get(o1);
            int count2 = map.get(o2);
            if (count1 == count2) {
                return o1.compareTo(o2);
            }
            return count2 - count1;
        }
    }
}
