package site.pwjworks.jdbcFirstDemo;

import java.sql.*;

public class JdbcFirstDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/school?useUnicode=true&characterEncoding=utf8";
        String username = "root";
        String password = "82064125ppp";
        Connection connection = DriverManager.getConnection(url, username, password);

        Statement statement = connection.createStatement();

        String sql = "SELECT * FROM students";

        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            System.out.println("id=" + resultSet.getObject("id"));
            System.out.println("name=" + resultSet.getObject("name"));
            System.out.println("age=" + resultSet.getObject("age"));
            System.out.println("============================================");

        }
        resultSet.close();
        statement.close();
        connection.close();
    }
}
