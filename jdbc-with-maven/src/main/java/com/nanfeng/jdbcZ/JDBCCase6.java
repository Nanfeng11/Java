package com.nanfeng.jdbcZ;

import java.sql.*;
import java.time.LocalDateTime;

/**
 * 演示JDBC预编译命令
 * Author：nanfeng
 * Created:2019/7/20
 */
public class JDBCCase6 {

    public static void queryMemoGroup(String groupName){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            //1、
            //这个类存在虚拟机里了，java.sql.Driver这个接口有实现类了，实现类和接口类在同一个类加载器中
            Class.forName("com.mysql.jdbc.Driver");

            //2、
            String url = "jdbc:mysql://127.0.0.1:3306/memo?user=root&password=nanfeng&useSSL=false";
            connection = DriverManager.getConnection(url);

            //3、
            String sql = "select id,name,created_time,modify_time from memo_group where name = '"+groupName+"'";

            //4、[修改]
            statement = connection.prepareStatement(sql);

            //5、[修改]
            resultSet = statement.executeQuery();

            //6、
            while (resultSet.next()) {

                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                LocalDateTime created_time = resultSet.getTimestamp("created_time").toLocalDateTime();

                LocalDateTime modify_time = resultSet.getTimestamp("modify_time").toLocalDateTime();

                System.out.println(id + " " + name + " " + created_time + " " + modify_time);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {

            //必须分开判断，如果前两个任意一个抛异常，后面的就不会执行

            if (resultSet != null) {
                //7、
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                //8
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                //9
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public static void main(String[] args) {
        queryMemoGroup("C++");
        //SQL注入攻击
        queryMemoGroup(" ' or 1=1 or name = ' ");
    }
}