package Holiday;

public class day2 {
    //给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
    //不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
    //元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素
    public int removeElement(int[] nums, int val) {
        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[ret++] = nums[i];
            }
        }
        return ret;
    }
//    给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
//    如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
//    你可以假设数组中无重复元素。
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else{
                right = mid - 1;
            }
        }
        return left;
    }
}
