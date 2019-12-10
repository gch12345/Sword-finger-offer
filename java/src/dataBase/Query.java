package dataBase;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Query {
    public static void main(String[] args) {
        mysql();
    }
    public static void mysql() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            try {
                connection = DBUtil.getDataSource().getConnection();
                statement = connection.prepareStatement("select * from exam_result where name = ?;");
                statement.setString(1, " ");
                resultSet = statement.executeQuery();
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
