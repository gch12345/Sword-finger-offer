package nowCoder;

public class AntiOrder {
    public int count(int[] A, int n) {
        // write code here
        int ret = 0;
        for (int i = 1; i < n; i++) {
            int num = A[i];
            int j = i;
            for (; j > 0; j--) {
                if (A[j - 1] <= num) {
                    break;
                }
                ret++;
                A[j] = A[j - 1];
            }
            A[j] = num;
        }
        return ret;
    }
}