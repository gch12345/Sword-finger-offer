package Practice;

public class A {
    public void fun() {
        int a = 0;
        class B {
            private void test() {
                System.out.println(a);
            }
        }
        B b = new B();
        b.test();
    }

    public static void main(String[] args) {
        A a = new A();
        a.fun();
    }
}
