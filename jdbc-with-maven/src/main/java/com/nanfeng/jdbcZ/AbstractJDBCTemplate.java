package com.nanfeng.jdbcZ;

import java.sql.*;
import java.time.LocalDateTime;

/**
 * 模板设计模式
 * Author：nanfeng
 * Created:2019/7/21
 */
public abstract class AbstractJDBCTemplate {

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    //定义模板的执行流程
    public final void execute(String sql) {

        try {
            this.loadDriver();
            this.createConnection();
            this.createStatement();

            //SQL通过方法传入

            //R->Result   CUD->Integer
            //trim去掉空格
            if (sql.trim().toUpperCase().startsWith("SELECT")) {
                //R
                this.callQuery(sql);
                this.handlerResult(this.resultSet);
            } else {
                Integer effect = this.callUpdate(sql);
                this.handlerResult(effect);
            }

            this.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //1
    private void loadDriver() throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
    }

    //2
    private void createConnection() throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/memo?useSSL=false";
        String username = "root";
        String password = "nanfeng";
        this.connection = DriverManager.getConnection(url, username, password);
    }

    //3
    //public abstract String getSql();

    //4
    private void createStatement() throws SQLException {
        this.statement = this.connection.createStatement();
    }

    //5
    private void callQuery(String sql) throws SQLException {
        this.resultSet = this.statement.executeQuery(sql);
    }

    private Integer callUpdate(String sql) throws SQLException {
        return this.statement.executeUpdate(sql);
    }

    //6
    public abstract void handlerResult(ResultSet resultSet) throws SQLException;

    public abstract void handlerResult(Integer value);

    //7,8,9
    private void close() {
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

    public static void main(String[] args) {
        AbstractJDBCTemplate template = new JDBCTemplateCase1();
        template.execute("select id,name,created_time,modify_time from memo_group");
    }

}

class JDBCTemplateCase1 extends AbstractJDBCTemplate {

    @Override
    public void handlerResult(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            LocalDateTime created_time = resultSet.getTimestamp("created_time").toLocalDateTime();
            LocalDateTime modify_time = resultSet.getTimestamp("modify_time").toLocalDateTime();

            System.out.println(id + " " + name + " " + created_time + " " + modify_time);
        }
    }

    @Override
    public void handlerResult(Integer value) {
        System.out.println("更新结果" + value);
    }
}
