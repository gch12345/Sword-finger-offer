package nowCoder;

public class MinNumberInRotateArray {
    public int minNumberInRotateArray(int [] array) {
        if (array.length == 0) {
            return 0;
        }
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            //确认子数组是否是类似1,1,2,4,5,..,7的非递减数组
            if (array[left] < array[right]) {
                return array[left];
            }
            int mid = (left + right) / 2;

            //如果左半数组为有序数组
            if (array[mid] > array[left]) {
                left = mid + 1;
            } else if (array[mid] < array[right]) {
                right = mid;
//           否则array[left] == array[mid] == array[right]
            } else {
                left++;
            }
        }
        return array[left];
    }
}
