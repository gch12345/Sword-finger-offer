package tonghuashun;

import java.util.Arrays;

public class Main {
    public void qSort(int[] arr) {
        helper(arr, 0, arr.length - 1);
    }
    private void helper(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int l = left + 1;
        int r = right;
        int num = arr[left];
        while (l < r) {
            while (l < r && arr[r] >= num) {
                r--;
            }
            while (l < r && arr[l] <= num) {
                l++;
            }
            swap(arr, l, r);
        }
        swap(arr, left, l);
        helper(arr, left, l - 1);
        helper(arr, l + 1, right);
    }
    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {2,1,4,2,5,6,};
        Main m = new Main();
        m.qSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
