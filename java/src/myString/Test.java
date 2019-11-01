package myString;

import java.util.Arrays;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws Exception {
        myString s1 = new myString("a");
        System.out.println(s1.myIsEmpty());
        System.out.println(s1.myLength());
        //String re = s1.mySubString(2,3);
        //System.out.println(re);
        //System.out.println("abc".substring(1,5));
       // String s = s1.myReplaceAll("bc", "x");
//        //s = "ac";
//        System.out.println(s);
//        String str = "hello world    " ;
//        String[] result = s1.mySplit("c") ;
//        System.out.println(result.length);
//        for(String s: result) {
//            System.out.println(s);
//        }
    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String s = sc.next();
//        char[] str = s.toCharArray();
//        int[] map = new int['z' - 'A' + 1];
//        int count = 1;
//        for (int i = 0; i < str.length; i++) {
//            if(map[str[i] - 'A'] == 0) {
//                map[str[i] - 'A'] = count;
//                count++;
//            }
//        }
//        char[] re = new char[count - 1];
//        for (int i = 1; i < count; i++) {
//            for (int j = 0; j < 'z' - 'A' + 1; j++ ){
//                if (map[j] == i) {
//                    re[i - 1] = (char)(j + 'A');
//                }
//            }
//        }
//        s = new String(re);
//        System.out.println(s);
//    }
}
