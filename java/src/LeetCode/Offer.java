package LeetCode;

import sun.reflect.generics.tree.Tree;

import java.util.HashMap;
import java.util.Map;

public class Offer {
    // 数组中重复的数字
    public int findRepeatNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }

//    二维数组中的查找
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int curRow = row - 1;
        int curCol = 0;
        while (curRow >= 0 && curCol < col) {
            if (matrix[curRow][curCol] > target) {
                curRow--;
            } else if (matrix[curRow][curCol] < target) {
                curCol++;
            } else {
                return true;
            }
        }
        return false;
    }

    // 替换空格
    public String replaceSpace(String s) {
        int length = s.length();
        char[] array = new char[length * 3];
        int size = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                array[size++] = '%';
                array[size++] = '2';
                array[size++] = '0';
            } else {
                array[size++] = c;
            }
        }
        String retStr = new String(array, 0, size);
        return retStr;
    }

    // 重建树
    Map<Integer, Integer> map = new HashMap<>();
    int index;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null) {
            return null;
        }
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, inorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preOrder, int[] inOrder, int inLeft, int inRight) {
        if(inLeft > inRight || index >= preOrder.length) {
            return null;
        }
        TreeNode root = new TreeNode(preOrder[index]);
        int order = map.get(preOrder[index++]);
        root.left = helper(preOrder, inOrder, inLeft, order - 1);
        root.right = helper(preOrder, inOrder, order + 1, inRight);
        return root;
    }
}
