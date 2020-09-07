package LeetCode;

import java.util.*;

public class Offer2 {
    // 58 - I. 翻转单词顺序
    public String reverseWords0(String s) {
        if (s == null || s.length() < 1) {
            return s;
        }
        s = s.trim();
        String[] strings = s.split(" ");
        StringBuffer stringBuffer = new StringBuffer();
        for (String string : strings) {
            if (string.equals(" ")) {
                continue;
            }
            int index = string.length() - 1;
            while (index >= 0) {
                stringBuffer.append(string.charAt(index));
                index--;
            }
            stringBuffer.append(" ");
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        return stringBuffer.reverse().toString();
    }

    public String reverseWords(String s) {
        if (s == null || s.length() < 1) {
            return s;
        }
        String[] strings = s.trim().split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = strings.length - 1; i > 0; i--) {
            if (strings[i].equals("")) {
                continue;
            }
            stringBuilder.append(strings[i] + " ");
        }
        stringBuilder.append(strings[0]);
        return stringBuilder.toString();
    }

    // 58 - II. 左旋转字符串
    public String reverseLeftWords(String s, int n) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = n; i < s.length() + n; i++) {
            stringBuilder.append(s.charAt(i % s.length()));
        }
        return stringBuilder.toString();
    }

    // 59 - I. 滑动窗口的最大值
    public int[] maxSlidingWindow0(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        Deque<Integer> deque = new LinkedList<>();
        int[] ret = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.pollLast();
            }
            deque.addLast(nums[i]);
        }
        ret[0] = deque.peekFirst();
        for (int i = k; i < nums.length; i++) {
            if (deque.peekFirst() == nums[i - k]) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.pollLast();
            }
            deque.addLast(nums[i]);
            ret[i - k + 1] = deque.peekFirst();
        }
        return ret;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length <= 0) {
            return new int[0];
        }
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        int[] ret = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length - k + 1; i++) {
            if (maxIndex >= i) {
                if (max < nums[i + k - 1]) {
                    maxIndex = i + k - 1;
                    max = nums[i + k - 1];
                }
            } else {
                for (int j = i; j < i + k; j++) {
                    if (max < nums[j]) {
                        max = nums[j];
                        maxIndex = j;
                    }
                }
            }
            ret[i] = max;
        }
        return ret;
    }

    //  59 - II. 队列的最大值
    private Queue<Integer> queue = new LinkedList<>();
    private Deque<Integer> deque = new LinkedList<>();

    public int max_value() {
        if (deque.isEmpty()) {
            return -1;
        }
        return deque.peekFirst();
    }

    public void push_back(int value) {
        queue.add(value);
        while (!deque.isEmpty() && deque.peekLast() < value) {
            deque.removeLast();
        }
        deque.addLast(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }
        if (queue.peek().equals(deque.peekFirst())) {
            deque.removeFirst();
        }
        return queue.poll();
    }

    // 60. n个骰子的点数
    public double[] twoSum(int n) {
        if (n <= 0) {
            return new double[0];
        }
        double[][] dp = new double[n + 1][6 * n + 1];
        for (int i = 0; i < 7; i++) {
            dp[1][i] = 1 / 6.0;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= i * 6; j++) {
                for (int k = 1; k <= 6; k++) {
                    if (j - k <= 0) {
                        break;
                    }
                    dp[i][j] += dp[i - 1][j - k] / 6.0;
                }
            }
        }
        double[] ret = new double[n * 6 - n + 1];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = dp[n][i + n];
        }
        return ret;
    }

    // 61. 扑克牌中的顺子
    public boolean isStraight0(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return true;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min && nums[i] != 0) {
                min = nums[i];
            }
        }
        int count = 0;
        int[] map = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - min >= map.length) {
                return false;
            }
            if (nums[i] == 0) {
                count++;
                continue;
            }
            map[nums[i] - min] = 1;
        }
        for (int i = 0; i < map.length; i++) {
            if (map[i] == 0) {
                count--;
            }
        }
        if (count < 0) {
            return false;
        }
        return true;
    }

    public boolean isStraight(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return true;
        }
        int len = nums.length;
        int[] map = new int[13];
        int min = 14;
        int max = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                continue;
            }
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
            if (map[nums[i] - 1] == 1) {
                return false;
            }
            map[nums[i] - 1] = 1;
        }
        return max - min < nums.length;
    }

    //  62. 圆圈中最后剩下的数字
    //0 1 2 3 4
    //0 1 3 4  : 2
    //1 3 4  : 0
    //1 3 ：4
    //3 ：1
    public int lastRemaining0(int n, int m) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arrayList.add(i);
        }
        int index = 0;
        while (n > 1) {
            index = (index + m - 1) % n;
            arrayList.remove(index);
            n--;
        }
        return arrayList.get(0);
    }

    // 逆推
    public int lastRemaining(int n, int m) {
        int ans = 0;
        for (int i = 2; i < n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }

    //  63. 股票的最大利润
    // dp[天数][手中是否有股票]
    public int maxProfit0(int[] prices) {
        int[][] dp = new int[prices.length + 1][2];
        dp[0][0] = 0;
        dp[0][1] = Integer.MIN_VALUE;
        for (int i = 1; i <= prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 1]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i - 1]);
        }
        return dp[prices.length][0];
    }

    //dp[i] = max(dp[i - 1], prices[i] - min(prices[i], 前几天价格最低的))
    public int maxProfit1(int[] prices) {
        int min = Integer.MAX_VALUE;
        int[] dp = new int[prices.length + 1];
        for (int i = 1; i < dp.length; i++) {
            min = Math.min(prices[i - 1], min);
            dp[i] = Math.max(dp[i - 1], prices[i - 1] - min);
        }
        return dp[prices.length];
    }

    public int maxProfit(int[] prices) {
        int cost = Integer.MIN_VALUE;
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            profit = Math.max(profit, cost + prices[i]);
            cost = Math.max(cost, -prices[i]);
        }
        return profit;
    }

    // 64. 求1+2+…+n
    int sum = 0;
    public int sumNums(int n) {
        boolean bool = n > 1 && sumNums(n - 1) > 0;
        sum += n;
        return sum;
    }

    // 65. 不用加减乘除做加法
    public int add(int a, int b) {
        while (b != 0) {
            int temp = (a & b) << 1;
            a = a ^ b; // 非进位和
            b = temp; // 进位
        }
        return a;
    }

    // 66. 构建乘积数组
    public int[] constructArr(int[] a) {
        if (a == null || a.length == 0) {
            return new int[0];
        }
        int[] b1 = new int[a.length];
        int[] b2 = new int[a.length];
        b1[0] = 1;
        b2[a.length - 1] = 1;
        // 下三角
        for (int i = 1; i < a.length; i++) {
            b1[i] = b1[i - 1] * a[i];
        }
        // 上三角
        for (int i = a.length - 1; i >= 0; i--) {
            b2[i] = b2[i + 1] * a[i];
        }
        // 合并
        for (int i = 0; i < a.length; i++) {
            b1[i] *= b2[i];
        }
        return b1;
    }

    // 68 - II. 二叉树的最近公共祖先
    TreeNode ret = null;
    public TreeNode lowestCommonAncestor0(TreeNode root, TreeNode p, TreeNode q) {
        help(root, p, q);
        return ret;
    }
    private boolean help(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        int left = help(root.left, p, q) ? 1 : 0;
        int right = help(root.right, p, q) ? 1 : 0;
        int mid = (root == p || root == q) ? 1 :0;
        if (mid + left + right >= 2) {
            ret = root;
        }
        return (mid + left + right) > 0;
    }

    // 68 - I. 二叉搜索树的最近公共祖先
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else {
                break;
            }
        }
        return root;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                list.add(cur.val);
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            lists.add(0, list);
        }
        return lists;
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        Stack<TreeNode> stack0 = new Stack<>();
        Stack<TreeNode> stack1 = new Stack<>();
        int star = 0;
        stack0.add(root);
        while (!stack0.isEmpty() || !stack1.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            if (star == 0) {
                while (!stack0.isEmpty()) {
                    TreeNode cur = stack0.pop();
                    list.add(cur.val);
                    if (cur.left != null) {
                        stack1.add(cur.left);
                    }
                    if (cur.right != null) {
                        stack1.add(cur.right);
                    }
                }
                star = 1;
            } else {
                while (!stack1.isEmpty()) {
                    TreeNode cur = stack1.pop();
                    list.add(cur.val);
                    if (cur.right != null) {
                        stack0.add(cur.right);
                    }
                    if (cur.left != null) {
                        stack0.add(cur.left);
                    }
                }
                star = 0;
            }
            lists.add(list);
        }
        return lists;
    }

    public static Integer find(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        int index = arr[0];
        while (arr[0] != arr[index]) {
            index = arr[0];
            int temp = arr[index];
            arr[index] = arr[0];
            arr[0] = temp;
        }
        return arr[0];
    }

    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                int temp = nums[i];
                nums[i] = nums[nums[i]];
                nums[temp] = temp;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        TreeNode head = new TreeNode(0);
//        head.left = new TreeNode(1);
//        head.right = new TreeNode(2);
//        head.right.left = new TreeNode(3);
//        head.right.right = new TreeNode(4);
//        zigzagLevelOrder(head);
        int[] arr = {1,7,2,3,4,5,6,7};
        System.out.println(find(arr));
    }
}
