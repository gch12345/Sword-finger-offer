package Sort;

import java.util.Arrays;

public class qSort {
    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 3, 5, 0, 8, 7};
        qSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
    private static void qSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int i = left;
        int j = right;
        int num = arr[left];
        while (i < j) {
            while (i < j && arr[j] >= num) {
                j--;
            }
            while (i < j && arr[i] <= num) {
                i++;
            }
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        int temp = arr[left];
        arr[left] = arr[i];
        arr[i] = temp;
        qSort(arr, left, i - 1);
        qSort(arr, i + 1, right);
    }
}
