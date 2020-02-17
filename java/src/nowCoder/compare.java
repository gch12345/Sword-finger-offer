package nowCoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Comparator;
public class compare {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (k > input.length) {
            return ret;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < input.length; i++) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(input[i]);
            } else if (input[i] < priorityQueue.peek()) {
                priorityQueue.poll();
                priorityQueue.add(input[i]);
            }
        }
        for (Integer x : priorityQueue) {
            ret.add(x);
        }
        return ret;
    }

    public void HeapSort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        CreateHeap(arr);
        for (int i = 0; i < arr.length;i++) {
            int tmp = arr[0];
            arr[0] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = tmp;
            ShiftDown(arr,  arr.length - i - 1, 0);
        }
    }
    private void CreateHeap(int[] arr) {
        for (int i = (arr.length - 1 - 1) / 2; i >= 0; i--){
            ShiftDown(arr, arr.length, i);
        }
    }
    private void ShiftDown(int[] arr, int size, int index) {
        int parent = index;
        int child = index * 2 + 1;
        while (child < size) {
            if (child + 1 < size && arr[child] < arr[child + 1]) {
                child += 1;
            }
            if (arr[child] > arr[parent]) {
                int tmp = arr[child];
                arr[child] = arr[parent];
                arr[parent] = tmp;
            }
            parent = child;
            child = parent * 2 + 1;
        }

    }
    public static void main(String[] args) {
        compare c = new compare();
        int[] arr ={9,8,7,6,5,3,1,2};
        c.HeapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
