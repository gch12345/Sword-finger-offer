package Sort;

import java.util.Arrays;

public class SortDome1 {
    public static void insertSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int x = array[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (array[j] > x) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = x;
        }
    }

    public static void shallSort(int[] array) {
        int gap = array.length;
        while (gap >= 1) {
            insertSortGap(array, gap);
            gap /= 2;
        }
    }

    private static void insertSortGap(int[] array, int gap) {
        for (int i = 0; i < array.length; i++) {
            int x = array[i];
            int j = i - gap;
            for (; j >= 0; j -= gap) {
                if (array[j] > x) {
                    array[j + gap] = array[j];
                } else {
                    break;
                }
            }
            array[j + gap] = x;
        }
    }

   public static void selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[min] > array[j]) {
                    min = j;
                }
            }
            int temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }
   }

    public static void main(String[] args) {
        int[] array = {2, 1, 3, 4, 9, 5, 2, 7};
        shallSort(array);
        System.out.println(Arrays.toString(array));
    }
}
