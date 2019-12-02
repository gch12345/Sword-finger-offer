package dataBase;

import com.mysql.jdbc.UpdatableResultSet;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Query {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            try {
                connection = DBUtil.getDataSource().getConnection();
                statement = connection.createStatement();
                resultSet = statement.executeQuery("select * from exam_result;");
                while (resultSet.next()) {
                    System.out.println("id = " + resultSet.getObject("id") + "  " + "name = " + resultSet.getObject("name")
                                        + "  " + "chinese = " + resultSet.getObject("chinese") + "  " + "math = " + resultSet.getObject("math")
                                        + "  " + "english = " + resultSet.getObject("english"));
                }
            } finally {
                DBUtil.close(connection, statement, resultSet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
