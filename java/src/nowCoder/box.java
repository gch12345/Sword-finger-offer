package nowCoder;

import java.util.Scanner;

public class box {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int col = sc.nextInt();
            int row = sc.nextInt();
            boolean[][] box = new boolean[row][col];
            int count = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (!(j - 2 < 0 || !box[i][j - 2])) {
                        continue;
                    }
                    if (!(j + 2 >= col || !box[i][j + 2])) {
                        continue;
                    }
                    if (!(i - 2 < 0 || !box[i - 2][j])) {
                        continue;
                    }
                    if (!(i + 2 >= row || !box[i + 2][j])) {
                        continue;
                    }
                    box[i][j] = true;
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
