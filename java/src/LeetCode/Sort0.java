package LeetCode;

import java.util.Arrays;

public class Sort0 {
    public static void insert(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int cur = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (cur < arr[j]) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = cur;
        }
    }

    public static void shallSort(int[] arr) {
        int gap = arr.length;
        while (gap > 0) {
            helperShall(arr, gap);
            gap /= 2;
        }
    }

    private static void helperShall(int[] arr, int gap) {
        for (int i = 0; i < arr.length; i++) {
            int cur = arr[i];
            int j = i - gap;
            for (; j >= 0; j -= gap) {
                if (cur < arr[j]) {
                    arr[j + gap] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + gap] = cur;
        }
    }

    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void qSort(int[] arr) {
        helperQuick(arr, 0, arr.length - 1);
    }

    private static void helperQuick(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int l = left;
        int r = right;
        int base = arr[left];
        while (l < r) {
            while (l < r && base <= arr[r]) {
                r--;
            }
            while (l < r && base >= arr[l]) {
                l++;
            }
            swap(arr, l, r);
        }
        swap(arr, left, l);
        helperQuick(arr, left, l - 1);
        helperQuick(arr, l + 1, right);
    }

    public static void heapSort(int[] arr) {
        createSort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            swap(arr, 0, arr.length - i - 1);
            shiftDown(arr, 0, arr.length - i - 1);
        }
    }

    private static void createSort(int[] arr) {
        int index = (arr.length - 1 - 1) / 2;
        for (; index >= 0; index--) {
            shiftDown(arr, index, arr.length);
        }
    }

    private static void shiftDown(int[] arr, int index, int len) {
        int parent = index;
        int child = parent * 2 + 1;
        while (child < len) {
            if (child + 1 < len && arr[child + 1] > arr[child]) {
                child += 1;
            }
            if (arr[child] > arr[parent]) {
                swap(arr, child, parent);
            } else {
                break;
            }
            parent = child;
            child = parent * 2 + 1;
        }
    }

    public static void mergeSort(int[] arr) {
        helperMerge(arr, 0, arr.length - 1);
    }

    private static void helperMerge(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (right - left) / 2 + left;
        helperMerge(arr, left, mid);
        helperMerge(arr, mid + 1, right);
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int index = 0;
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                temp[index++] = arr[i++];
            } else {
                temp[index++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[index++] = arr[i++];
        }
        while (j <= right) {
            temp[index++] = arr[j++];
        }
        for (int k = left; k <= right; k++) {
            arr[k] = temp[k - left];
        }
    }

    public static void main(String[] args) {
        int[] arr = {3,2,4,1,6,2,6};
//        insert(arr);
//        shallSort(arr);
//        selectSort(arr);
//        bubbleSort(arr);
//        qSort(arr);
//        heapSort(arr);
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
