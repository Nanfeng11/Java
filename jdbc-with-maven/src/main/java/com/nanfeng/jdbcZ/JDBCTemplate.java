package com.nanfeng.jdbcZ;

import java.sql.*;
import java.time.LocalDateTime;

/**
 * 模板设计模式+函数接口
 * Author：nanfeng
 * Created:2019/7/21
 */
public class JDBCTemplate {

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    //定义模板的执行流程
    public final <P, R> R execute(String sql, Handler<P, R> handler) {

        R result = null;
        try {
            this.loadDriver();
            this.createConnection();
            this.createStatement();

            if (sql.trim().toUpperCase().startsWith("SELECT")) {
                //R
                this.callQuery(sql);
                result = handler.handle((P) this.resultSet);
            } else {
                Integer effect = this.callUpdate(sql);
                result = handler.handle((P) effect);
            }
            this.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
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

}

//泛型接口
//函数接口 y = f(x)
@FunctionalInterface
interface Handler<P, R> {
    R handle(P p) throws SQLException;
}


