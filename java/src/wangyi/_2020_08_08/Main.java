package wangyi._2020_08_08;

import java.util.*;

public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()) {
//            int T  = sc.nextInt();
//            for (int i = 0; i < T; i++) {
//                int num = sc.nextInt();
//                int person1 = 0;
//                int person2 = 0;
//                int[] arr = new int[num];
//                int sum = 0;
//                for (int j = 0; j < num; j++) {
//                    int cur = sc.nextInt();
//                    sum += cur;
//                    arr[j] = cur;
//                    if (person1 <= person2) {
//                        person1 += cur;
//                    } else {
//                        person2 += cur;
//                    }
//                }
//                int bag = Math.min(person1, person2) * 2;
//                int[][] dp = new int[bag + 1][num + 1];
//                for (int j = 1; j <= bag; j++) {
//                    for (int k = 1; k <= num; k++) {
//                        dp[j][k] = dp[j][k - 1];
//                        if (j >= arr[k - 1]) {
//                            dp[j][k] = Math.max(dp[j][k], dp[j - arr[k - 1]][k - 1] + arr[k - 1]);
//                        }
//                    }
//                }
//                System.out.println(sum - dp[bag][num]);
//            }
//        }
//    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()) {
//            int T  = sc.nextInt();
//            for (int i = 0; i < T; i++) {
//                int num = sc.nextInt();
//                int person1 = 0;
//                int person2 = 0;
//                int[] arr = new int[num];
//                for (int j = 0; j < num; j++) {
//                    int cur = sc.nextInt();
//                    arr[j] = cur;
//                    if (person1 <= person2) {
//                        person1 += cur;
//                    } else {
//                        person2 += cur;
//                    }
//                }
//                int bag = Math.min(person1, person2) * 2;
//                int[][] dp = new int[bag + 1][num + 1];
//                for (int j = 1; j <= bag; j++) {
//                    for (int k = 1; k <= num; k++) {
//                        dp[j][k] = dp[j][k - 1];
//                        if (j >= arr[k - 1]) {
//                            dp[j][k] = Math.max(dp[j][k], dp[j - arr[k - 1]][k - 1] + arr[k - 1]);
//                        }
//                        System.out.print(dp[j][k] + " ");
//                    }
//                    System.out.println();
//                }
//            }
//        }
//
//        while (sc.hasNext()) {
//            int n = sc.nextInt();
//            int m = sc.nextInt();
//            Queue<Integer> queue = new LinkedList<>();
//            Set<Integer> set = new HashSet<>();
//            for (int i = 0; i < m; i++) {
//                int num = sc.nextInt();
//                queue.add(num);
//                set.add(num);
//            }
//            int num = 1;
//            List<Integer> list = new ArrayList<>();
//            while (num <= n) {
//                if (queue.isEmpty()) {
//                    list.add(num);
//                    num++;
//                } else {
//                    if (num > queue.peek()) {
//                        list.add(queue.poll());
//                    } else if (num < queue.peek()) {
//                        if (set.contains(num)) {
//                            num++;
//                        } else {
//                            list.add(num);
//                            num++;
//                        }
//                    } else {
//                        list.add(queue.poll());
//                        num++;
//                    }
//                }
//            }
//            while (!queue.isEmpty()) {
//                list.add(queue.poll());
//            }
//            for (int i = 0; i < list.size(); i++) {
//                if (i == list.size() - 1) {
//                    System.out.print(list.get(i));
//                } else {
//                    System.out.print(list.get(i) + " ");
//                }
//            }
//        }
//    }
}
