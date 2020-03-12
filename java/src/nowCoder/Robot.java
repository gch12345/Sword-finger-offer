package nowCoder;

public class Robot {
    private int count;
    public int countWays(int x, int y) {
        // write code here
        helper(x - 1, y - 1, 0, 0);
        return count;
    }

    private void helper(int x, int y, int i, int j) {
        if (i == x && j == y) {
            count++;
            return;
        }
        if (i == x) {
            helper(x, y, i, j + 1);
        } else if (j == y) {
            helper(x, y, i + 1, j);
        } else {
            helper(x, y, i + 1, j);
            helper(x, y, i, j + 1);
        }
    }
}
