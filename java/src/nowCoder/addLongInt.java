package nowCoder;

import java.util.Scanner;

public class addLongInt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            System.out.println(AddLongInteger(sc.next(), sc.next()));
        }
    }
    public static String AddLongInteger(String addend, String augend) {
        if (addend == null) {
            return augend;
        }
        if (augend == null) {
            return addend;
        }
        StringBuffer stringBuffer = new StringBuffer();
        int i = addend.length() - 1;
        int j = augend.length() - 1;
        int bool = 0;
        while (i >= 0 && j >= 0) {
            int addEnd = addend.charAt(i) - '0';
            int augEnd = augend.charAt(j) - '0';
            int num = addEnd + augEnd + bool;
            if (num >= 10) {
                num = num % 10;
                bool = 1;
            } else {
                bool = 0;
            }
            stringBuffer.insert(0, num + "");
            i--;
            j--;
        }
        String string = null;
        int k = 0;
        if (i < 0) {
            string =  augend;
            k = j;
        } else {
            string = addend;
            k = i;
        }
        for (; k >= 0; k--) {
            int num = string.charAt(i) + bool -'0';
            if (num >= 10) {
                num = num % 10;
                bool = 1;
            } else {
                stringBuffer.insert(0, num + "");
                if (k > 0)
                stringBuffer.insert(0, string.substring(0, k - 1));
                bool = 0;
                break;
            }
            stringBuffer.insert(0, num + "");
        }
        if (bool == 1) {
            stringBuffer.insert(0, 1 + "");
        }
        return stringBuffer.toString();
    }
}
