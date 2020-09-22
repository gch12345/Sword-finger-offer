package mihayou;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int row = sc.nextInt();
            int col = sc.nextInt();
            char[][] arr = new char[row][col];
            int num = 0;
            int i = 0;
            int j = 0;
            int m = col - 1;
            int n = row - 1;
            while (true) {
                for (int x = j; x <= m && x >= 0; x++) {
                    arr[i][x] = (char) (num + 'A');
                    num++;
                    num %= 26;
                }
                i++;
                if (i > n) {
                    break;
                }
                for (int x = i; x <= n && x >= 0; x++) {
                    arr[x][m] = (char)(num + 'A');
                    num++;
                    num %= 26;
                }
                m--;
                if (j > m) {
                    break;
                }
                for (int x = m; x >= j; x--) {
                    arr[n][x] = (char)(num + 'A');
                    num++;
                    num %= 26;
                }
                n--;
                if (i > n) {
                    break;
                }
                for (int x = n; x >= i; x--) {
                    arr[x][j] = (char)(num + 'A');
                    num++;
                    num %= 26;
                }
                j++;
                if (j > m) {
                    break;
                }
            }
            for (int x = 0; x < arr.length; x++) {
                for (int y = 0; y < arr[0].length; y++) {
                    System.out.print(arr[x][y] + " ");
                }
                System.out.println();
            }
        }
    }
}
