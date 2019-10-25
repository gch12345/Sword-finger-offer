package libraryManage.operation;

import dataBase.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PrintfAllOperation implements IOperation{
    @Override
    public void work() throws SQLException {
        System.out.println("打印书籍");
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        conn = JdbcUtils.getConnection();
        ps = conn.prepareStatement("select * from library ");
        rs = ps.executeQuery();
        while (rs.next()) {
            System.out.print(rs.getInt("id") + "\t" +
                    rs.getString("name") + "\t" +
                    rs.getFloat("price") + "\t" +
                    rs.getDate("PublicationDate") + "\t");
            if(rs.getInt("isBorrowed") == 0){
                System.out.println("未借出");
            } else {
                System.out.println("借出");
            }
        }
    }
}
