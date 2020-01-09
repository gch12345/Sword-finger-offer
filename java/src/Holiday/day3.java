package Holiday;

import java.util.HashMap;
import java.util.Map;

public class day3 {

//  判断第一个字符串ransom能不能由第二个字符串magazines里面的字符构成。
//  如果可以构成，返回 true ；否则返回 false。
    public boolean canConstruct0(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        char[] charMagazine = magazine.toCharArray();
        for (int i = 0; i < charMagazine.length; i++) {
            if (map.containsKey(charMagazine[i])) {
                map.put(charMagazine[i], map.get(charMagazine[i]) + 1);
            } else {
                map.put(charMagazine[i], 1);
            }
        }
        char[] charRansomNote = ransomNote.toCharArray();
        for (int i = 0; i < charRansomNote.length; i++) {
            if (map.containsKey(charRansomNote[i])) {
                if (map.get(charRansomNote) == 1) {
                    map.remove(charRansomNote[i]);
                } else {
                    map.put(charRansomNote[i], map.get(charRansomNote[i]) - 1);
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean canConstruct1(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] arr = new int[26];
        for (char x : ransomNote.toCharArray()) {
            int index = magazine.indexOf(x, arr[x - 'a']);
            if (index == -1) {
                return false;
            }
            arr[x - 'a'] = index + 1;
        }
        return true;
    }
//    判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
    public boolean isPalindrome(int x) {
        int num = 0;
        int start = x;
        while (x > 0) {
            num = num * 10 + (x % 10);
            x /= 10;
        }
        if (num == start) {
            return true;
        } else {
            return false;
        }
    }
}
