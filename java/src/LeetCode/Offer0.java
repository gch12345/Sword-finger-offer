package LeetCode;

import java.util.*;

public class Offer0 {

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }
    }

    //  二叉搜索树与双向链表
    public Node treeToDoublyList0(Node root) {
        if (root == null) {
            return root;
        }
        if (root.left == null && root.right == null) {
            return root;
        }
        Node left = treeToDoublyList0(root.left);
        Node node = left;
        while (node != null && node.right != null) {
            node = node.right;
        }
        if (node != null) {
            root.left = node;
            node.right = root;
        }
        Node right = treeToDoublyList0(root.right);
        if (right != null) {
            root.right = right;
            right.left = root;
        }
        return left == null ? root : left;
    }

    Node prev;
    Node head;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        head.left = prev;
        prev.right = head;
        return head;
    }
    private void dfs(Node root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (prev == null) {
            head = root;
        } else {
            prev.right = root;
        }
        root.left = prev;
        prev = root;
        dfs(root.right);
    }

    public String serialize0(TreeNode root) {
        if (root == null) {
            return new String();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuilder stringBuilder = new StringBuilder();
        String string = null;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int nullSize = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    queue.add(node.left);
                    queue.add(node.right);
                    stringBuilder.append(node.val);
                } else {
                    nullSize++;
                    stringBuilder.append("null");
                }
                stringBuilder.append(",");
            }
            if (nullSize == size) {
                string = stringBuilder.substring(0, stringBuilder.length() - 5 * size - 1);
                break;
            }
        }
        return string;
    }

    public String serialize(TreeNode root) {
        if (root == null) {
            return new String();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuilder stringBuilder = new StringBuilder();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                stringBuilder.append(node + ",");
                queue.add(node.left);
                queue.add(node.right);
            } else {
                stringBuilder.append("null,");
            }
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }


        public TreeNode deserialize0(String data) {
        if (data == null) {
            return null;
        }
        String[] strings = data.split(",");
        Queue<String> queue = new LinkedList<>();
        Collections.addAll(queue, strings);
        TreeNode root = null;
        Queue<TreeNode> curQueue = new LinkedList<>();
        int size = 0;
        while (!queue.isEmpty()) {
            if (size == 0) {
                String string = queue.poll();
                root = new TreeNode(Integer.parseInt(string));
                curQueue.add(root);
                size = 1;
                continue;
            } else {
                for (int i = 0; i < size && !queue.isEmpty(); i++) {
                    TreeNode cur = curQueue.poll();
                    String string = queue.peek();
                    if (cur != null) {
                        if ("null".equals(string)) {
                            cur.left = null;
                        } else {
                            cur.left = new TreeNode(Integer.parseInt(string));
                        }
                        queue.poll();
                        string = queue.poll();
                        if ("null".equals(string)) {
                            cur.right = null;
                        } else {
                            cur.right = new TreeNode(Integer.parseInt(string));
                        }
                        curQueue.add(cur.left);
                        curQueue.add(cur.right);
                    } else {
                        curQueue.add(null);
                        curQueue.add(null);
                    }
                }
            }
            size *= 2;
        }
        return root;
    }

    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        String[] strings = data.split(",");
        int index = 0;
        TreeNode root = new TreeNode(Integer.parseInt(strings[index++]));
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (!"null".equals(strings[index])) {
                cur.left = new TreeNode(Integer.parseInt(strings[index]));
                queue.add(cur.left);
            }
            index++;
            if (!"null".equals(strings[index])) {
                cur.right = new TreeNode(Integer.parseInt(strings[index]));
                queue.add(cur.right);
            }
            index++;
        }
        return root;
    }

    public void post(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        post(root.left);
        post(root.right);
    }

    //字符串的排列
    public String[] permutation0(String s) {
        if (s == null || s.length() == 0) {
            return new String[0];
        }
        Set<String> solutions = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        dfs(solutions, set, s.toCharArray(), new char[s.length()]);
        int size = solutions.size();
        String[] strings = new String[size];
        int index = 0;
        for (String str : solutions) {
            strings[index++] = str;
        }
        return strings;
    }
    private void dfs(Set<String> solutions, Set<Integer> set, char[] chars, char[] sol) {
        if (set.size() == chars.length) {
            solutions.add(new String(sol));
        }
        for (int i = 0; i < chars.length; i++) {
            if (set.contains(i)) {
                continue;
            }
            sol[set.size()] = chars[i];
            set.add(i);
            dfs(solutions, set, chars, sol);
            set.remove(i);
        }
    }

    public String[] permutation(String s) {
        if (s == null) {
            return new String[0];
        }
        char[] chars = s.toCharArray();
        ArrayList<String> solutions = new ArrayList<>();
        dfs(chars, 0, solutions);
        return solutions.toArray(new String[solutions.size()]);
    }

    private void dfs(char[] chars, int index, ArrayList<String> solutions) {
        if (index == chars.length - 1) {
            solutions.add(new String(chars));
            return;
        }
        Set<Character> set = new HashSet<>();
        for (int i = index; i < chars.length; i++) {
            if (set.contains(chars[i])) {
                continue;
            }
            set.add(chars[i]);
            swap(chars, index, i);
            dfs(chars, index + 1, solutions);
            swap(chars, index, i);
        }
    }
    private void swap(char[] chars, int a, int b) {
        char ch = chars[a];
        chars[a] = chars[b];
        chars[b] = ch;
    }

    //数组中出现次数超过一半的数字
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        int count = 1;
        int num = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                count = 1;
                num = nums[i];
                continue;
            }
            if (num == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        return num;
    }

    //最小的k个数
    public int[] getLeastNumbers0(int[] arr, int k) {
        if (k < 0 || arr == null || arr.length == 0 || arr.length < k) {
            return new int[0];
        }
        int[] ret = new int[k];
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.naturalOrder());
        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
        }
        for (int i = 0; i < k; i++) {
            ret[i] = queue.poll();
        }
        return ret;
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        if (k < 0 || arr == null || arr.length == 0 || arr.length < k) {
            return new int[0];
        }
        qSort(arr, 0, arr.length - 1, k);
        return Arrays.copyOf(arr, k);
    }
    private void qSort(int[] arr, int left, int right, int k) {
        if (left <= right) {
            return;
        }
        int L = left;
        int R = right;
        int num = arr[left];
        while (L < R) {
            while (L < R && arr[R] >= num) {
                R--;
            }
            while (L < R && arr[L] <= num) {
                L++;
            }
            int temp = arr[R];
            arr[R] = arr[L];
            arr[L] = temp;
        }
        int temp = arr[L];
        arr[L] = arr[left];
        arr[left] = temp;
        if (k < L + 1) {
            qSort(arr, left, L - 1, k);
        } else if (k > L + 1) {
            qSort(arr, L + 1, right, k);
        }
    }

    // 数据流中的中位数
    Queue<Integer> A = new PriorityQueue<>(Comparator.naturalOrder());
    Queue<Integer> B = new PriorityQueue<>(Comparator.reverseOrder());
    public void addNum(int num) {
        if (A.size() == B.size()) {
            A.add(num);
            B.add(A.poll());
        } else {
            B.add(num);
            A.add(B.poll());
        }
    }

    public double findMedian() {
        if (A.size() == B.size()) {
            return (A.peek() + B.peek()) / 2.0;
        } else {
            return B.peek();
        }
    }

    // 42. 连续子数组的最大和
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        int[] dp = new int[nums.length + 1];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < dp.length; i++) {
            if (dp[i - 1] <= 0) {
                dp[i] = nums[i - 1];
            } else {
                dp[i] = dp[i - 1] + nums[i - 1];
            }
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }

    // 43. 1～n整数中1出现的次数
    public int countDigitOne(int n) {
        if (n == 0) {
            return 0;
        }
        if (n < 10) {
            return 1;
        }
        String s = String.valueOf(n);
        int num =  n - ((s.charAt(0) - '0') * (int)Math.pow(10, s.length() - 1));
        return countDigitOne(num) + help(num + 1, n);
    }

    private int help(int start, int end) {
        if (end == 0) {
            return 0;
        }
        if (end < 10) {
            return 1;
        }
        int ret = 0;
        String s = String.valueOf(end);
        if (s.charAt(0) == '1') {
            ret = end - (int)Math.pow(10, s.length() - 1) + 1;
        } else {
            ret = (int)Math.pow(10, s.length() - 1);
        }
        ret = ret + (s.charAt(0) - '0') * (int) Math.pow(10, s.length() - 2) * (s.length() - 1);
        return ret;
    }

    // 45. 把数组排成最小的数

    /**
     * 字符串 x + y > y + x 则 y 应在 x 之前
     *        x + y < y + x 则 x 应在 y 之前
     * 比如 "3" + "30" > "30" + "3" 输出应为 "303"
     *
     * 利用快排快速分割排序。
     * @param nums
     * @return
     */
    public String minNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }
        qSort(strings, 0, strings.length - 1);
        String ret = "";
        for (int i = 0; i < strings.length; i++) {
            ret = ret + strings[i];
        }
        return ret;
    }

    private void qSort(String[] strings, int left, int right) {
        if (left >= right) {
            return;
        }
        int L = left;
        int R = right;
        while (L < R) {
            while (L < R && (strings[R] + strings[left]).compareTo(strings[left] + strings[R]) >= 0) {
                R--;
            }
            while (L < R && (strings[L] + strings[left]).compareTo(strings[left] + strings[L]) <= 0) {
                L++;
            }
            String temp = strings[R];
            strings[R] = strings[L];
            strings[L] = temp;
        }
        String temp = strings[L];
        strings[L] = strings[left];
        strings[left] = temp;
        qSort(strings, left, L - 1);
        qSort(strings, L + 1, right);
    }

    // 46. 把数字翻译成字符串
    int count = 0;
    public int translateNum(int num) {
        if (num < 0) {
            return -1;
        }
        char[] chars = String.valueOf(num).toCharArray();
        helper(chars, 0);
        return count;
    }

    private void helper(char[] chars, int index) {
        if (index == chars.length) {
            count++;
            return;
        }
        int minNum = chars[index] - '0';
        int maxNum = Integer.MAX_VALUE;
        if (index < chars.length - 1) {
            maxNum = (chars[index] - '0') * 10 + chars[index + 1] - '0';
        }
        helper(chars, index + 1);
        if (maxNum <= 35) {
            helper(chars, index + 2);
        }
    }

    // 47. 礼物的最大价值
    public int maxValue(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return -1;
        }
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < col; i++) {
            dp[0][i] = grid[0][i] + dp[0][i - 1];
        }
        for (int i = 1; i < row; i++) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[row - 1][col - 1];
    }

