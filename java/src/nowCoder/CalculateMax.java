package nowCoder;

import java.util.Scanner;

public class CalculateMax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            String[] string = str.split(",");
            int[] arr = new int[string.length];
            for (int i = 0; i < string.length; i++) {
                arr[i] = Integer.valueOf(string[i]);
            }
            int ret = calculateMax(arr);
            System.out.println(ret);
        }
    }
    public static int calculateMax(int[] prices) {
        if (prices.length <= 0) {
            return 0;
        }
        int firstBuy = Integer.MIN_VALUE, firstSell = 0;
        int secondBuy = Integer.MIN_VALUE, secondSell = 0;
        for (int price : prices) {
            firstBuy = Math.max(firstBuy, -price);
            firstSell = Math.max(firstSell, firstBuy + price);
            secondBuy = Math.max(secondBuy, firstSell - price);
            secondSell = Math.max(secondSell, secondBuy + price);
        }
        return secondSell;
    }
}
