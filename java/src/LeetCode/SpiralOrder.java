package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ret = new ArrayList<>();
        if (matrix == null) {
            return ret;
        }
        int row = matrix.length;
        if (row == 0) {
            return ret;
        }
        int col = matrix[0].length;
        int Row = row;
        if (Row % 2 != 0) {
            Row += 1;
        }
        for (int i = 0; i < Row / 2; i++) {
            int layerUp = i;
            int layerDown = row - i - 1;
            int layerLeft = i;
            int layerRight = col - i - 1;
            if (layerLeft > layerRight || layerUp > layerDown) {
                break;
            }
            for (int j = layerLeft; j <= layerRight; j++) {
                ret.add(matrix[layerUp][j]);
            }
            for (int j = layerUp + 1; j <= layerDown; j++) {
                ret.add(matrix[j][layerRight]);
            }
            if (layerUp < layerDown && layerLeft < layerRight) {
                for (int j = layerRight - 1; j > layerLeft; j--) {
                    ret.add(matrix[layerDown][j]);
                }
                for (int j = layerDown; j > layerUp; j--) {
                    ret.add(matrix[j][layerLeft]);
                }
            }
        }
        return ret;
    }

    public int[][] generateMatrix(int n) {
        int[][] ret = new int[n][n];
        int rowUp = 0;
        int rowDown = n - 1;
        int colLeft = 0;
        int colRight = n - 1;
        int num = 1;
        while (rowUp <= rowDown && colLeft <= colRight) {
            for (int i = colLeft; i <= colRight; i++) {
                ret[rowUp][i] = num++;
            }
            for (int i = rowUp + 1; i <= rowDown; i++) {
                ret[i][colRight] = num++;
            }
            if (rowUp < rowDown && colLeft < colRight) {
                for (int i = colRight - 1; i > colLeft; i--) {
                    ret[rowDown][i] = num++;
                }
                for (int i = rowDown; i > rowUp; i--) {
                    ret[i][colLeft] = num++;
                }
            }
            rowUp++;
            rowDown--;
            colLeft++;
            colRight--;
        }
        return ret;
    }

    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int[][] ret = new int[R * C][2];
        if (R == 0 || C == 0) {
            return ret;
        }
        int[] d1 = {0, 1, 0, -1};
        int[] d2 = {1, 0, -1, 0};
        ret[0][0] = r0;
        ret[0][1] = c0;
        int num = 1;
        int dec = 1;
        int star = 0;
        while (num < R * C) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < dec; j++) {
                    r0 = r0 + d1[star];
                    c0 = c0 + d2[star];
                    if (r0 < R && c0 < C && r0 >= 0 && c0 >= 0) {
                        ret[num][0] = r0;
                        ret[num][1] = c0;
                        num++;
                    }
                }
                star++;
                star = star % 4;
            }
            dec++;
        }
        return ret;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {2},
                {3},
                {4},
                {5}
        };
        spiralOrder(arr);
    }
}
