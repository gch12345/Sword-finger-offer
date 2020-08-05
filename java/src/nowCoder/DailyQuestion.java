package nowCoder;

import org.junit.Test;

import java.util.*;

public class DailyQuestion {
    //压缩字符串
    public void day1_0() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.next();
            String ret = helper(str.toCharArray(), 0);
            String[] strings = str.split("]");
            str = strings[strings.length - 1] + "";
            System.out.println(ret + str);
        }
    }
    private String helper(char[] str, int start) {
        if (start >= str.length) {
            return "";
        }
        int i = start;
        for (; i < str.length; i++) {
            if (str[i] == '[') {
                break;
            }
        }
        int j = i + 1;
        String string = "";
        for (; j < str.length; j++) {
            if (str[j] == '[') {
                string = helper(str, j);
            }
            if (str[j] == ']') {
                break;
            }
        }
        String ret = "";
        String cur = "";
        if (i < str.length) {
            int num = 0;
            int h = i + 1;
            for (; h < str.length; h++) {
                if (str[h] >= '0' && str[h] <= '9') {
                    num = num * 10 + str[h] - '0';
                } else {
                    break;
                }
            }
            int k = h + 1;
            for (; k < j && k < str.length; k++) {
                if (str[k] == '[') {
                    break;
                }
                cur = cur + str[k];
            }
            string = cur + string;
            for (k = 0; k < num; k++) {
                ret = "" + ret + string;
            }
        }
        return new String(str, start, i - start) + ret;
    }

    public void day1_1() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String string = sc.next();
            Stack<Character> stack1 = new Stack<>();
            Stack<Character> stack2 = new Stack<>();
            int i = 0;
            char[]  chars = string.toCharArray();
            while (i < string.length()) {
                while (i < string.length() && chars[i] != ']') {
                    stack1.push(chars[i]);
                    i++;
                }
                if (i >= string.length()) {
                    break;
                }
                stack2.clear();
                while (!stack1.isEmpty() && stack1.peek() != '[') {
                    stack2.add(stack1.pop());
                }
                if (!stack1.isEmpty())
                    stack1.pop();
                int num = 0;
                while (!stack2.isEmpty() && stack2.peek() != '|') {
                    num = num * 10 + stack2.pop() - '0';
                }
                String cur = "";
                while (!stack2.isEmpty()) {
                    if (stack2.peek() == '|') {
                        stack2.pop();
                    }
                    cur = cur + stack2.pop();
                }
                String nCur = "";
                for (int k = 0; k < num; k++) {
                    nCur = nCur + cur;
                }
                char[] newChars = nCur.toCharArray();
                for (int k = 0; k < newChars.length; k++) {
                    stack1.push(newChars[k]);
                }
                i++;
            }
            String ret = "";
            while (!stack1.isEmpty()) {
                ret = stack1.pop() + ret;
            }
            System.out.println(ret);
        }
    }

    // 逛街
    public void day2() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            Stack<Integer> stack = new Stack<>();
            int[] left = new int[num];
            int[] right = new int[num];
            int[] arr = new int[num];
            for (int i = 0; i < num; i++) {
                arr[i] = sc.nextInt();
            }
            for (int i = 0; i < num; i++) {
                left[i] = stack.size();
                while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                    stack.pop();
                }
                stack.add(arr[i]);
            }
            stack.clear();
            for (int i = num - 1; i >= 0; i--) {
                right[i] = stack.size() + 1 + left[i];
                while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                    stack.pop();
                }
                stack.add(arr[i]);
            }
            for (int i = 0; i < num; i++) {
                System.out.print(right[i] + " ");
            }
        }
    }

    //假期
    public void day3(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            int[] work = new int[num];
            int[] exercise = new int[num];
            for (int i = 0; i < num; i++) {
                work[i] = sc.nextInt();
            }
            for (int i = 0; i < num; i++) {
                exercise[i] = sc.nextInt();
            }
            //0 工作 1 锻炼 2 休息
            int[][] dp = new int[num + 1][3];
            dp[0][0] = Integer.MAX_VALUE;
            dp[0][1] = Integer.MAX_VALUE;
            dp[0][2] = 0;
            for (int i = 1; i <= num; i++) {
                dp[i][2] = Math.min(Math.min(dp[i - 1][1], dp[i - 1][0]),
                        dp[i - 1][2]) + 1;
                if (work[i - 1] == 1) {
                    dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]);
                } else {
                    dp[i][0] = Integer.MAX_VALUE;
                }
                if (exercise[i - 1] == 1) {
                    dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]);
                } else {
                    dp[i][1] = Integer.MAX_VALUE;
                }
            }
            System.out.println(Math.min(Math.min(dp[num][0], dp[num][1]), dp[num][2]));
        }
    }

    //视野争夺
    public static void day4() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            int len = sc.nextInt();
            List<point> list = new ArrayList<>();
            for (int i = 0; i < num; i++) {
                int left = sc.nextInt();
                int right = sc.nextInt();
                list.add(new point(left, right));
            }
            Collections.sort(list);
            int count = 0;
            int last = 0;
            for (int i = 0; i < num;) {
                int max =0;
                while (i < num && list.get(i).left <= last) {
                    max = Math.max(max, list.get(i).right);
                    i++;
                }
                last = max;
                count++;
                if (i < num && list.get(i).left > last) {
                    count = -1;
                    break;
                }
                if (last >= len) {
                    break;
                }
            }
            if (last < len) {
                System.out.println(-1);
            } else {
                System.out.println(count);
            }
        }
    }

    public void fun() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.next();
            char[] chars = str.toCharArray();
            Set<Character> set = new HashSet<>();
            int i = 0;
            for (; i < chars.length; i++) {
                if (set.contains(chars[i])) {
                    continue;
                }
                int j = i + 1;
                for (; j < chars.length; j++) {
                    if (chars[j] == chars[i]) {
                        set.add(chars[i]);
                        break;
                    }
                }
                if (j == chars.length) {
                    break;
                }
            }
            if (i >= chars.length) {
                System.out.println(-1);
            } else {
                System.out.println(chars[i]);
            }
        }
    }

    public void fun1() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            int[] arr = new int[num];
            for (int i = 0; i < num; i++) {
                arr[i] = sc.nextInt();
            }
            int curNum = arr[0];
            int count = 1;
            for (int i = 1; i < num; i++) {
                if (count == 0) {
                    curNum = arr[i];
                    count = 1;
                    continue;
                }
                if (arr[i] == curNum) {
                    count++;
                } else {
                    count--;
                }
            }
            count = 0;
            for (int i = 0; i < num; i++) {
                if (arr[i] == curNum) {
                    count++;
                }
            }
            if (count > num / 2) {
                System.out.println(curNum);
            } else {
                System.out.println(-1);
            }
        }
    }

    public static void grade() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            int[] arr = new int[num];
            Map<Integer, Integer> map = new HashMap<>();
            int sum = 0;
            for (int i = 0; i < num; i++) {
                arr[i] = sc.nextInt();
                if (map.containsKey(arr[i])) {
                    map.put(arr[i], map.get(arr[i]) + 1);
                } else {
                    map.put(arr[i], 1);
                }
            }
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                int id = sc.nextInt();
                double count = 0;
                for (int j = 0; j <= arr[id - 1]; j++) {
                    if (map.containsKey(j)) {
                        count += map.get(j);
                    }
                }
                System.out.printf("%f\n", ((count - 1) / num) * 100);
            }
        }
    }

    public static void fun3() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            for (int i = 0; i < num; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                int star = sc.nextInt();
                int[][] arr = new int[x  + 10][y + 10];
                for (int j = 0; j < star; j++) {
                    int m = sc.nextInt();
                    int n = sc.nextInt();
                    arr[m][n] = 1;
                }
                int m = sc.nextInt();
                int n = sc.nextInt();
                for (int j = 1; j <= x; j++) {
                    for (int k = 1; k <= y; k++) {
                        arr[j][k] += arr[j - 1][k] + arr[j][k - 1] - arr[j - 1][k - 1];
                    }
                }
                boolean flag = false;
                for (int row = 1; row <= x - m + 1; row++) {
                    for (int col = 1; col <= y - n + 1; col++) {
                        int count = arr[row + m - 1][col + n - 1] - arr[row + m - 1][col - 1] - arr[row - 1][col + n - 1] + arr[row - 1][col - 1];
                        if (count == 0) {
                            flag = true;
                            break;
                        }
                    }
                    if (flag) {
                        break;
                    }
                }
                if (flag) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    public static void main(String[] args) {
        ArrayList list = new ArrayList(0);
        list.add(1);
//        System.out.println(list.toString());
        DailyQuestion dailyQuestion = new DailyQuestion();
        fun3();
//        dailyQuestion.fun1();
        //dailyQuestion.day2();
    }
}

class point implements Comparable<point>{
    int left;
    int right;
    public point(int left, int right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int compareTo(point o) {
        if (left < o.left) {
            return -1;
        } else if (left > o.left) {
            return 1;
        } else {
            return 0;
        }
    }
}

