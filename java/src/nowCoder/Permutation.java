package nowCoder;

import java.util.*;

public class Permutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num =sc.nextInt();
            int[] nums = new int[num];
            for (int i = 0; i < num; i++) {
                nums[i] = sc.nextInt();
            }
            Stack<Integer> stack = new Stack<>();
            helper(nums, stack, 0);
            int size = ret.size();
            for (int i = 0; i < size; i++) {
                System.out.println(ret.poll());
            }
        }
    }

    static PriorityQueue<String> ret = new PriorityQueue<>(Comparator.naturalOrder());
    static LinkedList<Integer> list = new LinkedList<>();
    public static void helper(int[] nums, Stack<Integer> stack, int n) {
        if (list.size() == nums.length) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < nums.length; i++) {
                stringBuffer.append(list.get(i));
                if (i != nums.length - 1) {
                    stringBuffer.append(' ');
                }
            }
            ret.add(stringBuffer.toString());
            return;
        }
        if (!stack.isEmpty()) {
            list.add(stack.pop());
            helper(nums, stack, n);
            int num = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            stack.push(num);
        }
        if (n < nums.length) {
            stack.push(nums[n]);
            helper(nums, stack, n + 1);
            stack.pop();
        }
    }
}
