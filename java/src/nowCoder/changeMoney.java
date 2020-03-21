package nowCoder;

public class changeMoney {
    public static void main(String[] args) {
        int money = 1;
        int post = 1;
        for (int i = 1; i < 30; i++) {
            post = post * 2;
            money = money + post;
        }
        double ret = money / 100000.0;
        System.out.println(ret + " " + (30 * 10 * 100000));
    }
}
