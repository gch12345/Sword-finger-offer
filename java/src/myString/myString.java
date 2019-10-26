package myString;


import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Arrays;


//        5. indexOf
//        6. lastIndexOf
//        7. replaceAll
//        8. replaceFirst
//        9. split
//        10. subString
//        11. trim
//        12. isEmpty
//        13. length
public class myString {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        char[] arr = myToCharArray("ab");
        System.out.println(Arrays.toString(arr));
    }
    //        1. equals
    public boolean myEquals(String str1, String str2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        for (int i = 0; i < s1.length; i++) {
            if (s1[i] != s2[i]) {
                return false;
            }
        }
        return true;
    }

    //        2. compareTo
    public int myCompareTo(String str1, String str2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        int len1 = s1.length;
        int len2 = s2.length;
        int lim = Math.min(len1, len2);
        for (int i = 0; i < lim; i++) {
            if (s1[i] != s2[i]) {
                return s1[i] - s2[i];
            }
        }
        return len1 - len2;
    }
//        3. toCharArray
    public static char[] myToCharArray(String str) throws NoSuchFieldException, IllegalAccessException {
        Field valueFidld = String.class.getDeclaredField("value");
        valueFidld.setAccessible(true);
        return (char[])valueFidld.get(str);
    }
//        4. contains
    public boolean myContains(String str1, String str2) throws NoSuchFieldException, IllegalAccessException {
        char[] s1 = myToCharArray(str1);
        char[] s2 = myToCharArray(str2);


        return true;
    }
}
