package xiecheng;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    static int[] divingBoard(int a, int b, int k) {
        if (k == 0) {
            int[] ret = {0};
            return ret;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= k; i++) {
            int num = i * a + (k - i) * b;
            help(list, num);
        }
        int[] ret = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }

    static void help(List<Integer> list, int num) {
        int left = 0;
        int right = list.size() - 1;
        if (left == right) {
            if (list.get(left) < num) {
                list.add(left + 1, num);
                return;
            } else if (list.get(left) == num) {
                return;
            }
        }
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (list.get(mid) == num) {
                return;
            } else if (list.get(mid) > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        list.add(left, num);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(divingBoard(3, 3, 1)));
    }
}
