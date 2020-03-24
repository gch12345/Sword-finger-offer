package nowCoder;

public class Gift {
    public int getValue(int[] gifts, int n) {
        // write code here
        int ret = gifts[0];
        int count = 1;
        for (int i = 1; i < n; i++) {
            int num = gifts[i];
            if (ret == num) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                count = 1;
                ret = num;
            }
        }
        count = 0;
        for (int i = 0; i < n; i++) {
            if (gifts[i] == ret) {
                count++;
            }
        }
        if (count * 2 <= n) {
            return 0;
        }
        return ret;
    }
}