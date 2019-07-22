package com.nanfeng.jdbcZ;

import java.sql.*;
import java.time.LocalDateTime;

/**
 * 演示JDBC开发流程
 * Author：nanfeng
 * Created:2019/7/20
 */
public class JDBCCase5 {
    public static void main(String[] args) {

        try {
            //1、
            Class.forName("com.mysql.jdbc.Driver");
            //2、
            String url = "jdbc:mysql://127.0.0.1:3306/memo?user=root&password=nanfeng&useSSL=false";
            //3、
            String sql = "select id,name,created_time,modify_time from memo_group";
           //try-with-resources方式自动关闭资源
            try(Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            ResultSet  resultSet = statement.executeQuery(sql);
            ){
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    LocalDateTime created_time = resultSet.getTimestamp("created_time").toLocalDateTime();
                    LocalDateTime modify_time = resultSet.getTimestamp("modify_time").toLocalDateTime();
                    System.out.println(id + " " + name + " " + created_time + " " + modify_time);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
