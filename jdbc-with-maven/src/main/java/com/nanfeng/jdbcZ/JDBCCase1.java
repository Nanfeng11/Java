package com.nanfeng.jdbcZ;

import java.sql.*;
import java.time.LocalDateTime;

/**
 * 演示JDBC开发流程
 * Author：nanfeng
 * Created:2019/7/20
 */
public class JDBCCase1 {
    public static void main(String[] args) {
        //forName---ClassName类的权限类名
        try {
            //1、
            //这个类存在虚拟机里了，java.sql.Driver这个接口有实现类了，实现类和接口类在同一个类加载器中
            Class.forName("com.mysql.jdbc.Driver");

            //2、
            //JDBC规范中对Url定义：jdbc:<databaseProductName>://host:port/<databaseName>?param1=value1&param2=value2
            //MySQL -> mysql   H2 -> h2   Oracle -> oracle
            //example
            String url = "jdbc:mysql://127.0.0.1:3306/memo?user=root&password=nanfeng&useSSL=false";
            Connection connection = DriverManager.getConnection(url);

            //3、
            String sql = "select id,name,created_time,modify_time from memo_group";

            //4、
            Statement statement = connection.createStatement();

            //5、
            ResultSet resultSet = statement.executeQuery(sql);

            //6、
            while (resultSet.next()) {
                //每次执行next如果返回true，定位到数据库记录的下一条
                //getXxx(int)通过查询结果记录的列的下标取值(从1开始)，不建议采用这种方式
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                LocalDateTime created_time = resultSet.getTimestamp("created_time").toLocalDateTime();
                //Timestamp -> (toLocalDateTime())LocalDateTime
                //LocalDateTime -> (Timestamp.valueOf())Timestamp
                LocalDateTime modify_time = resultSet.getTimestamp("modify_time").toLocalDateTime();

                System.out.println(id+" "+name+" "+created_time+" "+modify_time);
            }

            //7、
            resultSet.close();

            //8
            statement.close();

            //9
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
