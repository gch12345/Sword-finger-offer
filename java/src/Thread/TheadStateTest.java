package Thread;

public class TheadStateTest {
    public static void test() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println();
            }
        });
        System.out.println();
    }

    public static void main(String[] args) {
        for (Thread.State state : Thread.State.values()) {
            System.out.println(state);
        }
    }
}
