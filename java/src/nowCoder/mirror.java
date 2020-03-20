package nowCoder;

import java.util.LinkedList;
import java.util.Queue;

public class mirror {
    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        Mirror(root.left);
        Mirror(root.right);
        TreeNode node  = root.left;
        root.left = root.right;
        root.right = node;
    }
}
