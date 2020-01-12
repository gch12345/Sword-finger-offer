package Holiday;

public class day6 {
//    给定一个按非递减顺序排序的整数数组 A，
//   返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
    public int[] sortedSquares(int[] A) {
        int num = 0;
        int[] ret = new int[A.length];
        while (num < A.length && A[num] < 0) {
            num++;
        }
        int start = num;
        num -= 1;
        int len = 0;
        while (num >= 0 && start < A.length) {
            if (A[num] * A[num] < A[start] * A[start]) {
                ret[len++] = A[num] * A[num];
                num--;
            } else {
                ret[len++] = A[start] * A[start];
                start++;
            }
        }
        while (num >= 0) {
            ret[len++] = A[num] * A[num];
            num--;
        }
        while (start < A.length) {
            ret[len++] = A[start] * A[start];
            start++;
        }
        return ret;
    }

//    给定一个字符串 S，返回 “反转后的” 字符串，
//   其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
    public String reverseOnlyLetters(String S) {
        char[] arr =S.toCharArray();
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            if (arr[i] < 'A' || arr[i] > 'z' || (arr[i] > 'Z' && arr[i] < 'a')) {
                i++;
            } else if (arr[j] < 'A' || arr[j] > 'z' || (arr[j] > 'Z' && arr[j] < 'a')) {
                j--;
            } else {
                char temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                i++;
                j--;
            }
        }
        return new String(arr);
    }
}
