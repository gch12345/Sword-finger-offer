package myString;

import com.sun.deploy.util.ArrayUtil;

import java.lang.reflect.Field;
import java.util.Scanner;


//        10. subString
//        11. trim
//        12. isEmpty
//        13. length
public class myString {
    String str1;

    public myString(String str1) {
        this.str1 = str1;
    }

    //        1. equals
    public boolean myEquals(String str2) {
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
    public int myCompareTo(String str2) {
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
    private char[] myToCharArray(String str) throws NoSuchFieldException, IllegalAccessException {
        Field valueFidld = String.class.getDeclaredField("value");
        valueFidld.setAccessible(true);
        return (char[]) valueFidld.get(str);
    }

    //        4. contains
    public boolean myContains(String str2) throws NoSuchFieldException, IllegalAccessException {
        char[] s1 = myToCharArray(str1);
        char[] s2 = myToCharArray(str2);
        int len1 = s1.length;
        int len2 = s2.length;
        if (len1 < len2) {
            return false;
        }
        for (int i = 0; i < len1 - len2 + 1; i++) {
            int j = 0;
            for (; j < len2; j++) {
                if (s1[i + j] != s2[j]) {
                    break;
                }
            }
            if (j == len2) {
                return true;
            }
        }
        return false;
    }

    //        5. indexOf
    public int myIndexOf(String str2) throws NoSuchFieldException, IllegalAccessException {
        char[] s1 = myToCharArray(str1);
        char[] s2 = myToCharArray(str2);
        int len1 = s1.length;
        int len2 = s2.length;
        if (len1 < len2) {
            return -1;
        }
        for (int i = 0; i < len1 - len2 + 1; i++) {
            int j = 0;
            for (; j < len2; j++) {
                if (s1[i + j] != s2[j]) {
                    break;
                }
            }
            if (j == len2) {
                return i;
            }
        }
        return -1;
    }

    //        6. lastIndexOf
    public int myLastIndexOf(String str2) throws NoSuchFieldException, IllegalAccessException {
        char[] s1 = myToCharArray(str1);
        char[] s2 = myToCharArray(str2);
        int len1 = s1.length;
        int len2 = s2.length;
        if (len1 < len2) {
            return -1;
        }
        for (int i = len1 - 1; i >= len2 - 1; i--) {
            int j = len2 - 1;
            for (int k = 0; j >= 0; j--, k++) {
                if (s1[i - k] != s2[j]) {
                    break;
                }
            }
            if (j == -1) {
                return i - len2 + 1;
            }
        }
        return -1;
    }

    //        7. replaceAll
    public String myReplaceAll(String regex, String replacement) throws NoSuchFieldException, IllegalAccessException {
        char[] s1 = myToCharArray(str1);
        char[] Regex = myToCharArray(regex);
        char[] Replacement = myToCharArray(replacement);
        char[] res = null;
        char[] re = s1;
        int start = 0;
        for (int i = 0; i < s1.length; i++) {
            int count = 0;
            for (int j = 0; j < Regex.length; j++) {
                if (s1[i + j] != Regex[j]) {
                    break;
                }
                count++;
            }
            if (count == Regex.length) {
                re = new char[i - start + Replacement.length];
                System.arraycopy(s1, start, re, 0, i - start);
                System.arraycopy(Replacement, 0, re, i - start, Replacement.length);
                if (res != null) {
                    char[] cur = res;
                    res = new char[re.length + cur.length];
                    System.arraycopy(cur, 0, res, 0, cur.length);
                    System.arraycopy(re, 0, res, cur.length, re.length);
                } else {
                    res = re;
                }
                start = i + Regex.length;
            }
        }
        if (res != null) {
            char[] cur = res;
            res = new char[s1.length - start + cur.length];
            System.arraycopy(cur, 0, res, 0, cur.length);
            System.arraycopy(s1, start, res, cur.length, s1.length - start);
        }
        String s = null;
        if (res == null) {
            s = new String(re);
        } else {
            s = new String(res);
        }
        return s;
    }

    //        8. replaceFirst
    public String myReplaceFrist(String regex, String replacement) throws NoSuchFieldException, IllegalAccessException {
        char[] s1 = myToCharArray(str1);
        char[] Regex = myToCharArray(regex);
        char[] Replacement = myToCharArray(replacement);
        char[] re = s1;
        for (int i = 0; i < s1.length - Regex.length + 1; i++) {
            int count = 0;
            for (int j = 0; j < Regex.length; j++) {
                if (s1[i + j] != Regex[j]) {
                    break;
                }
                count++;
            }
            if (count == Regex.length) {
                re = new char[s1.length - (Regex.length - Replacement.length)];
                System.arraycopy(s1, 0, re, 0, i);
                System.arraycopy(Replacement, 0, re, i, Replacement.length);
                System.arraycopy(s1, i + Regex.length, re, i + Replacement.length, s1.length - (i + Regex.length));
                break;
            }
        }
        String s = new String(re);
        return s;
    }
//        9. split
    public String[] mySplit(String regex) throws NoSuchFieldException, IllegalAccessException {
        char[] s = myToCharArray(str1);
        char[] Regex = myToCharArray(regex);
        String[] re = null;
        int start = 0;
        for (int i = 0; i < s.length; i++) {
            int count = 0;
            for (int j = 0; j < Regex.length; j++) {
                if (s[i + j] != Regex[j]) {
                    break;
                }
                count++;
            }
            if (count == Regex.length && i == s.length - Regex.length) {
                break;
            }
            if (count == Regex.length && i != start) {
                if (re == null) {
                    re = new String[1];
                    re[0] = new String(s, start, i);
                    //re[1] = new String(s, i + Regex.length, s.length - i - Regex.length);
                } else {
                    String[] cur = re;
                    re = new String[cur.length + 1];
                    System.arraycopy(cur, 0, re, 0, cur.length);
                    re[cur.length] = new String(s, start, i - start);
                    //re[cur.length] = new String(s, i + Regex.length, s.length - i - Regex.length);
                }
                start = i + Regex.length;
                i = i + Regex.length - 1;
            }
            if (count == Regex.length && i == start) {
                start = i + Regex.length;
            }
        }
        if(re == null) {
            re = new String[]{str1};
        }
        String[] cur = re;
        re = new String[cur.length + 1];
        System.arraycopy(cur, 0, re, 0, cur.length );
        re[cur.length] = new String(s, start, s.length - start);
        return re;
    }
}
