package LeetCode;

public class DailyQuestion0 {
    int count = 0;
    public int reversePairs(int[] nums) {
        merge(nums, 0, nums.length - 1);
        return count;
    }

    private void merge(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (right - left) / 2 + left;
        merge(nums, left, mid);
        merge(nums, mid + 1, right);
        int i = left;
        int j = mid + 1;
        int[] temp = new int[right - left + 1];
        int k = 0;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                count += mid - i + 1;
                temp[k++] = nums[j++];
            }
        }
        if (i > mid) {
            while (j <= right) {
                temp[k++] = nums[j++];
            }
        } else {
            while (i <= mid) {
                temp[k++] = nums[i++];
            }
        }
        for (i = left; i <= right; i++) {
            nums[i] = temp[i - left];
        }
    }
}
