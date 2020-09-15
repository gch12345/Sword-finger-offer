package wangyi;

public class Main0 {
    public static String compress (String raw_str) {
        // write code here
        if (raw_str == null) {
            return raw_str;
        }
        int end = 0;
        char[] chars = raw_str.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        while (end < raw_str.length()) {
            int count = 1;
            while (end < chars.length - 1 && chars[end] == chars[end + 1]) {
                count++;
                end++;
            }
            if (count > 3) {
                for (int i = count; i >= 0; i-=55) {
                    char c;
                    if (count > 55) {
                        stringBuilder.append("0");
                        c = 'Z';
                        count -= 55;
                        stringBuilder.append(c);
                        stringBuilder.append(chars[end]);
                    } else if (count > 3) {
                        stringBuilder.append("0");
                        int num = count - 4;
                        c = (char) (num % 26);
                        if (num >= 26) {
                            c += 'A';
                        } else {
                            c += 'a';
                        }
                        stringBuilder.append(c);
                        count = 0;
                        stringBuilder.append(chars[end]);
                    }
                }
            }
            if (count <= 3){
                for (int i = 0; i < count; i++)
                stringBuilder.append(chars[end]);
            }
            end = end + 1;
        }
        int num = 'a'- 'A';
        System.out.println(num);
        System.out.println(stringBuilder.toString());
        return stringBuilder.toString();
    }

    public int[] split_into_list (int N, String S) {
        // write code here
        if (S == null || S.length() == 0 || N <= 0) {
            return new int[0];
        }

        return null;
    }

    public static void main(String[] args) {
        compress("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        //"0ZB0tB0geFYHHnjHAPQQc"
        //"0ZB0tB0geFYHHnjHAPQQc"
    }
}
