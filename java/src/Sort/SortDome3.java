package Sort;

import java.util.Arrays;
import java.util.Stack;

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

    public static void quickSort(int[] array) {
        helperQuickSort(array, 0 , array.length - 1);
    }
    private static void helperQuickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int bound = index(array, left, right);
        helperQuickSort(array, left, bound - 1);
        helperQuickSort(array, bound + 1, right);
    }
    private static int index(int[] array, int left, int right) {
        int bound = left;
        while (left < right) {
            while (left < right && array[right] >= array[bound]) {
                right--;
            }
            while (left < right && array[left] <= array[bound]) {
                left++;
            }
            swap(array, left, right);
        }
        swap(array, bound, left);
        return left;
    }

    //非递归
    public static void quickSort0(int[] array) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(array.length - 1);
        while (!stack.isEmpty()) {
            int right = stack.pop();
            int left = stack.pop();
            if (left < right) {
                int mid = index(array, left, right);
                stack.push(left);
                stack.push(mid - 1);
                stack.push(mid + 1);
                stack.push(right);
            }
        }
    }

    public static void mergeSort(int[] array) {
        int[] arrayHelper = new int[array.length];
        mergeSortHelp(array, 0, array.length - 1, arrayHelper);
    }

    public static void mergeSortHelp(int[] array, int left, int right, int[] arrayHelper) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSortHelp(array, left, mid, arrayHelper);
        mergeSortHelp(array, mid + 1, right, arrayHelper);
        merge(array, left, mid, right, arrayHelper);
    }
    public static void merge(int[] array, int left, int mid, int right, int[] arrayHelper) {
        int i = left;
        int j = mid + 1;
        int index = 0;
        while (i <= mid && j <= right) {
            if (array[i] < array[j]) {
                arrayHelper[index++] = array[i++];
            } else {
                arrayHelper[index++] = array[j++];
            }
        }
        while (i <= mid) {
            arrayHelper[index++] = array[i++];
        }
        while (j <= right) {
            arrayHelper[index++] = array[j++];
        }
        for (int k = 0; k <= right - left; k++) {
            array[left + k] = arrayHelper[k];
        }
    }

    public static void mergeSort0(int[] array) {
        int[] arrayHelper = new int[array.length];
        for (int gap = 1; gap < array.length; gap *= 2) {
            for (int i = 0; i <array.length; i += gap * 2) {
                int left = i;
                int mid = left + gap - 1;
                int right = left + gap * 2 - 1;
                if (mid >= array.length) {
                    mid = array.length - 1;
                }
                if (right >= array.length) {
                    right = array.length - 1;
                }
                merge(array, left, mid, right, arrayHelper);
            }
        }
    }
    public static void main(String[] args) {
        int[] array = {10, 5, 2, 7, 0, 9, 7, 3, 5};
        mergeSort0(array);
        System.out.println(Arrays.toString(array));
    }
}
