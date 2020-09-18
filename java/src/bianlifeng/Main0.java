package bianlifeng;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main0 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int money = sc.nextInt();
            String[] s = sc.next().split(",");
            int[] arr = new int[s.length];
            count = 0;
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }
            buy(money, arr, 0, new ArrayList<>(), 0);
//            for (int i = 0; i < arr.length; i++) {
//                List<Integer> list = new ArrayList<>();
//                list.add(arr[i]);
//                buy(money, arr, arr[i], list, i);
//            }
            System.out.println(count);
        }
    }
    static int count = 0;
    public static void buy(int money, int[] items, int curNum, List<Integer> list, int index) {
        if (curNum == money) {
            count++;
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
            return;
        }
        if (curNum > money) {
            return;
        }
        for (int i = index; i < items.length; i++) {
            list.add(items[i]);
            buy(money, items, curNum + items[i], list, i);
            list.remove(list.size() - 1);
        }
    }
}
