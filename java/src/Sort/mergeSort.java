package Sort;

import java.util.Arrays;

public class mergeSort {
    public static void main(String[] args) {
       int[] arr = {4, 3, 5, 1, 7, 0};
       merge(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void merge(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        merge(arr, left, mid);
        merge(arr, mid + 1, right);
        int[] array = new int[right - left + 1];
        int l1 = left;
        int l2 = mid + 1;
        int index = 0;
        while (l1 <= mid && l2 <= right) {
            if (arr[l1] < arr[l2]) {
                array[index++] = arr[l1++];
            } else {
                array[index++] = arr[l2++];
            }
        }
        if (l1 > mid) {
            while (l2 <= right) {
                array[index++] = arr[l2++];
            }
        } else {
            while (l1 <= mid) {
                array[index++] = arr[l1++];
            }
        }
        for (int i = left; i <= right; i++) {
            arr[i] = array[i - left];
        }
    }
}
