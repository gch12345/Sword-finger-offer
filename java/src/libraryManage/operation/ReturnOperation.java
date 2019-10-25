package libraryManage.operation;

import dataBase.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ReturnOperation implements IOperation{
    @Override
    public void work() throws SQLException {
        System.out.println("归还书籍");
        Scanner sc = new Scanner(System.in);
        System.out.println("输入要归还书的编号");
        int id = sc.nextInt();
        Connection conn = null;
        PreparedStatement ps = null;
        conn = JdbcUtils.getConnection();
        ps = conn.prepareStatement("update library set isBorrowed = 0 where id = ?;");
        ps.setInt(1, id);
        int i = ps.executeUpdate();
        if (i == 1) {
            System.out.println("归还成功");
        } else {
            System.out.println("归还失败");
        }
        JdbcUtils.free(conn);
    }
}
