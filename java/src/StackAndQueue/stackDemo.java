package StackAndQueue;

public class stackDemo {
    private int[] array = new int[100];
    private int size = 0;

    public void push(int num) {
        array[size] = num;
        size++;
    }

    public int pop() {
        size--;
        return array[size];
    }

    public int peek() {
        return array[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int sizze() {
        return size;
    }
}
