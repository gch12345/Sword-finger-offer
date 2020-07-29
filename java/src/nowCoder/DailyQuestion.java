package nowCoder;

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

    public static void main(String[] args) {
        DailyQuestion dailyQuestion = new DailyQuestion();
        dailyQuestion.day1_1();
    }
}

