package nowCoder;

public class ReplaceSpace {
    public String replaceSpace(StringBuffer str) {
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == ' ') {
                str.deleteCharAt(i);
                str.insert(i, "%20");
                i = i + 2;
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        ReplaceSpace replaceSpace = new ReplaceSpace();
        StringBuffer stringBuffer = new StringBuffer("wo aa aa");
        System.out.println(replaceSpace.replaceSpace(stringBuffer));
    }
}
