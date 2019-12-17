package LeetCode;
//数组中的第K个最大元素
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        for (int i = (k - 1 - 1) / 2; i >= 0; i--) {
            shiftDown(nums, k, i);
        }
        for (int i = k; i < nums.length; i++) {
            if (nums[i] < nums[0]) {
                continue;
            }
            int temp =  nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            shiftDown(nums, k, 0);
        }
        return nums[0];
    }

    private void shiftDown(int[] nums, int k, int num) {
        int parent = num;
        int child = parent * 2 + 1;
        while (child < k) {
            if (child < k - 1 && nums[child] > nums[child + 1]) {
                child = child + 1;
            }
            if (nums[child] < nums[parent]) {
                int temp = nums[child];
                nums[child] = nums[parent];
                nums[parent] = temp;
            } else {
                break;
            }
            parent = child;
            child = parent * 2 + 1;
        }
    }
}
