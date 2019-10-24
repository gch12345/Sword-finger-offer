package libraryManage.operation;

import dataBase.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class FindOperation implements IOperation{
    @Override
    public void work() throws SQLException {
        System.out.println("查找书籍");
        System.out.println("输入查找的书名");
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        conn = JdbcUtils.getConnection();
        int count = 0;
        conn.prepareStatement("select * from library where name = ?;");
        ps.setString(1, name);
        rs = ps.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getInt("id") + "\t" +
                                rs.getString("name") + "\t" +
                                rs.getFloat("price") + "\t" +
                                rs.getDate("date") + "\t");
            if(rs.getInt("isBorrowed") == 0){
                System.out.println("未借出");
            } else {
                System.out.println("借出");
            }
            count++;
        }
        if (count == 0) {
            System.out.println("没找到此书");
        } else {
            System.out.println("共计找到 " + count + " 本书!");
        }
        JdbcUtils.free(conn);
    }
}
