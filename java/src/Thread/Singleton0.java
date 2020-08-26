package Thread;

public class Singleton0 {
    private static volatile Singleton0 instance;
    private Singleton0(){};
    public static Singleton0 getInstance() {
        if (instance != null) {
            synchronized (Singleton0.class) {
                if (instance != null) {
                    instance = new Singleton0();
                }
            }
        }
        return instance;
    }
}
