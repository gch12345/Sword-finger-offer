package Thread;

public class ProducerConsumer {
    public static final Integer maxSize = 10;
    public static volatile int size = 0;
    static class producer extends Thread{
        public producer(String name) {
            Thread.currentThread().setName(name);
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (ProducerConsumer.class) {
                    if (size < maxSize) {
                        size++;
                        System.out.println(Thread.currentThread().getName() + "生产者  size = " + size);
                        ProducerConsumer.class.notifyAll();

                    }
                    while (size == maxSize) {
                        try {
                            ProducerConsumer.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    static class consumer extends Thread {
        public consumer(String name) {
            Thread.currentThread().setName(name);
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (ProducerConsumer.class) {
                    if (size > 0) {
                        size--;
                        System.out.println(Thread.currentThread().getName() + "消费者  size = " + size);
                        ProducerConsumer.class.notifyAll();
                    }
                    while (size == 0) {
                        try {
                            ProducerConsumer.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        new consumer("c1").start();
        new consumer("c2").start();
        new consumer("c3").start();
        new consumer("c3").start();
        new producer("p1").start();
        new producer("p2").start();
        new producer("p3").start();
        new producer("p4").start();
    }
}
