package nowCoder;

import java.util.Scanner;

public class encrypt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            char[] password = sc.nextLine().toCharArray();
            char[] aucPassword = sc.nextLine().toCharArray();
            System.out.println(new String(Encrypt(password)));
            System.out.println(new String(unEncrypt(aucPassword)));
        }
    }

    static char[] Encrypt(char[] aucPassword) {
        if (aucPassword == null || aucPassword.length == 0) {
            return new char[0];
        }
        for (int i = 0; i < aucPassword.length; i++) {
            char ch = aucPassword[i];
            if (ch >= '0' && ch <= '9') {
                aucPassword[i] = (char)((ch - '0' + 1) % 10 + '0');
            } else if (ch >= 'a' && ch <= 'z') {
                aucPassword[i] = (char)((ch - 'a' + 1) % 26 + 'A');
            } else if (ch >= 'A' && ch <= 'Z') {
                aucPassword[i] = (char)((ch - 'A' + 1) % 26 + 'a');
            } else {
                return new char[0];
            }
        }
        return aucPassword;
    }

    static char[] unEncrypt(char[] password) {
        if (password == null || password.length == 0) {
            return new char[0];
        }
        for (int i = 0; i < password.length; i++) {
            char ch = password[i];
            if (ch >= '0' && ch <= '9') {
                password[i] = (char)((ch - '0' - 1 + 10) % 10 + '0');
            } else if (ch >= 'a' && ch <= 'z') {
                password[i] = (char)((ch - 'a' - 1 + 26) % 26 + 'A');
            } else if (ch >= 'A' && ch <= 'Z') {
                password[i] = (char)((ch - 'A' - 1 + 26) % 26 + 'a');
            } else {
                return new char[0];
            }
        }
        return password;
    }
}
