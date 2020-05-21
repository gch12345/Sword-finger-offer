package LeetCode;

import Practice.A;
import org.junit.Test;

import java.util.*;

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

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return lists;
        }
        combinationSumBack(lists, candidates, target, 0, new ArrayList<>(), 0);
        return lists;
    }

    private void combinationSumBack(List<List<Integer>> lists, int[] candidate,
                                    int target, int startIndex, List<Integer> list, int sum) {
        if (target < sum) {
            return;
        }
        if (target == sum) {
            List<Integer> solution = new ArrayList<>();
            Collections.copy(solution, list);
            lists.add(solution);
            return;
        }
        if (startIndex == candidate.length) {
            return;
        }
        for (int i = startIndex; i < candidate.length; i++) {
            list.add(candidate[i]);
            combinationSumBack(lists, candidate, target, i, list, sum + candidate[i]);
            list.remove(list.size() - 1);
        }
    }

    public int numTilePossibilities(String tiles) {
        if (tiles == null || tiles.length() == 0) {
            return 0;
        }
        int[] map = new int[tiles.length()];
        return numTilePossibilitiesBack(tiles, new LinkedHashSet<>(), "", map);
    }

    private int numTilePossibilitiesBack(String tiles, Set<String> set, String solution, int[] map) {
        if (solution.length() >= tiles.length()) {
            return 0;
        }
        int ret = 0;
        for (int i = 0; i < tiles.length(); i++) {
            String cur = solution + tiles.charAt(i);
            if (!set.contains(cur) && map[i] == 0) {
                map[i] = 1;
                ret++;
                set.add(cur);
                ret = ret + numTilePossibilitiesBack(tiles, set, cur, map);
                map[i] = 0;
            }
        }
        return ret;
    }

    class pair {
        int x;
        int y;

        public pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> lists = new ArrayList<>();
        if (n <= 0) {
            return lists;
        }
        if (n == 1) {
            List<String> solution = new ArrayList<>();
            solution.add("Q");
            lists.add(solution);
            return lists;
        }
        List<pair> pairList = new ArrayList<>();
        solveNQueensBack(n, pairList, lists, 0);
        return lists;
    }

    private void solveNQueensBack(int n, List<pair> list, List<List<String>> lists, int curRow) {
        if (curRow >= n) {
            List<String> solution = new ArrayList<>();
            char[][] chars = new char[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    chars[i][j] = '.';
                }
            }
            for (int i = 0; i < n; i++) {
                pair pair = list.get(i);
                chars[pair.x][pair.y] = 'Q';
            }
            for (int i = 0; i < n; i++) {
                solution.add(new String(chars[i]));
            }
            lists.add(solution);
        }
        for (int i = 0; i < n; i++) {
            int j = 0;
            for (; j < list.size(); j++) {
                pair pair = list.get(j);
                if ((pair.x + pair.y == curRow + i) || (pair.x - pair.y == curRow - i) || (pair.y == i)) {
                    break;
                }
            }
            if (j == list.size()) {
                list.add(new pair(curRow, i));
                solveNQueensBack(n, list, lists, curRow + 1);
                list.remove(list.size() - 1);
            }
        }
    }

    static class stu{
        int name;
        int age;

        public stu(int name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "stu{" +
                    "name=" + name +
                    ", age=" + age +
                    '}';
        }
    }
    public static void main(String[] args) {
        List<stu> src = new ArrayList<>();
        stu stu1 = new stu(0, 0);
        src.add(stu1);
        List<stu> dic = new ArrayList<>(Arrays.asList(new stu[src.size()]));
        Collections.copy(dic, src);
        System.out.println(dic.get(0));
        stu1.age = -1;
        System.out.println(dic.get(0));
    }

    @Test
    public void t0() {
        Backtrack backtrack = new Backtrack();
        backtrack.solveNQueens(4);
        System.out.println(backtrack.numTilePossibilities("AB"));
    }
}
