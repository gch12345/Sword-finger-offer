package dataBase;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.*;

public class DBUtil {

    private static final String URL = "jdbc:mysql://localhost:3306/java";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private static DataSource DATASOURCE = new MysqlDataSource();
    static {
        ((MysqlDataSource)DATASOURCE).setURL(URL);
        ((MysqlDataSource)DATASOURCE).setUser(USER);
        ((MysqlDataSource)DATASOURCE).setPassword(PASSWORD);
    }


    private DBUtil() {

    }

    public static Connection getConnection1() {
        Connection connection = null;
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } finally {
                connection.close();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static Connection getConnection2() {
        try {
            return DATASOURCE.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("连接失败");
        }
    }
    //单例
    private static DataSource DATASOURCE2;

    public static DataSource getDataSource() {
        if (DATASOURCE2 == null) {
            DATASOURCE2 = new MysqlDataSource();
            ((MysqlDataSource)DATASOURCE2).setURL(URL);
            ((MysqlDataSource)DATASOURCE2).setUser(USER);
            ((MysqlDataSource)DATASOURCE2).setPassword(PASSWORD);
        }
        return DATASOURCE2;
    }

    public static void close(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            if (resultSet != null)
                resultSet.close();
            if (statement != null)
                statement.close();
            if (connection != null)
                connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("释放失败");
        }
    }
    public static void main(String[] args) {
        System.out.println(getConnection1());
        System.out.println(getConnection2());
        System.out.println(getDataSource());
    }
}
