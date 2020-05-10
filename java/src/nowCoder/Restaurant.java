package nowCoder;

import java.util.*;

public class Restaurant {
    static class guest implements Comparable<guest>{
        int num;
        int money;

        public guest(int num, int money) {
            this.num = num;
            this.money = money;
        }

        @Override
        public int compareTo(guest o) {
            if (this.money > o.money) {
                return -1;
            } else if (this.money < o.money) {
                return 1;
            }
            return 0;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int deskNum = sc.nextInt();
            int guestNum = sc.nextInt();
            List<Integer> deskList = new ArrayList<>();
            for (int i = 0; i < deskNum; i++) {
                deskList.add(sc.nextInt());
            }
            deskList.sort(Comparator.naturalOrder());
            PriorityQueue<guest> guestPriorityQueue = new PriorityQueue<>();
            int max = deskList.get(deskList.size() - 1);
            for (int i = 0; i < guestNum; i++) {
                int num = sc.nextInt();
                int money = sc.nextInt();
                if (num > max) {
                    continue;
                }
                guest guest = new guest(num, money);
                guestPriorityQueue.add(guest);
            }
            long ret = 0;
            while (!guestPriorityQueue.isEmpty()) {
                guest guest = guestPriorityQueue.poll();
                for (int j = 0; j < deskList.size(); j++) {
                    if (deskList.get(j) >= guest.num) {
                        ret = ret + guest.money;
                        deskList.remove(j);
                        break;
                    }
                }
                if (deskList.size() == 0 || guestPriorityQueue.size() == 0) {
                    break;
                }
            }
            System.out.println(ret);
        }
    }
}
