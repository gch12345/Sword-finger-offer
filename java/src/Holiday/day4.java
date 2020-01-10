package Holiday;

public class day4 {
//    给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
//    如果不存在最后一个单词，请返回 0 。
//    说明：一个单词是指由字母组成，但不包含任何空格的字符串。
    public int lengthOfLastWord(String s) {
        char[] str = s.toCharArray();
        int ret = 0;
        int i = str.length - 1;
        while (i >= 0 && str[i] == ' ') {
            i--;
        }
        while (i >= 0 && str[i] != ' ') {
            ret++;
            i--;
        }
        return ret;
    }

    public int lengthOfLastWord0(String s) {
        s = s.trim();
        int index = s.lastIndexOf(' ') + 1;
        return s.substring(index).length();
    }

//    给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
//    说明:
//    初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
//    你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = m + n - 1;
        m -= 1;
        n -= 1;
        while (m >= 0 && n >= 0) {
            if (nums1[m] > nums2[n]) {
                nums1[p--] = nums1[m--];
            } else {
                nums1[p--] = nums2[n--];
            }
        }
        if (m < 0) {
            while (n >= 0) {
                nums1[p--] = nums2[n--];
            }
        }
    }
}
