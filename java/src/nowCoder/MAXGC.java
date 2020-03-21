package nowCoder;

import java.util.Scanner;

public class MAXGC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.next();
            int num = sc.nextInt();
            int maxGCNum = 0;
            int GCNum = 0;
            int begin = 0;
            int GCBegin = 0;
            int end = begin + num;
            for (; begin < num; begin++) {
                char ch = str.charAt(begin);
                if (ch == 'C' || ch == 'G') {
                    maxGCNum += 1;
                }
            }
            begin = 0;
            GCNum = maxGCNum;
            while (end < str.length()) {
                char beginChar = str.charAt(begin);
                char next = str.charAt(end);
                if (beginChar == 'C' || beginChar == 'G') {
                    GCNum--;
                }
                if (next == 'C' || next == 'G') {
                    GCNum++;
                }
                begin++;
                end++;
                if (GCNum > maxGCNum) {
                    maxGCNum = GCNum;
                    GCBegin = begin;
                }
            }
            System.out.println(str.substring(GCBegin, GCBegin + num ));
        }
    }
}
