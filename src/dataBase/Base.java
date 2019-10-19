package dataBase;

import java.sql.*;



public class Base {
    public static void main(String[] args) {
        template();
    }
    static void template() {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("select * from datdBase");
            while (rs.next()) {
           System.out.println(rs.getObject("id") + "\t" + rs.getObject("name") + "\t" +
                   rs.getObject("age"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
//    String url = "jdbc:mysql://localhost:3306";
//    String user = "root";
//    String password = "";
//     public static void main(String[] arge) throws SQLException {
//        //Base ba = new Base();
//         try {
//             forName("com.mysql.jdbc.Driver");
//         } catch (ClassNotFoundException e) {
//             e.printStackTrace();
//         }
//         test();
//    }
//    public void test() throws ClassNotFoundException, SQLException {
//
//        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");
//        Statement st = conn.createStatement();
//        ResultSet re = st.executeQuery("select * from datdBase");
//        while (re.next()) {
//               System.out.println(re.getObject("id") + "\t" + re.getObject("name") + "\t" +
//                       re.getObject("age"));
//               }
//               conn.close();
//    }
//}
//    public static void main(String[] arge) throws SQLException {
//        Base ba = new Base();
//        ba.sql();
//    }
//    public void sql() throws SQLException {
//        try {
//            try {
//                Class.forName("com.mysql.jdbc.Driver");
//            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
//            }
//            Connection cn = DriverManager.getConnection(url, user, password);
//            PreparedStatement ps = cn.prepareStatement("select * from dateBase");
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                System.out.println(rs.getObject("id") + "\t" + rs.getObject("name") + "\t" +
//                        rs.getObject("age"));
//            }
//            cn.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//}
