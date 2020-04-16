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
