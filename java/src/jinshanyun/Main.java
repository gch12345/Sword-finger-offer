package jinshanyun;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
1
1 1 1
1 1 2 1 1
1 1 2 3 2 1 1
1 1 2 3 5 3 2 1 1
1 1 2 3 5 8 5 3 2 1 1
1 1 2 3 5 8 13 8 5 3 2 1 1
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            list.add(1);
            int num = sc.nextInt();
            for (int i = 0; i < num; i++) {
                if (i == 0) {
                    System.out.println(1);
                } else if (i == 1) {
                    System.out.println(1 + " " + 1 + " " + 1);
                } else {
                    int size = list.size();
                    for (int j = 0; j < list.size(); j++) {
                        System.out.print(list.get(j) + " ");
                    }
                    int n = list.get(size - 1) + list.get(size - 2);
                    System.out.print(n + " ");
                    for (int j = list.size() - 1; j >= 0; j--) {
                        System.out.print(list.get(j) + " ");
                    }
                    System.out.println();
                    list.add(n);
                }
            }
        }
    }
}
