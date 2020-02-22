package LeetCode;

import org.junit.Test;
import sun.security.krb5.internal.crypto.Des;

import java.util.*;

public class LongNum {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String string = sc.next();
        int Index = -1;
        int Len = 0;
        for (int i = 0; i< string.length();i++) {
            char c = string.charAt(i);
            Boolean b = true;
            if (c == '-') {
                b = false;
                i++;
                c = string.charAt(i);
            }
            if (c >= '0' && c <= '9') {
                int index = i;
                int len = 0;
                while (i < string.length() && string.charAt(i) >= '0' && string.charAt(i) <= '9') {
                    len++;
                    i++;
                }
                if (!b) {
                    len++;
                    index--;
                }
                if (len > Len) {
                    Len = len;
                    Index = index;
                }
            }
        }
        if (Len == 0) {
            return;
        } else {
            for (int i = Index; i < Index + Len; i++) {
                System.out.print(string.charAt(i));
            }
        }
        LongNum l = new LongNum();
        int[] arr = {4,5,1,6,2,7,3,8};
        l.GetLeastNumbers_Solution(arr,4);
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (k > input.length) {
            return arrayList;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int val : input) {
            pq.add(val);
            if (pq.size() > k)
                pq.poll();
        }
        while (!pq.isEmpty()) {
            int num = pq.poll();
            arrayList.add(0, num);
        }
        return arrayList;
    }
}
