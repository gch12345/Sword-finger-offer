package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class program0 {
    // 01. 判定字符是否唯一
    // 位图
    public boolean isUnique(String astr) {
        long high64 = 0;
        long low64 = 0;
        for (char c : astr.toCharArray()) {
            if (c > 64) {
                long bit = 1L << c - 64;
                if ((bit & high64) > 0) {
                    return false;
                }
                high64 |= bit;
            } else {
                long bit = 1L << c;
                if ((bit & low64) > 0) {
                    return false;
                }
                low64 |= bit;
            }
        }
        return true;
    }

    // 02. 判定是否互为字符重排
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] map = new int[128];
        for (int i = 0; i < s1.length(); i++) {
            map[s1.charAt(i)]++;
            map[s2.charAt(i)]--;
        }
        for (int i = 0; i < 128; i++) {
            if (map[i] != 0) {
                return false;
            }
        }
        return true;
    }

    // 格雷编码
    public List<Integer> grayCode0(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = list.size() - 1; j >= 0; j--) {
                list.add(list.get(j) + head);
            }
            head <<= 1;
        }
        return list;
    }

    public static String[] grayCode(int n) {
        String[] Strings = new String[(int) Math.pow(2, n)];
        if (n == 1) {
            Strings[0] = "0";
            Strings[1] = "1";
            return Strings;
        }
        String[] strings = grayCode(n - 1);
        for (int i = 0; i < strings.length; i++) {
            Strings[i] = "0" + strings[i];
            Strings[Strings.length - 1 - i] = "1" + strings[i];
        }
        return Strings;
    }

    public static void heapSort(int[] arr) {
        creatHeap(arr);
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[0];
            arr[0] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
            shiftDown(arr, 0, arr.length - 1 - 1 - i);
        }
    }

    private static void creatHeap(int[] arr) {
        int index = (arr.length - 1 - 1) / 2;
        for (int i = index; i >= 0; i--) {
            shiftDown(arr, i, arr.length - 1);
        }
    }

    private static void shiftDown(int[] arr, int index, int len) {
        int parent = index;
        int child = index * 2 + 1;
        while (child <= len) {
            if (child + 1 <= len && arr[child] < arr[child + 1]) {
                child = child + 1;
            }
            if (arr[child] > arr[parent]) {
                int temp = arr[parent];
                arr[parent] = arr[child];
                arr[child] = temp;
            }
            parent = child;
            child = parent * 2 + 1;
        }
    }

    public static void shellSort(int[] arr) {
        int gap = arr.length;
        while (gap > 1) {
            shellHelp(arr, gap);
            gap /= 2;
        }
        shellHelp(arr, 1);
    }

    private static void shellHelp(int[] arr, int gap) {
        for (int i = 0; i < arr.length; i++) {
            int j = i;
            int num = arr[i];
            for (; j - gap >= 0 && arr[j - gap] > num; j -= gap) {
                arr[j] = arr[j - gap];
            }
            arr[j] = num;
        }
    }

    // 03. URL化
    public String replaceSpaces0(String S, int length) {
        if (S == null || S.length() == 0) {
            return S;
        }
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = S.toCharArray();
        for (int i = 0; i < length; i++) {
            if (chars[i] == ' ') {
                stringBuilder.append("%20");
            } else {
                stringBuilder.append(chars[i]);
            }
        }
        return stringBuilder.toString();
    }

    public String replaceSpaces(String S, int length) {
        if (S == null || S.length() == 0) {
            return S;
        }
        char[] chars = S.toCharArray();
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (chars[i] == ' ') {
                count++;
            }
        }
        int lastLength = length + 2 * count;
        for (int i = length - 1; i >= 0; i--) {
            if (chars[i] == ' ') {
                chars[lastLength--] = '0';
                chars[lastLength--] = '2';
                chars[lastLength--] = '%';
            } else {
                chars[lastLength--] = chars[i];
            }
        }
        return String.valueOf(chars, 0,length + 2 * count);
    }

    public static void main(String[] args) {
        int[] arr = {2,1,4,6,2,6,8,0,6,2,6,1};
//        heapSort(arr);
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
        HashMap<Integer, Character> hashMap = new HashMap<>();
        Integer a = 10;
        Integer b = new Integer(10);
        hashMap.put(a, 'a');
        hashMap.put(b, 'b');
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(hashMap.get(a));
        System.out.println(hashMap.get(b));
//        String[] strings = grayCode(3);
//        for (String s : strings) {
//            System.out.println(s);
//        }
//        HashMap<TreeNode, Integer> hashMap = new HashMap<>();
//        TreeNode treeNode= new TreeNode(1);
//        hashMap.put(treeNode, 0);
//        System.out.println(hashMap.get(treeNode));
    }
}
