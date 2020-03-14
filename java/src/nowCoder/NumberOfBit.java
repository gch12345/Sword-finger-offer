package nowCoder;

import java.util.Scanner;

public class NumberOfBit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String string = sc.next();
            int[] arr = new int[10];
            for (int i = 0; i < string.length(); i++) {
                int num = string.charAt(i) - '0';
                arr[num]++;
            }
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != 0) {
                    System.out.println(i + ":" + arr[i]);
                }
            }
        }
    }

}
