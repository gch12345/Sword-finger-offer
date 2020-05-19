package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Backtrack {
    public List<String> letterCombinations(String digits) {
        List<String> ret = new ArrayList<>();
        if (digits == null) {
            return ret;
        }
        back(ret, digits, 0, "");
        return ret;
    }
    private String[] strings = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private void back (List<String> list, String digits, int index, String cur) {
        if (cur.length() == digits.length()) {
            list.add(cur);
            return;
        }
        int Index = digits.charAt(index) - '0';
        for (int i = 0; i < strings[Index].length(); i++) {
            back(list, digits, index + 1, cur + strings[Index].charAt(i));
        }
    }

    private int[] getStrings = {1, 2, 4, 8, 16, 32, 1, 2, 4, 8};
    public List<String> readBinaryWatch(int num) {
        List<String> list = new ArrayList<>();
        if (num == 0) {
            list.add("0:00");
            return list;
        }
        if (num < 0) {
            return list;
        }
        readBinaryWatchBack(list, 0, 0, num, 0, 0);
        return list;
    }
    private void readBinaryWatchBack(List<String> list, int H, int S, int sum, int index, int start) {
        if (index >= sum) {
            String stringH = H + "";
            String stringS = S + "";
            if (S < 10) {
                stringS = "0" + stringS;
            }
            list.add(stringH + ":" + stringS);
            return;
        }
        for (int i = start; i < getStrings.length; i++) {
            if (i <= 5) {
                if (S + getStrings[i] >= 60) {
                    continue;
                }
                readBinaryWatchBack(list, H, S + getStrings[i], sum, index + 1, i + 1);
            } else {
                if (H + getStrings[i] >= 13) {
                    return;
                }
                readBinaryWatchBack(list, H + getStrings[i], S, sum, index + 1, i + 1);
            }
        }
    }

    public static void main(String[] args) {
        Backtrack backtrack = new Backtrack();
        backtrack.readBinaryWatch(2);
    }
}
