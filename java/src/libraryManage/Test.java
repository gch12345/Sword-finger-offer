package libraryManage;

import libraryManage.user.Admin;
import libraryManage.user.OrdinaryUsers;
import libraryManage.user.User;

import java.sql.SQLException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws SQLException {
        User user = login();
        while (true) {
            int choice = user.menu();
            user.doOprition(choice);
        }
    }
    public static User login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入您的姓名:");
        String name = scanner.next();
        System.out.println("请输入您的角色:(1 普通用户 2 管理员)");
        int role = scanner.nextInt();
        if (role == 1) {
            return new OrdinaryUsers(name);
        }
        return new Admin(name);
    }
}
