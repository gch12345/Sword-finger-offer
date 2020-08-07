package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sort {
    //插入排序
    public void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int num = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (arr[j] > num) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = num;
        }
    }

    //希尔
    public void shallSort(int[] arr) {
        int gap = arr.length - 1;
        while (gap > 0) {
            helperSHall(arr, gap);
            gap /= 2;
        }
    }

    private void helperSHall(int[] arr, int gap) {
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

    // 冒泡
    public void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    private void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    //快速
    public void qSort(int[] arr) {
        qSortHelp(arr, 0, arr.length - 1);
    }

    private void qSortHelp(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int l = left;
        int r = right;
        int num = arr[l];
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
        qSortHelp(arr, left, l - 1) ;
        qSortHelp(arr, l + 1, right);
    }

    //选择
    public void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    //归并
    public void mergeSort(int[] arr) {
        mergeHelp(arr, 0, arr.length - 1);
    }

    private void mergeHelp(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (right - left) / 2 + left;
        mergeHelp(arr, left ,mid);
        mergeHelp(arr, mid + 1, right);
        List<Integer> list = new ArrayList<>();
        int i = left;
        int j = mid + 1;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                list.add(arr[i]);
                i++;
            } else {
                list.add(arr[j]);
                j++;
            }
        }
        if (i > mid) {
            for (int k = j; k <= right; k++) {
                list.add(arr[k]);
            }
        } else {
            for (int k = i; k <= mid; k++) {
                list.add(arr[k]);
            }
        }
        for (int k = left; k <= right; k++) {
            arr[k] = list.get(k - left);
        }
    }

    public void heapSort(int[] arr) {
        createHeap(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            swap(arr, 0, arr.length - 1 - i);
            shiftDown(arr, 0, arr.length - 1 - i);
        }
    }

    private void createHeap(int[] arr) {
        int len = arr.length;
        for (int i = (len - 1) / 2; i >= 0; i--) {
            shiftDown(arr, i, len);
        }
    }

    private void shiftDown(int[] arr, int index, int len) {
        int parent = index;
        int child = index * 2 + 1;
        while (child < len) {
            if (child + 1 < len && arr[child + 1] > arr[child]) {
                child += 1;
            }
            if (arr[parent] < arr[child]) {
                swap(arr, parent, child);
                parent = child;
                child = parent * 2 + 1;
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Sort s = new Sort();
        int[] arr = {2,1,3,7,5,8,4,3,7};
//        s.insertSort(arr);
//        s.shallSort(arr);
//        s.bubbleSort(arr);
//        s.qSort(arr);
//        s.selectSort(arr);
//        s.mergeSort(arr);
        s.heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
