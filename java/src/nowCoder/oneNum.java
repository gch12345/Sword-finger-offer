package nowCoder;

import java.util.Scanner;

public class oneNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            int[] nums = new int[num];
            int star = 0;
            for (int i = 0; i < num; i++) {
                nums[i] = sc.nextInt();
                star = star ^ nums[i];
            }
            int bit = 0;
            while (star != 0) {
                if ((star & 1) == 1) {
                    break;
                }
                bit++;
                star = star >> 1;
            }
            int bit0 = 0;
            int bit1 = 0;
            for (int i = 0; i < num; i++) {
                if (((nums[i] >> bit) & 1) == 0) {
                    bit0 = bit0 ^ nums[i];
                } else {
                    bit1 = bit1 ^ nums[i];
                }
            }
            int max = Math.max(bit0, bit1);
            int min = Math.min(bit0, bit1);
            System.out.println(min + " " + max);
        }
    }
}
