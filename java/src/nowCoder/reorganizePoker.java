package nowCoder;

import java.util.LinkedList;
import java.util.Scanner;

public class reorganizePoker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int group = sc.nextInt();
            for (int i = 0; i < group; i++) {
                int num = sc.nextInt();
                int order = sc.nextInt();
                LinkedList<Integer> link = new LinkedList<>();
                for (int j = 0; j < num * 2; j++) {
                    link.add(sc.nextInt());
                }
                for (int j = 0; j < order; j++) {
                    int size = link.size();
                    int post = size - 2;
                    for (int k = size / 2 - 1; k >= 0; k--) {
                        int poker = link.get(k);
                        link.remove(k);
                        link.add(post, poker);
                        post -= 2;
                    }
                }
                for (int k = 0; k < link.size(); k++) {
                    if (i == group - 1 && k == link.size() - 1)
                        System.out.print(link.get(k));
                    else {
                        System.out.printf("%d ", link.get(k));
                    }
                }
            }
            System.out.println();
        }
    }
}
