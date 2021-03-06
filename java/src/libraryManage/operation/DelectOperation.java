package libraryManage.operation;

import dataBase.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DelectOperation implements IOperation{
    @Override
    public void work() throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        conn = JdbcUtils.getConnection();
        System.out.println("删除书籍");
        Scanner sc = new Scanner(System.in);
        System.out.println("输入要删除书籍的编号");
        int id = sc.nextInt();
        ps = conn.prepareStatement("delete from library where id = ?");
        ps.setInt(1, id);
        int i = ps.executeUpdate();
        if(i == 1) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
        JdbcUtils.free(conn);
    }
}
