package StackAndQueue;

public class arrayQueueDemo {
    private int[] array = new int[2];
    private int start = 0;
    private int end = 0;

    public void offer(int num) {
        array[end] = num;
        end++;
        end = end % array.length;
    }

    public int poll() {
        int ret = array[start];
        start++;
        start = start % array.length;
        return ret;
    }

    public int peek() {
        return array[start];
    }

    public boolean isEmpty() {
        if (start == end) {
            return true;
        }
        return false;
    }

    public int size() {
        int ret = end - start;
        if (ret < 0) {
            ret = -ret;
        }
        return ret;
    }
}
