package baidu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int grep = scanner.nextInt();
            for (int i = 0; i < grep; i++) {
                int num = scanner.nextInt();
                int[] arr = new int[num + 1];
                int count = scanner.nextInt();
                for (int j = 0; j < count; j++) {
                    int n = scanner.nextInt();
                    for (int k = 0; k < n; k++) {
                        int l = scanner.nextInt();
                        int r = scanner.nextInt();
                        for (; l <= r; l++) {
                            arr[l]++;
                        }
                    }
                }
                List<Integer> list = new ArrayList<>();
                for (int j = 1; j < arr.length; j++) {
                    if (arr[j] == count) {
                        list.add(j);
                    }
                }
                System.out.println(list.size());
                for (int j = 0; j < list.size(); j++) {
                    System.out.print(list.get(j) + " ");
                }
                System.out.println();
            }
        }
    }
}
