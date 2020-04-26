package Tencent;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class queue {
    static Queue<Integer> integerQueue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int count = sc.nextInt();
            for (int i = 0; i < count; i++) {
                int num = sc.nextInt();
                sc.nextLine();
                for (int j = 0; j < num; j++) {
                    String str = sc.nextLine();
                    if (str.startsWith("PUSH")) {
                        integerQueue.add(Integer.valueOf(str.substring(5)));
                    } else if (str.startsWith("POP")) {
                        if (integerQueue.size() == 0) {
                            System.out.println(-1);
                        } else {
                            integerQueue.poll();
                        }
                    } else if  (str.startsWith("TOP")) {
                        if (integerQueue.size() == 0) {
                            System.out.println(-1);
                        } else {
                            System.out.println(integerQueue.peek());
                        }
                    } else if (str.startsWith("SIZE")) {
                        System.out.println(integerQueue.size());
                    } else {
                        integerQueue.clear();
                    }
                }
            }
        }
    }
}
