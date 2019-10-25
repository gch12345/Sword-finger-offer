package libraryManage.operation;

import dataBase.JdbcUtils;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

public class AddOperation implements IOperation {
    @Override
    public void work() throws SQLException {
        System.out.println("新增一本书");
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入书名");
        String name = sc.next();
        System.out.println("请输入编号");
        int id = sc.nextInt();
        System.out.println("请输入价格");
        double price = sc.nextDouble();
        System.out.println("请输入出版年份");
        int year = sc.nextInt() - 1900;
        System.out.println("请输入出版月份");
        int month = sc.nextInt() - 1;
        System.out.println("请输入出版日");
        int date = sc.nextInt();
        java.sql.Date PublicationDate = new java.sql.Date(year, month, date);
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        conn = JdbcUtils.getConnection();
        ps = conn.prepareStatement("insert into library (name, price, id, isBorrowed, PublicationDate) value (?,?,?,?,?);");
        ps.setString(1,name);
        ps.setDouble(2,price);
        ps.setInt(3,id);
        ps.setInt(4,0);
        ps.setDate(5, PublicationDate);
        int i = ps.executeUpdate();
        if(i != 0){
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
        JdbcUtils.free(conn);
    }
}
