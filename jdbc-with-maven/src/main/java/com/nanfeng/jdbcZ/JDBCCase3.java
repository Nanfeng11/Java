package com.nanfeng.jdbcZ;

import java.sql.*;
import java.time.LocalDateTime;

/**
 * 演示JDBC开发流程
 * Author：nanfeng
 * Created:2019/7/20
 */
public class JDBCCase3 {
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
            String url = "jdbc:mysql://127.0.0.1:3306/memo?&useSSL=false";
            Connection connection = DriverManager.getConnection(url, "root", "nanfeng");

            //3、【改】
            String sql = "insert into memo_group(name,created_time) values ('C++组','2019-07-21 12:09:00')";

            //4、
            Statement statement = connection.createStatement();

            //5、【改】
            int effect = statement.executeUpdate(sql);

            //6、【改】
            if (effect==1){
                System.out.println("插入成功"+effect);
            }else {
                System.out.println("插入失败"+effect);
            }

            //7、【改】
            // resultSet.close();

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
