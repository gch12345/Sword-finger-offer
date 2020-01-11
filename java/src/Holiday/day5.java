package Holiday;

import java.util.HashSet;
import java.util.Set;

public class day5 {
//    给定一个整数数组，判断是否存在重复元素。
//    如果任何值在数组中出现至少两次，函数返回 true。
//    如果数组中每个元素都不相同，则返回 false。
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            } else {
                set.add(nums[i]);
            }
        }
        return false;
    }

//    你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。
//
//    你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。
    public boolean isLongPressedName(String name, String typed) {
        if (name.length() > typed.length()) {
            return false;
        }
        char[] Name = name.toCharArray();
        char[] Typed = typed.toCharArray();
        int i = 0, j = 0;
        for (; i < Name.length && j < Typed.length;) {
            if (Name[i] == Typed[j]) {
                i++;
                j++;
            } else if (j >= 1 && Typed[j] == Typed[j - 1]) {
                j++;
            } else {
                return false;
            }
        }
        if (i < Name.length) {
            return false;
        }
        return true;
    }
}
