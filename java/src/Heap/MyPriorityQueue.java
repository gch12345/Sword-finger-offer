package Heap;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MyPriorityQueue {
    private static int[] array = new int[100];
    private static int size = 0;

    public static void offer(int val) {
        if (size >= array.length) {
            return;
        }
        array[size++] = val;
        shiftUp();
    }

    private static void shiftUp() {
        int child = size - 1;
        int parent = (child - 1) / 2;
        while (child > 0) {
            if (array[child] > array[parent]) {
                int swap = array[child];
                array[child] = array[parent];
                array[parent] = swap;
            } else {
                break;
            }
            child = parent;
            parent = (child - 1) / 2;
        }
    }

    public static Integer poll() {
        if (size == 0) {
            return null;
        }
        int ret = array[0];
        array[0] = array[size - 1];
        size--;
        shiftDown();
        return ret;
    }
    private static void shiftDown() {
        int parent = 0;
        int child = parent * 2 + 1;
        while (child < size) {
            if (child + 1 < size && array[child] < array[child + 1]) {
                child = child + 1;
            }
            if (array[parent] < array[child]) {
                int swap = array[parent];
                array[parent] = array[child];
                array[child] = swap;
            } else {
                break;
            }
            parent = child;
            child = parent * 2 + 1;
        }
    }

    public static void main(String[] args) {
        offer(10);
        offer(15);
        offer(56);
        offer(25);
        offer(30);
        offer(70);
        //int ret = poll();
        //System.out.println(ret);
        System.out.println(Arrays.toString(array));
    }
}
