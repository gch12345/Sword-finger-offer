package Holiday;


public class day1 {
    //实现函数 ToLowerCase()，该函数接收一个字符串参数 str，
    // 并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
    public String toLowerCase(String str) {
        char[] s = str.toCharArray();
        for (int i = 0; i < s.length; i++) {
            if (s[i] < 'A' || s[i] > 'z') {
                continue;
            }
            if (s[i] < 'a') {
                s[i] = (char)(s[i] + 'a' - 'A');
            }
        }
        return new String(s);
    }

    //给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        helper(nums, 0, nums.length - 1);
        helper(nums, 0, k - 1);
        helper(nums, k, nums.length - 1);
    }
    private void helper(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
