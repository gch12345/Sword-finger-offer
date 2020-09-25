package youdao;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        int num = 2;
        String text = "     asdfgh       ertyu   ui      ";
        List<String> list = new ArrayList<>();
        int start = 0;
        while (start != text.length()) {
            int end = start;
            int count = 0;
            while (end != text.length() - 1 && (text.charAt(end) != ' ' || count <= num)) {
                end++;
                if (text.charAt(end) == ' ') {
                    count++;
                } else {
                    count = 0;
                }
            }
            list.add(text.substring(start, end - count + 1));
            if (text.charAt(end) != ' ') {
                break;
            }
                while (end != text.length() && text.charAt(end) == ' ') {
                end++;
            }
            start = end;
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}