package com.nanfeng.jdbcZ;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 演示JDBC预编译命令
 * Author：nanfeng
 * Created:2019/7/20
 */
public class JDBCCase11 {

    public static List<MemoGroup> queryMemoGroup(String... names) {
        List<MemoGroup> data = new ArrayList<>();
        if (names.length==0){
            return data;
        }

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
            StringBuilder sb = new StringBuilder();
            sb.append("select id,name,created_time,modify_time from memo_group where name in(");
            for (int i=0;i<names.length;i++){
                sb.append("?,");
            }
            sb.setLength(sb.length()-1);    //去掉最后多余的逗号
            sb.append(")");

            //4、[修改]
            statement = connection.prepareStatement(sb.toString());

            //5、[修改]
            //参数赋值parameterIndex 从1开始
            for (int i=0;i<names.length;i++){
                statement.setString(i+1,names[i]);
            }
            resultSet = statement.executeQuery();

            //6、
            while (resultSet.next()) {

                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                LocalDateTime created_time = resultSet.getTimestamp("created_time").toLocalDateTime();

                LocalDateTime modify_time = resultSet.getTimestamp("modify_time").toLocalDateTime();

                MemoGroup memoGroup = new MemoGroup();
                memoGroup.setId(id);
                memoGroup.setName(name);
                memoGroup.setCreatedTime(created_time);
                memoGroup.setModifyTime(modify_time);

                data.add(memoGroup);
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
        return data;
    }

    public static void main(String[] args) {
        //where name in (?)
        //where name in ('C++','default')
        //? 不能作为多参数
       List<MemoGroup> memoGroups = queryMemoGroup("C++","default","Java");
       for (MemoGroup memoGroup:memoGroups){
           System.out.println(memoGroup);
       }
    }
}
