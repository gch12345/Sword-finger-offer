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
}
