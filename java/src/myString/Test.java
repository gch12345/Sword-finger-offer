package myString;

public class Test {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        myString str1 = new myString("aaab");
        System.out.println(str1.myLastIndexOf("ab"));
        System.out.println("aaab".lastIndexOf("ab"));
    }

}
