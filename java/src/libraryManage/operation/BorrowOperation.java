package libraryManage.operation;

import dataBase.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class BorrowOperation implements IOperation {
    @Override
    public void work() throws SQLException {
        System.out.println("借阅书籍");
        Scanner sc = new Scanner(System.in);
        System.out.println("输入书的编号");
        int id = sc.nextInt();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        conn = JdbcUtils.getConnection();
        conn.prepareStatement("select isBorrowed from library where id = ?;");
        ps.setInt(1, id);
        if(rs.next())
        {
            if(rs.getInt("id") == 0)
            {
                conn.prepareStatement("update library set isBorrowed = 1 where id = ?;");
                ps.setInt(1, id);
            } else {
                System.out.println("此书已借出");
            }
        } else {
            System.out.println("没有这本书");
        }
        JdbcUtils.free(conn);
    }
}
