package StackAndQueue;

public class Main {
    public static void main(String[] args) {
        LinkListQueueDemo queue = new LinkListQueueDemo();
        queue.offer(0);
        queue.offer(1);
        System.out.println(queue.poll());
        System.out.println(queue.size());
        queue.offer(2);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.size());
    }
}
