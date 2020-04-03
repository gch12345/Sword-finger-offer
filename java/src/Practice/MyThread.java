package Practice;

//import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class MyThread extends Thread{
    public MyThread(String name) {
        super(name);
    }
    @Override
    public void run() {
        super.run();
        System.out.println(Thread.currentThread().getName());
        System.out.println(super.getName());
        System.out.println(this.getName());
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread("xxx");
        myThread.start();
    }
}
