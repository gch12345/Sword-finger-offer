package nowCoder;
//在一个二维数组中（每个一维数组的长度相同），
//每一行都按照从左到右递增的顺序排序，
//每一列都按照从上到下递增的顺序排序。
//请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
public class Find {
    public boolean find(int target, int [][] array) {
        int col = array[0].length;
        int row = array.length;
        int i = row - 1;
        int j = 0;
        while (i < row && i >= 0 && j < col && j >= 0) {
            if (target > array[i][j]) {
                j++;
            } else if (target < array[i][j]) {
                i--;
            } else {
                return true;
            }
        }
        return false;
    }
}
