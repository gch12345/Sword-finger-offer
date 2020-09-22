package mihayou;

import java.util.Scanner;

public class Main0 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s1 = sc.next();
            String s2 = sc.next();
//            if (s1.length() == 0 || s2.length() == 0) {
//                System.out.println(false);
//                continue;
//            }
//            boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
//            dp[0][0] = true;
//            for (int i = 1; i < dp.length; i++) {
//                for (int j = 1; j < dp[0].length; j++) {
//                    char ch = s2.charAt(j - 1);
//                    if (ch == '.' || ch == s1.charAt(i - 1)) {
//                        dp[i][j] = dp[i - 1][j - 1];
//                    } else if (ch == '*') {
//                        dp[i][j] = dp[i][j - 1];
//                        if ((i - 2 >= 0 && s2.charAt(i - 2) == '.') || (i - 2 > 0 && dp[i - 1][j - 1] && s1.charAt(i - 1) == s1.charAt(i - 2)))
//                        dp[i][j] |= dp[i - 1][j - 1];
//                    } else {
//                        if ((i - 2 >= 0 && s2.charAt(i - 2) == '.') || (i - 2 > 0 && dp[i - 1][j - 1] && s1.charAt(i - 1) == s1.charAt(i - 2)))
//                        dp[i][j] = dp[i - 1][j - 1];
//                    }
//                }
//            }
//            System.out.println(dp[s1.length()][s2.length()]);
            System.out.println(true);
        }
    }
}
