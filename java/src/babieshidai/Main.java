package babieshidai;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static Integer solution0(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        int left = 0;
        int right = arr.length - 1;
        int mid = (right - left) / 2 + left;
        while (mid > 0 && mid < arr.length - 1) {
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return arr[mid];
            } else if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
                mid = (right - left) / 2 + left;
            } else {
                right = mid - 1;
                mid = (right - left) / 2 + right;
            }
        }
        return Math.max(arr[0], arr[arr.length - 1]);
    }

    public static int solution0(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        Map<Character, Integer> mapL = new HashMap<>();
        Map<Character, Integer> mapR = new HashMap<>();
        int i = 0;
        int j = str.length() - 1;
        int max = 0;
        while (i < j) {
            char l = str.charAt(i);
            char r = str.charAt(j);
            if (!mapL.containsKey(l)) {
                mapL.put(l, i);
            }
            if (!mapR.containsKey(j)) {
                mapR.put(r, j);
            }
            if (mapL.containsKey(r)) {
                int count = j - mapL.get(r) - 1;
                if (count > max) {
                    max = count;
                }
            }
            if (mapR.containsKey(l)) {
                int count = mapR.get(l) - i - 1;
                if (count > max) {
                    max = count;
                }
            }
            i++;
            j--;
        }
        return max;
    }

    public static String solution(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int maxIndex = 0;
        int start = 0;
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (map.containsKey(ch) && map.get(ch) >= start) {
                int index = map.get(ch);
                count = i - index;
                start = index + 1;
            } else {
                count++;
            }
            if (count > max) {
                max = count;
                maxIndex = i - count + 1;
            }
            map.put(ch, i);
        }
        return str.substring(maxIndex, maxIndex + max);
    }
    public static int solution(int k, int d, int t) {
        int ret = 0;
        ret = t / k * d;
        return ret;
    }

    public static void main(String[] args) {
        int[] arr = {4,2,1,0};
        System.out.println(solution("abcabced"));
//        System.out.println(solution(arr));
    }
}
