package binaryTree;

class TreeNode {
    char val;
    TreeNode left;
    TreeNode right;

    public TreeNode(char val) {
        this.val = val;
    }
}
public class binaryTree {
    private static TreeNode Root = null;
    public static TreeNode Bulid() {
        TreeNode A = new TreeNode('A');
        TreeNode B = new TreeNode('B');
        TreeNode C = new TreeNode('C');
        TreeNode D = new TreeNode('D');
        TreeNode E = new TreeNode('E');
        TreeNode F = new TreeNode('F');
        TreeNode G = new TreeNode('G');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        E.left = G;
        C.right = F;
        return A;
    }

    //先序遍历
    public static void preorder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        preorder(root.left);
        preorder(root.right);
    }

    //中序遍历
    public static void traversal(TreeNode root) {
        if (root == null) {
            return;
        }
        traversal(root.left);
        System.out.println(root.val);
        traversal(root.right);
    }

    //后序遍历
    public  static void postorder(TreeNode root) {
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.println(root.val);
    }

    //节点个数
    public static int nodeNum (TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + nodeNum(root.left) + nodeNum(root.right);
    }

    //叶子节点个数
    public static int leafNodeNum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return leafNodeNum(root.left) + leafNodeNum(root.right);
    }

    //检查两颗树是否相同
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        boolean left = isSameTree(p.left, q.left);
        boolean right = isSameTree(p.right, q.right);
        if (left && right) {
            return true;
        }
        return false;
    }

    //另一个树的子树
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (isSameTree(s, t)){
            return true;
        }
        boolean left = isSubtree(s.left, t);
        boolean right = isSubtree(s.right, t);
        return left || right;
    }

    //二叉树的最大深度
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return 1 + (left > right ? left : right);
    }

    //平衡二叉树
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if (left - right > 1 || left - right < -1) {
            return false;
        }
        boolean Left =  isBalanced(root.left);
        boolean Right =  isBalanced(root.right);
        return Left && Right;
    }

    //对称二叉树
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left.val != root.right.val) {
            return false;
        }
        boolean left = isSymmetric(root.left);
        boolean right = isSymmetric(root.right);
        return left && right;
    }

    public static void main(String[] args) {
        TreeNode root = Bulid();
        System.out.println(leafNodeNum(root));
    }
}
