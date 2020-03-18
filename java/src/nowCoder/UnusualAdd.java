package nowCoder;

public class UnusualAdd {
    public static int addAB(int A, int B) {
        // write code here
        boolean bool = false;
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < 32; i++) {
            int bitA = A & 1;
            int bitB = B & 1;
            if (((bitA == 0) || (bitB == 0)) && !bool) {
                if ((bitA == 0) && (bitB == 0)) {
                    buffer.insert(0, "0");
                } else  {
                    buffer.insert(0, "1");
                }
            } else if ((bitA == 0) && (bitB == 0) && bool){
                buffer.insert(0, "1");
                bool = false;
            } else {
                if (bitA == 1 && bitB == 1 && bool) {
                    buffer.insert(0, "1");
                } else {
                    buffer.insert(0, "0");
                }
                bool = true;
            }
            A = A >> 1;
            B = B >> 1;
        }
        String string = buffer.toString();
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            ret = ret << 1;
            ret = ret ^ Integer.parseInt(string.charAt(i) + "");
        }
        return ret;
    }

    public static void main(String[] args) {
        addAB(2 ,3);
    }
}
