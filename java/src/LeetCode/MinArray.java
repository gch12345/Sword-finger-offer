package LeetCode;

public class MinArray {
    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        if (numbers[left] <= numbers[right]) {
            return numbers[left];
        }
        int mid = (right + left) / 2;
        while (left <= right) {
            mid = (right + left) / 2;
            if (numbers[mid] <= numbers[right]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return numbers[mid];
    }
}
