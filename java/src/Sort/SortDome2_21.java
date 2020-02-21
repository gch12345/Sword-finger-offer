package Sort;

import java.util.Arrays;

public class SortDome2_21 {
    public void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            helper(arr, i);
        }
    }
    public void helper(int[] arr, int k) {
        int num = arr[k];
        int i = k - 1;
        for (; i >= 0; i--) {
            if (arr[i] > num) {
                arr[i + 1] = arr[i];
            } else {
                break;
            }
        }
        arr[i + 1] = num;
    }

    public void ShellSort(int[] arr) {
        int gap = arr.length;
        while (gap > 1) {
            insertShell(arr, gap);
            gap /= 2;
        }
        insertShell(arr, 1);
    }
    private void insertShell(int[] arr, int gap) {
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            int j = i - gap;
            for (; j >= 0; j -= gap) {
                if (arr[j] > num) {
                    arr[j + gap] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + gap] = num;
        }
    }
    public void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int swap = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = swap;
        }
    }
    public void heapSort(int[] arr) {
        createHeap(arr);
        for (int i = 0; i < arr.length; i++) {
            int tmp = arr[0];
            arr[0] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = tmp;
            shiftDown(arr, arr.length - i - 1, 0);
        }
    }
    private void createHeap(int[] arr) {
        for (int i = (arr.length - 1) / 2; i >= 0; i--) {
            shiftDown(arr, arr.length, i);
        }
    }
    public void shiftDown(int[] arr, int size, int index) {
        int parent = index;
        int left = index * 2 + 1;
        while (left < size) {
            if (left + 1 < size && arr[left] < arr[left + 1]) {
                left = left + 1;
            }
            if (arr[left] > arr[parent]) {
                int tmp = arr[left];
                arr[left] = arr[parent];
                arr[parent] = tmp;
            }
            parent = left;
            left = parent * 2 + 1;
        }
    }
    public void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]){
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }
    public void quickSort(int[] arr) {
        help(arr, 0, arr.length - 1);
    }
    private void help(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int Left = left;
        int Right = right;
        int x = left;
        left = left + 1;
        while (left < right) {
            while (left < right && arr[right] > arr[x]) {
                right--;
            }
            while (left < right && arr[left] < arr[x]){
                left++;
            }
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
        }
        int tmp = arr[left];
        arr[left] = arr[x];
        arr[x] = tmp;
        help(arr, Left, left - 1);
        help(arr, left + 1, Right);
    }
    public void mergeSort(int[] arr) {
        mergeHelp(arr, 0, arr.length - 1);
    }
    private void mergeHelp(int[] arr, int left, int right) {
        if (right <= left) {
            return;
        }
        int mid = (left + right) / 2;
        mergeHelp(arr, left, mid);
        mergeHelp(arr, mid + 1, right);
        int len = right - left + 1;
        int[] buff = new int[len];
        int i = left;
        int j = mid + 1;
        int index = 0;
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                buff[index++] = arr[i++];
            } else {
                buff[index++] = arr[j++];
            }
        }
        while (i <= mid) {
            buff[index++] = arr[i++];
        }
        while (j <= right) {
            buff[index++] = arr[j++];
        }
        for (int k = left; k <= right; k++) {
            arr[k] = buff[k - left];
        }
    }
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 1, 8, 7};
        SortDome2_21 sortDome2_21 = new SortDome2_21();
        //sortDome2_21.insertSort(arr);
//        sortDome2_21.ShellSort(arr);
//        sortDome2_21.selectSort(arr);
//        sortDome2_21.heapSort(arr);
//        sortDome2_21.bubbleSort(arr);
//        sortDome2_21.quickSort(arr);
//        sortDome2_21.mergeSort(arr);
        SortDome3.mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
