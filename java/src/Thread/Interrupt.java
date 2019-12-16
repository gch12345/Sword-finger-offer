package Thread;

public class Interrupt {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (!Thread.currentThread().isInterrupted()) {
                        System.out.println(Thread.currentThread());
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
        UnsafeTest();
    }
    static int x = 0;
    public static void UnsafeTest() {
        for (int i = 0; i < 20; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    //System.out.println(Thread.currentThread());
                    for (int j = 0; j < 10000; j++) {
                        x++;
                    }
                }
            });
            thread.start();
        }
        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
        System.out.println(x);
    }
}
