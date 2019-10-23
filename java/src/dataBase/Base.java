package dataBase;

import java.sql.*;

public class Base {
    public static void main(String[] args) throws SQLException {
        template();
    }
    static void template() throws SQLException {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("select * from user;");
            while (rs.next()) {
                System.out.println(rs.getObject("id") + "\t" + rs.getObject("name") + "\t" +
                        rs.getObject("age"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.free(conn);
        }
    }
}