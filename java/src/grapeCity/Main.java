package grapeCity;

import java.util.*;

public class Main {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> order(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        ArrayList<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            list.add(queue.peek().val);
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
        }
        return list;
    }

    public static int work(int[] works) {
        if (works == null || works.length == 0) {
            return 0;
        }
        // 0 没工作
        int[][] dp = new int[works.length + 1][2];
        for (int i = 1; i <= works.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][0]);
            dp[i][1] = dp[i - 1][0] + works[i - 1];
        }
        return Math.max(dp[works.length][0], dp[works.length][1]);
    }

    public static String fun(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int index = -1;
        int count = 0;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                if (count > maxLen) {
                    maxLen = count;
                    index = i - count;
                }
                count = i - map.get(chars[i]);
            } else {
                count++;
            }
            map.put(chars[i], i);
        }
        if (index == -1) {
            return str;
        } else {
            return str.substring(index, index + maxLen);
        }
    }

    public static void main(String[] args) {
//        int[] works = {2,1,4,5,3,1,1,3};
//        System.out.println(work(works));
        System.out.println(fun("aasdfadhj123451"));
    }
}
