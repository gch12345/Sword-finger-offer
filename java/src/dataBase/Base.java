package dataBase;

import java.sql.*;

public class Base {
    public static void main(String[] args) throws SQLException {
        template();
    }
    static void template() throws SQLException {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            st = conn.prepareStatement("select * from user;");
            rs = st.executeQuery();
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