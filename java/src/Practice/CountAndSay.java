package Practice;

public class CountAndSay {
    public String countAndSay(int n) {
        return helper(n, "1");
    }
    private String helper(int n, String str) {
        if (n == 1) {
            return str;
        }
        StringBuffer s = new StringBuffer();
        int i = 0;
        while (i < str.length()) {
            int count = 1;
            while (i < str.length() - 1  && str.charAt(i) == str.charAt(i + 1)) {
                count++;
                i++;
            }
            s.append((char) count + '0');
            s.append(str.charAt(i));
            i++;
        }
        return helper(n - 1, s.toString());
    }

    public static void main(String[] args) {
        System.out.println((char)(1 + '0'));
        int i = 1;
        System.out.println(i);
    }
}
