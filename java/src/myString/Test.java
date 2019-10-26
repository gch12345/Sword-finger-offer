package myString;

public class Test {
    public static void main(String[] args) {
        String address = "11\\12.13.14:800";
        System.out.println(address.split("\\\\").length);

        String[] num = address.split("\\\\");
        for (int i = 0; i < num.length; i++) {
            System.out.println(num[i]);
        }
    }
}
