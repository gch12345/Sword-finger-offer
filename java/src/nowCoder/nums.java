package nowCoder;

import java.util.ArrayList;
import java.util.Scanner;

public class nums {
    static int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            count = 0;
            int num = sc.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < num; i++) {
                list.add(sc.nextInt());
            }
            helper(list, 0, 0);
            System.out.println(count);
        }
    }
    public static void helper(ArrayList<Integer> list, int n, int nums) {
        if (n == list.size() || nums > 40) {
            return;
        }
        for (int i = n; i < list.size(); i++) {
            nums = nums + list.get(n);
            if (nums == 40) {
                count++;
            }
            helper(list, i + 1, nums);
            nums = nums - list.get(n);
        }
    }
}
