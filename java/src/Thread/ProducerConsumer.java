package Thread;

import java.util.Random;

public class ProducerConsumer {
    public static final int maxSize = 100;
    public static volatile int size = 0;
    public static class producer extends Thread{
        @Override
        public void run() {
            while (true) {
                if (size < maxSize) {
                    synchronized (ProducerConsumer.class) {
                        size++;
                        System.out.println("生产了");
                        notifyAll();
                        return;
                    }
                }
                while (size == maxSize) {
                    synchronized (ProducerConsumer.class) {
                        if (size == maxSize) {
                            try {
                                wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }

    public static class consumer extends Thread {
        @Override
        public void run() {
            while (true) {
                if (size > 0) {
                    synchronized (ProducerConsumer.class) {
                        size--;
                        System.out.println("消费了");
                        notifyAll();
                        return;
                    }
                }
                while (size == 0) {
                    synchronized (ProducerConsumer.class) {
                        if (size == 0) {
                            try {
                                wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        ProducerConsumer producerConsumer = new ProducerConsumer();
        producer producer0 = new producer();
        consumer consumer0 = new consumer();
        producer0.start();
        consumer0.start();
    }
}
