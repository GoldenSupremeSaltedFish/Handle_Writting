package org.example;

import org.apache.ibatis.jdbc.Null;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTest {

    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/humphrey?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false";
        String username = "root";
        String password = "0000";

        try {
            // 加载MySQL驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 获取数据库连接
            Connection connection = DriverManager.getConnection(url, username, password);
            if (connection != null) {
                System.out.println("连接成功！");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("无法加载数据库驱动！");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("数据库连接失败！");
            e.printStackTrace();
        }
    }
}
