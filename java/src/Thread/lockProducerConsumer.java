package Thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class lockProducerConsumer {
    volatile int size = 0;
    Lock lock = new ReentrantLock(true);
    Condition conditionP = lock.newCondition();
    Condition conditionC = lock.newCondition();
    public producer getProducer(String name) {
        return new producer(name);
    }

    public consumer getConsumer(String name) {
        return new consumer(name);
    }

    class producer extends Thread{
        String name;
        public producer(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    while (size == 10) {
                        conditionP.await();
                    }
                    size++;
                    System.out.println(name + ": 生产了，size = " + size);
                    conditionC.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    class consumer extends Thread{
        String name;
        public consumer(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    while (size == 0) {
                        conditionC.await();
                    }
                    size--;
                    System.out.println(name + ": 消费了，size = " + size);
                    conditionP.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        lockProducerConsumer lockProducerConsumer = new lockProducerConsumer();
        consumer consumer0 = lockProducerConsumer.getConsumer("consumer0");
        consumer consumer1 = lockProducerConsumer.getConsumer("consumer1");
        producer producer0 = lockProducerConsumer.getProducer("producer0");
        consumer consumer = lockProducerConsumer.getConsumer("consumer");
        producer producer = lockProducerConsumer.getProducer("producer");
        producer producer1 = lockProducerConsumer.getProducer("producer1");
        consumer.start();
        producer.start();
        consumer0.start();
        producer0.start();
        consumer1.start();
        producer1.start();
    }
}
