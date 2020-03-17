package nowCoder;

import java.util.Scanner;

public class combinaMinNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String line = sc.nextLine();
            int[] map = new int[10];
            String[] string = line.split(" ");
            for (int i = 0; i < 10; i++) {
                map[i] = Integer.parseInt(string[i]);
            }
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 1; i < 10; i++) {
                while (map[i] != 0) {
                    stringBuffer.append(i + "");
                    map[i]--;
                    if (stringBuffer.length() == 1) {
                        while (map[0] != 0) {
                            stringBuffer.append("0");
                            map[0]--;
                        }
                    }
                }
            }
            System.out.println(stringBuffer.toString());
        }
    }
}
