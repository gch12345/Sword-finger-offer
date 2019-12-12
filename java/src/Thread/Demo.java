package Thread;

/**
 * 多个线程是同时进行的
 *
 */
public class Demo {
    public static void main(String[] args) {
        //MyThread thread = new MyThread("MyThread");
        //thread.start();
        //thread.run();
        Thread t = new Thread(new MyRunnable(), "MyRunnable");
        t.start();
        System.out.println(Thread.currentThread().getName());
    }
}
//创建线程
//继承Thread类
class MyThread extends Thread{
    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        //System.out.println(Thread.currentThread().getName());
        while (true);
    }
}
//实现Runnable接口
class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}