//    48. 最长不含重复字符的子字符串
    public int lengthOfLongestSubstring(String s) {
        if (s ==  null || s.length() == 0) {
            return 0;
        }
        int[] dp = new int[s.length()];
        Map<Character, Integer> map = new HashMap<>();
        dp[0] = 1;
        map.put(s.charAt(0), 0);
        int max = dp[0];
        for (int i = 1; i < s.length(); i++) {
            char ch = s.charAt(i);
            int index = map.getOrDefault(ch, -1);
            if (i - index > dp[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = i - index;
            }
            map.put(ch, i);
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        return max;
    }

    // 49. 丑数
    public int nthUglyNumber(int n) {
        if (n <= 0) {
            return -1;
        }
        int tow = 0;
        int three = 0;
        int five = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(Math.min(dp[tow] * 2, dp[three] * 3), dp[five] * 5);
            if (dp[i] == dp[tow] * 2) {
                tow++;
            }
            if (dp[i] == dp[three] * 3) {
                three++;
            }
            if (dp[i] == dp[five] * 5) {
                five++;
            }
        }
        return dp[n - 1];
    }

    // 50. 第一个只出现一次的字符
    public char firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return ' ';
        }
        Map<Character, Boolean> map = new LinkedHashMap<>();
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            map.put(ch, !map.containsKey(ch));
        }
        for (Map.Entry<Character, Boolean> node : map.entrySet()) {
            if (node.getValue()) {
                return node.getKey();
            }
        }
        return ' ';
    }

    // 51. 数组中的逆序对
    // 归并
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return merge(nums, 0, nums.length - 1);
    }

    private int merge (int[] nums, int left, int right) {
        if (left == right) {
            return 0;
        }
        int mid = (right + left) / 2;
        int leftCount = merge(nums, left, mid);
        int rightCount = merge(nums, mid + 1, right);
        if (nums[mid] <= nums[mid + 1]) {
            return leftCount + rightCount;
        }
        return leftCount + rightCount + helpMerge(nums, left, mid, right);
    }

    private int helpMerge(int[] nums, int left, int mid, int right) {
        int[] arr = new int[right - left + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = nums[left + i];
        }
        int count = 0;
        int i = 0;
        int j = mid - left + 1;
        for (int k = left; k <= right; k++) {
            if (i == mid + 1 - left) {
                nums[k] = arr[j];
                j++;
            } else if (j == right + 1 - left) {
                nums[k] = arr[i];
                i++;
            } else if (arr[i] <= arr[j]) {
                nums[k] = arr[i];
                i++;
            } else {
                nums[k] = arr[j];
                count = count + mid - i + 1;
                j++;
            }
        }
        return count;
    }

    // 52. 两个链表的第一个公共节点
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode l1 = headA;
        ListNode l2 = headB;
        while (l1 != l2) {
            l1 = l1.next == null ? headB : l1.next;
            l2 = l2.next == null ? headA : l2.next;
        }
        return l1;
    }

    // 53 - I. 在排序数组中查找数字 I
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        int mid = (right - left) / 2 + left;
        while (left <= right) {
            if (target == nums[mid]) {
                break;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            mid = (right - left) / 2 + left;
        }
        if (left > right) {
            return 0;
        }
        int count = 1;
        int index = mid - 1;
        while (target == nums[index]) {
            count++;
            index--;
        }
        index = mid + 1;
        while (target == nums[index]) {
            count++;
            index++;
        }
        return count;
    }

    public static void main(String[] args) {
        Offer0 o = new Offer0();
//        System.out.println(o.countDigitOne(12));
//        TreeNode root = new TreeNode(0);
//        root.left = new TreeNode(1);
//        root.right = new TreeNode(2);
//        root.left.right = new TreeNode(3);
//        System.out.println(o.serialize(root));
//        String s = "5,2,3,null,null,2,4,3,1";
//        TreeNode root = o.deserialize(s);
//        System.out.println(o.serialize(root));
//        o.B.add(1);
//        o.B.add(2);
//        System.out.println(o.B.poll());
//        System.out.println(o.B.poll());
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
        // 1→3→5→2→1
        int[][] arr = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(o.maxValue(arr));
    }
}