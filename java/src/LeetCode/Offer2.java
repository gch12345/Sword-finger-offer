package LeetCode;

public class Offer2 {
    // 58 - I. 翻转单词顺序
    public String reverseWords0(String s) {
        if (s == null || s.length() < 1) {
            return s;
        }
        s = s.trim();
        String[] strings = s.split(" ");
        StringBuffer stringBuffer = new StringBuffer();
        for (String string : strings) {
            if (string.equals(" ")) {
                continue;
            }
            int index = string.length() - 1;
            while (index >= 0) {
                stringBuffer.append(string.charAt(index));
                index--;
            }
            stringBuffer.append(" ");
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        return stringBuffer.reverse().toString();
    }

    public String reverseWords(String s) {
        if (s == null || s.length() < 1) {
            return s;
        }
        String[] strings = s.trim().split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = strings.length - 1; i > 0; i--) {
            if (strings[i].equals("")) {
                continue;
            }
            stringBuilder.append(strings[i] + " ");
        }
        stringBuilder.append(strings[0]);
        return stringBuilder.toString();
    }

    // 58 - II. 左旋转字符串
    public String reverseLeftWords(String s, int n) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = n; i < s.length() + n; i++ ) {
            stringBuilder.append(s.charAt(i % s.length()));
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Offer2 offer2 = new Offer2();
        offer2.reverseWords(" ");
    }
}
