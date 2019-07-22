package com.nanfeng.jdbcZ;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Author：nanfeng
 * Created:2019/7/21
 */
public class TestJDBCTemplate {
    public static void main(String[] args) {
        JDBCTemplate jdbcTemplate = new JDBCTemplate();
        String result = jdbcTemplate.execute("select id,name from memo_group", new Handler<ResultSet, String>() {
            @Override
            public String handle(ResultSet resultSet) throws SQLException {
                StringBuilder sb = new StringBuilder();
                while (resultSet.next()) {
                    sb.append(resultSet.getInt("id")).append(" ")
                            .append(resultSet.getString("name"))
                            .append("\n");
                }
                return sb.toString();
            }
        });
        System.out.println(result);

        Integer count = jdbcTemplate.execute("select count(*) as total from memo_group",
                new Handler<ResultSet, Integer>() {
                    @Override
                    public Integer handle(ResultSet resultSet) throws SQLException {
                        Integer totalRow = 0;
                        if (resultSet.next()){
                            resultSet.getInt("tatal");
                        }
                        return totalRow;
                    }
                }
        );
        System.out.println("memp_group共有"+count+"条记录");

        String info = jdbcTemplate.execute("delete from memo_group where id = 1",
                (Handler<Integer, String>) effect -> {
                    if (effect==1){
                        return "删除成功";
                    }else {
                        return "删除失败";
                    }
                }
        );
        System.out.println(info);
    }
}
