package aiqiyi;

import java.util.Scanner;

public class Main0 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] s = sc.nextLine().split(" ");
            int[] arr = new int[s.length];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }
            int ret = helper(arr);
            System.out.println(ret);
        }
    }

    private static int helper(int[] arr) {
        int count = 1;
        int num = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (count == 0) {
                count = 1;
                num = arr[i];
                continue;
            }
            if (arr[i] == num) {
                count++;
            } else {
                count--;
            }
        }
        return num;
    }
}
