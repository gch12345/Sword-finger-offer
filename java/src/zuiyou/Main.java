package zuiyou;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()) {
//            String s = sc.next();
//            long num = 0;
//            boolean star = false;
//            if (s.charAt(0) == '-') {
//                star = true;
//            }
//            int i = 0;
//            if (star) {
//                i = 1;
//            }
//            for (; i < s.length(); i++) {
//                char ch = s.charAt(i);
//                long n = num;
//                if (ch >= '0' && ch <= '9') {
//                    num = num * 36 + (ch - '0');
//                } else if (ch >= 'a' && ch <= 'z') {
//                    num = num * 36 + (ch - 'a') + 10;
//                } else {
//                    num = 0;
//                    break;
//                }
//                if (star) {
//                    if (num < n) {
//                        num = Long.MIN_VALUE + 1;
//                    }
//                } else {
//                    if (num < n) {
//                        num = Long.MAX_VALUE;
//                    }
//                }
//            }
//            if (star) {
//                num = -num;
//            }
//            System.out.println(num);
//        }
        //[[2,8,4],[2,5,0],[10,9,8]],[[2,11,3],[15,10,7],[9,17,12],[8,1,14]]
        int[][] ints = {{2,8,4},{2,5,0},{10,9,8}};
        int[][] ints1 = {{2,11,3},{15,10,7},{9,17,12},{8,1,14}};
        getTriggerTime(ints, ints1);
    }

    public static int[] getTriggerTime (int[][] increase, int[][] requirements) {
        // write code here
        for (int i = 1; i < increase.length; i++) {
            increase[i][0] += increase[i - 1][0];
            increase[i][1] += increase[i - 1][1];
            increase[i][2] += increase[i - 1][2];
        }
        int[] ret = new int[requirements.length];
        for (int i = 0; i < requirements.length; i++) {
            ret[i] = -1;
        }
        for (int i = 0; i < increase.length; i++) {
            for (int j = 0; j < requirements.length; j++) {
                if (ret[j] != -1) {
                    continue;
                }
                if (requirements[j][0] <= increase[i][0] &&
                        requirements[j][1] <= increase[i][1] &&
                        requirements[j][2] <= increase[i][2]) {
                    ret[j] = i + 1;
                }
            }
        }
        return ret;
    }
}
