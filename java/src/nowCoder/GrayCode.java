package nowCoder;

public class GrayCode {
    public static String[] getGray(int n) {
        String[] string = new String[(int)Math.pow(2, n)];
        if (n == 1) {
            string[0] = "0";
            string[1] = "1";
            return string;
        }
        String[] ret = getGray(n - 1);
        for (int i = 0; i < ret.length; i++) {
            string[i] = "0" + ret[i];
            string[ret.length * 2 - i - 1] = "1" + ret[i];
        }
        return string;
    }

    public static void main(String[] args) {
        for (String s : getGray(2)) {
            System.out.println(s);
        }
    }
}
