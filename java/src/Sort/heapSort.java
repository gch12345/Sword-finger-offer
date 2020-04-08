package Sort;

import java.util.Arrays;

public class heapSort {
    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 3, 5, 0, 8, 7};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void heapSort(int[] arr) {
        createHeap(arr);
        int len = arr.length;
        for (int i = 0; i < arr.length - 1; i++) {
            int temp = arr[0];
            arr[0] = arr[len - 1 - i];
            arr[len - 1 - i] = temp;
            shiftDown(arr, len - 1 - i, 0);
        }
    }
    private static void createHeap(int[] arr) {
        int len = arr.length;
        int lastParent = (len - 1 - 1) / 2;
        for (int i = lastParent; i >= 0; i--) {
            shiftDown(arr, len, i);
        }
    }
    private static void shiftDown(int[] arr, int size, int index) {
        int parent = index;
        int child = index * 2 + 1;
        while (child < size) {
            if (child + 1 < size && arr[child + 1] > arr[child]) {
                child = child + 1;
            }
            if (arr[child] > arr[parent]) {
                int temp = arr[parent];
                arr[parent] = arr[child];
                arr[child] = temp;
            } else {
                break;
            }
            parent = child;
            child = parent * 2 + 1;
        }
    }
}
