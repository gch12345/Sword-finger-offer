package nowCoder;

import java.util.ArrayList;
import java.util.Scanner;

public class compose {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int nums = sc.nextInt();
            int num = sc.nextInt();
            boolean star = false;
            if (nums >= num) {
                nums = num - 1;
                star = true;
            }
            helper(nums, num, 0, new ArrayList<>(), 1);
            if (star) {
                System.out.println(num);
            }
        }
    }

    public static void helper(int nums, int num, int sum, ArrayList<Integer> list, int start) {
        if (sum > num) {
            return;
        }
        if (sum == num) {
            for (int i = 0; i < list.size() - 1; i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println(list.get(list.size() - 1));
        }
        for (int i = start; i <= nums; i++) {
            list.add(i);
            helper(nums, num, sum + i, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
