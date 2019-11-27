package BinarySearchTree;

public class BinarySearchTree {
    static class Node {
        int key;
        int val;
        Node left;
        Node right;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", val=" + val +
                    '}';
        }
    }
    private Node root = null;
    public boolean insert(int key, int val) {
        if (root == null) {
            root = new Node(key, val);
            return true;
        }
        Node cur = root;
        Node parent = null;
        while (cur != null) {
            if (cur.key == key) {
                return false;
            }
            parent = cur;
            if (cur.key < key) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }
        Node node = new Node(key, val);
        if (parent.key > key) {
            parent.left = node;
        } else {
            parent.right = node;
        }
        return true;
    }

    public Node Search(int key) {
        if (root == null) {
            return null;
        }
        Node cur = root;
        while (cur != null) {
            if (cur.key == key) {
                return cur;
            }
            if (cur.key < key) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }
        return null;
    }

    public void remove(int key) {
        Node cur = root;
        Node parent = null;
        while (cur != null) {
            if(cur.key == key) {
                removeNode(cur, parent);
                return;
            } else if (cur.key < key) {
                parent = cur;
                cur = cur.right;
            } else {
                parent = cur;
                cur = cur.left;
            }
        }
    }
    private void removeNode(Node cur, Node parent) {
        if (cur.left == null) {
            if (cur == root) {
                root = cur.right;
            }else if (parent.left == cur) {
                parent.left = cur.right;
            } else {
                parent.right = cur.right;
            }
        } else if (cur.right == null) {
            if (cur == null) {
                root = cur.left;
            } else if (parent.left == cur) {
                parent.left = cur.left;
            } else {
                parent.right = cur.left;
            }
        } else {
            Node scapeGoat = cur.right;
            Node goatParent = null;
            while (scapeGoat != null) {
                scapeGoat = scapeGoat.left;
            }
            cur.key = scapeGoat.key;
            cur.val = scapeGoat.val;
            if (goatParent.left == scapeGoat) {
                goatParent.left = scapeGoat.right;
            } else {
                goatParent.right = scapeGoat.right;
            }
        }
    }

    public static void main(String[] args) {
        BinarySearchTree root = new BinarySearchTree();
        int[] array = {9, 5, 2, 7, 1, 0, 8};
        for (int x : array) {
            root.insert(x, 0);
        }
        System.out.println(root.Search(2));
        root.remove(2);
        System.out.println(root.Search(2));
    }
}
