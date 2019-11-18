package Sort;

import java.util.Arrays;
import java.util.Stack;

public class SortDome2 {
    //堆排序
    public static void HeapSort(int[] array) {
        createHeap(array);
        for (int i = array.length - 1; i > 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            shiftDown(array, i, 0);
        }
    }

    private static void createHeap(int[] array) {
        for (int i = (array.length - 1 - 1) / 2; i >= 0; i--) {
            shiftDown(array, array.length, i);
        }
    }

    private static void shiftDown(int[] array, int size, int index) {
        int parent = index;
        int child = index * 2 + 1;
        while (child < size) {
            if (child + 1 < size && array[child + 1] > array[child]) {
                child = child + 1;
            }
            if (array[child] > array[parent]) {
                int temp = array[child];
                array[child] = array[parent];
                array[parent] = temp;
            } else {
                break;
            }
            parent = child;
            child = parent * 2 + 1;
        }
    }

    //冒泡排序
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    //快速排序
    public static void quickSort(int[] array) {
        helper(array, 0, array.length - 1);
    }

    private static void helper(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int baseValue = array[left];
        int baseIndex = left;
        int Right = right;
        while (left < right) {
            while (left < right && array[right] >= baseValue) {
                right--;
            }
            while (left < right && array[left] <= baseValue) {
                left++;
            }
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
        }
        int temp = array[baseIndex];
        array[baseIndex] = array[left];
        array[left] = temp;
        helper(array, baseIndex, left - 1);
        helper(array,left + 1, Right);
    }

    //快速排序（非递归）
    public static void quickSort0(int[] array) {
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        stack.add(array.length - 1);
        while (!stack.isEmpty()) {
            int right = stack.pop();
            int left = stack.pop();
            if (left >= right) {
                continue;
            }
            int base = partition(array, left, right);
            stack.push(left);
            stack.push(base - 1);
            stack.push(base + 1);
            stack.push(right);
        }
    }

    private static int partition(int[] array, int left, int right) {
        int baseIndex = left;
        int baseValue = array[left];
        while (left < right) {
            while (left < right && array[right] >= baseValue) {
                right--;
            }
            while (left < right && array[left] <= baseValue) {
                left++;
            }
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
        }
        int temp = array[baseIndex];
        array[baseIndex] = array[left];
        array[left] = temp;
        return left;
    }

    //归并排序
    public static void mergeSort(int[] array) {
        int[] helpMarge = new int[array.length];
        helperMergeSort(array, 0, array.length - 1, helpMarge);
    }

    private static void helperMergeSort(int[] array, int left, int right, int[] helpArray) {
        if (left <= right) {
            return;
        }
        int mid = (right - left) / 2;
        helper(array, left, mid);
        helper(array, mid + 1, right);
        merge(array, left, mid, right, helpArray);
    }
    private static void merge(int[] array, int left, int mid, int right, int[] helpArray) {
        int i = left;
        int j = mid + 1;
        int index = 0;
        while (i <= mid && j <= right) {
            if (array[i] < array[j]) {
                helpArray[index++] = array[i++];
            } else {
                helpArray[index++] = array[j++];
            }
        }
        while (i <= mid) {
            helpArray[index++] = array[i++];
        }
        while (j <= right) {
            helpArray[index++] = array[j++];
        }
        for (int k = 0; k <= right - left; k++) {
            array[left + k] = helpArray[k];
        }
    }

    //归并排序（非递归）
    public static void mergeSort0(int[] array) {
        int[] helpArray = new int[array.length];
        for (int gap = 1; gap < array.length; gap *= 2) {
            for (int i = 0; i < array.length; i += gap * 2) {
                int left = i;
                int mid = left + gap - 1;
                int right = left + gap * 2 - 1;
                if (mid > array.length - 1) {
                    mid = array.length - 1;
                }
                if (right > array.length - 1) {
                    right = array.length - 1;
                }
                merge(array, left, mid, right, helpArray);
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {9, 2, 7, 0, 1, 0, 9, 5, 3};
        mergeSort0(array);
        System.out.println(Arrays.toString(array));
    }
}
