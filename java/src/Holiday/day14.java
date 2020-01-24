package Holiday;

import java.util.ArrayList;
import java.util.List;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }
public class day14 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> lists = new ArrayList<>();
        helper(lists, 0, root);
        for (List<Integer> l : lists) {
            list.add(l.get(l.size() - 1));
        }
        return list;
    }
    private void helper(List<List<Integer>> lists, int lay, TreeNode root) {
        if (root == null) {
            return;
        }
        if (lists.size() <= lay) {
            lists.add(new ArrayList<>());
        }
        lists.get(lay).add(root.val);
        helper(lists, lay + 1, root.left);
        helper(lists, lay + 1, root.right);
    }

    List<Integer> list = new ArrayList<>();
    public List<Integer> rightSideView0(TreeNode root) {
        helper(root, 0);
        return list;
    }
    public void helper(TreeNode root, int n) {
        if (root == null) return;
        if (n == list.size()) list.add(root.val);
        helper(root.right, n + 1);
        helper(root.left, n + 1);
    }

    public boolean isMatch(String s, String p) {
        int starS = -1;
        int starP = -1;
        int i = 0;
        int j = 0;
        int k = p.length();
        while (i < s.length()) {
            if (j < p.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
                i++;
                j++;
                continue;
            }
            if (p.length() > j && p.charAt(j) == '*') {
                starP = j++;
                starS = i;
                continue;
            }
            if (starP != -1) {
                i = ++starS;
                j = starP + 1;
                continue;
            }
            return false;
        }
        while (p.length() > j && p.charAt(j) == '*') {
            ++j;
        }
        if (j == p.length() && i == s.length()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "aaa";
        String p = "***a";
        day14 d = new day14();
        d.isMatch(s, p);
    }
}
