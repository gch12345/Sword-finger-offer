package Holiday;

public class day8 {
//    给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
//    最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
//    你可以假设除了整数 0 之外，这个整数不会以零开头

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

//    给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
    public int thirdMax(int[] nums) {
        long one = Long.MIN_VALUE;
        long tow = Long.MIN_VALUE;
        long three = Long.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > one) {
                three = tow;
                tow = one;
                one = nums[i];
            } else if (nums[i] > tow && nums[i] != one) {
                three = tow;
                tow = nums[i];
            } else if (nums[i] > three && nums[i] != tow && nums[i] != one) {
                three = nums[i];
            }
        }
        if (three == Long.MIN_VALUE) {
            return (int)one;
        }
        return (int)three;
    }
}
