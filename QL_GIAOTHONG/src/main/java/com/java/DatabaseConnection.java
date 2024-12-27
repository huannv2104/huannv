package com.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/ql_giaothong";
    private static final String USER = "root";
    private static final String PASSWORD = "NVH@21042104ok";

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static void main(String[] args) {
        Connection conn = DatabaseConnection.getConnection();
        if (conn != null) {
            System.out.println("Kết nối thành công!");
            try {
                conn.close(); // Đảm bảo đóng kết nối sau khi kiểm tra
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Kết nối thất bại!");
        } 
    }
}

