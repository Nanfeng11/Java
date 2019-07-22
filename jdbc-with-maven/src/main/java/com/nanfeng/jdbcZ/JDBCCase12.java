package com.nanfeng.jdbcZ;

import java.sql.*;
import java.time.LocalDateTime;

/**
 * Author：nanfeng
 * Created:2019/7/21
 */
public class JDBCCase12 {
    //创建便签
    //便签组和便签 便签属于便签组
    //memogroup groupId = memoGroup id
    public static boolean createMemoInfo(MemoGroup memoGroup,MemoInfo memoInfo){
        Connection connection = null;

        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/memo?useSSL=false&useUnicode=true&characterEncoding=UTF-8";
            String username = "root";
            String password = "nanfeng";

            connection = DriverManager.getConnection(url,username,password);

            //事务控制
            connection.setAutoCommit(false);     //默认自动提交的，如果事务控制了，需要设置true

            //SQL
            String insertMempGroupSql = "insert into memo_group (id,name,created_time) values (?,?,?)";
            String insertMemoInfoSql = "insert into memeo_info (id,group_id,title,content,created_time) valus (?,?,?,?,?)";

            //执行
            int effectA = -1;
            int effectB = -1;
            //1、插入MemoGroup
            try(PreparedStatement statement = connection.prepareStatement(insertMempGroupSql)){
                statement.setInt(1,memoGroup.getId());
                statement.setString(2,memoGroup.getName());
                statement.setTimestamp(3,Timestamp.valueOf(memoGroup.getCreatedTime()));
                effectA = statement.executeUpdate();
            }
            //2、插入MemoInfo
            try (PreparedStatement statement = connection.prepareStatement(insertMemoInfoSql)){
                statement.setInt(1,memoInfo.getId());
                statement.setInt(2,memoInfo.getGroupId());
                statement.setString(3,memoInfo.getTitle());
                statement.setString(4,memoInfo.getContent());
                statement.setTimestamp(5,Timestamp.valueOf(memoInfo.getCreatedTime()));
                effectB = statement.executeUpdate();
            }

            if (effectA==1 && effectB==1){
                connection.commit();    //提交
                return true;
            }else {
                connection.rollback();      //回滚
            }

        }catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
            if (connection!=null){
                try {
                    connection.rollback();      //回滚
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        }finally {
            if (connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        //准备数据
        MemoGroup memoGroup = new MemoGroup();
//        memoGroup.setId(666);
        memoGroup.setId(10);
        memoGroup.setName("Java5");
        memoGroup.setCreatedTime(LocalDateTime.now());

        MemoInfo memoInfo = new MemoInfo();
        memoInfo.setId(111);
        memoInfo.setGroupId(memoGroup.getId());
        memoInfo.setTitle("JDBC笔记");
        memoInfo.setContent("~~~~");
        memoInfo.setCreatedTime(LocalDateTime.now());

        boolean rs = createMemoInfo(memoGroup,memoInfo);
        if (rs){
            System.out.println("创建组"+memoGroup+"和便签"+memoInfo+"成功");
        }else {
            System.out.println("创建组"+memoGroup+"和便签"+memoInfo+"失败");
        }
        /*
            1、方法中一组DML操作
            2、事务提交：正确且符合业务逻辑
            3、事务回滚：错误 或 不符合业务逻辑
         */
    }
}
