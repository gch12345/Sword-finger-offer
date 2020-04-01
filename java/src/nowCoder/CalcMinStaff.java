package nowCoder;

import java.util.ArrayList;
import java.util.Scanner;

public class CalcMinStaff {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            ArrayList<Integer> list = new ArrayList<>();
            int personNum = in.nextInt();
            for (int i = 0; i < personNum; i++) {
                String str = in.next();
                String[] strs = str.split(",");
                int start = Integer.parseInt(strs[0]);
                int end = Integer.parseInt(strs[1]);
                int left = 0;
                int right = list.size();
                int mid = (left + right) / 2;
                while (left < right) {
                    mid = (left + right) / 2;
                    int num = list.get(mid);
                    if (num <= start) {
                        list.remove(mid);
                        break;
                    }
                }
                list.add(end);
            }
            System.out.println(list.size());
        }
    }
}
