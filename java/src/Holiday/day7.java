package Holiday;

public class day7 {
//  给定一个非负整数数组 A，返回一个数组，在该数组中，
//  A 的所有偶数元素之后跟着所有奇数元素。
    public int[] sortArrayByParity(int[] A) {
        int i = 0;
        int j = A.length - 1;
        while (i < j) {
            while (i < j && (A[i] % 2 == 0)) {
                i++;
            }
            while (i < j && (A[j] % 2 == 1)) {
                j--;
            }
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }
        return A;
    }
//    给定一个整数类型的数组 nums，请编写一个能够返回数组“中心索引”的方法。
//    我们是这样定义数组中心索引的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
//    如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。

    public int pivotIndex(int[] nums) {
        int sum = 0, leftsum = 0;
        for (int x: nums) {
            sum += x;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (leftsum == sum - leftsum - nums[i]) {
                return i;
            }
            leftsum += nums[i];
        }
        return -1;
    }
}
