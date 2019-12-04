package nowCoder;

import java.util.HashSet;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<String> hashSet = new HashSet<>();
        while (sc.hasNext()) {
            String string = sc.next();
            if (!hashSet.contains(string)) {
                hashSet.add(string);
            }
        }
        System.out.println(hashSet.size());
    }
}
