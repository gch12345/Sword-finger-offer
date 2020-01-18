package Holiday;

public class day11 {
    public boolean isPalindrome(String s) {
        if ("".equals(s)) {
            return true;
        }
        s = s.toLowerCase();
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            char ch = s.charAt(start);
            while (start < end && (ch < '0' || ch > '9') && (ch < 'a' || ch >'z') ) {
                start++;
                ch = s.charAt(start);
            }
            ch = s.charAt(end);
            while (start < end && (ch < '0' || ch > '9') && (ch < 'a' || ch > 'z')) {
                end--;
                ch = s.charAt(end);
            }
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

//    给定一组字符，使用原地算法将其压缩。
//    压缩后的长度必须始终小于或等于原数组长度。
//    数组的每个元素应该是长度为1 的字符（不是 int 整数类型）。
//    在完成原地修改输入数组后，返回数组的新长度。

    public int compress(char[] chars) {
        int len = chars.length;
        if (len <= 1) {
            return len;
        }
        int start = 0;
        int end = 0;
        int End = 0;
        while (end < len) {
            end = start + 1;
            while (end < len && chars[start] == chars[end]) {
                end++;
            }
            int num = end - start;
            chars[End] = chars[start];
            End++;
            if (num != 1) {
                int i = End;
                while (num > 0) {
                    chars[End++] = (char) (num % 10 + '0');
                    num = num / 10;
                }
                int j = End - 1;
                while (i < j) {
                    char ch = chars[i];
                    chars[i] = chars[j];
                    chars[j] = ch;
                    i++;
                    j--;
                }
            }
            start = end;
        }
        return End;
    }
    public static void main(String[] args) {
        day11 d = new day11();
        char[] ch = {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','b','b','c','c','c'};
        d.compress(ch);
    }
}
