package baidu;

import java.util.Comparator;
import java.util.PriorityQueue;

public class topk {
    public boolean f2() {
        if (f1() && f1()) {
            return true;
        }
        return false;
    }

    public boolean f3() {
        if (f1() && f1() && !f1()) {
            return true;
        }
        return false;
    }

    public boolean f4() {
        if (f1() || f1() || f1() || f1() || f1()) {
            return true;
        }
        return false;
    }


    public int[] top(int[] arr, int n) {
        if (arr == null || n <= 0 || arr.length < n) {
            return new int[0];
        }
        int[] ret = new int[n];
        for (int i = 0; i < n; i++) {
            ret[i] = arr[i];
        }
        createHeap(ret);
        for (int i = n; i < arr.length; i++) {
            if (arr[i] < arr[0]) {
                continue;
            } else {
                ret[0] = arr[i];
                shiftDown(ret, 0);
            }
        }
        return ret;
    }

    private void createHeap(int[] arr) {
        int index = (arr.length - 1) / 2;
        for (int i = index; i >= 0; i--) {
            shiftDown(arr, index);
        }
    }

    private void shiftDown(int[] arr, int index) {
        int parent = index;
        int child = index * 2 + 1;
        int len = arr.length;
        while (child < len) {
            if (child + 1 < len && arr[child] > arr[child + 1]) {
                child++;
            }
            if (arr[parent] > arr[child]) {
                int temp = arr[parent];
                arr[parent] = arr[child];
                arr[child] = temp;
            }
            parent = child;
            child = parent * 2 + 1;
        }
    }
}
