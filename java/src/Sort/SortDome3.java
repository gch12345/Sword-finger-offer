package Sort;

import java.util.Arrays;

public class SortDome3 {
    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int x = array[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (x < array[j]) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = x;
        }
    }

    public static void shallSort(int[] array) {
        for (int gap = array.length; gap >= 1; gap /= 2) {
            for (int i = 0; i < array.length; i++) {
                int j = i - gap;
                int x = array[i];
                for (; j >= 0; j -=gap) {
                    if (x < array[j]) {
                        array[j + gap] = array[j];
                    } else {
                        break;
                    }
                }
                array[j + gap] = x;
            }
        }
    }

    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[min] >= array[j]) {
                    min = j;
                }
            }
            int temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }
    }

    private static void heapSort(int[] array) {
        createHeap(array);
        for (int i = 1; i < array.length; i++) {
            swap(array, 0, array.length - i);
            shiftDown(array, array.length - i, 0);
        }
    }
    private static void createHeap(int[] array) {
        for (int i = (array.length - 1 - 1) / 2; i >= 0; i--) {
            shiftDown(array, array.length, i);
        }
    }
    public static void shiftDown(int[] array, int size, int index) {
        int parent = index;
        int child = index * 2 + 1;
        while (child < size) {
            if (child + 1 <size && array[child] < array[child + 1]) {
                child = child + 1;
            }
            if (array[parent] < array[child]) {
                swap(array, parent, child);
            } else {
                break;
            }
            parent = child;
            child = parent * 2 + 1;
        }
    }
    private static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static void main(String[] args) {
        int[] array = {10, 5, 2, 7, 0, 9, 7, 3, 5};
        heapSort(array);
        System.out.println(Arrays.toString(array));
    }
}
