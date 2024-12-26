package com.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataConnect {
    public static void main(String[] args) {
        // Thông tin kết nối
        String url = "jdbc:mysql://localhost:3306/trafficmanagement"; // Sửa "TrafficManagement" theo tên database của bạn
        String user = "root"; // Thay bằng tài khoản MySQL của bạn
        String password = "NVH@21042104ok"; // Thay bằng mật khẩu MySQL của bạn

        // Kiểm tra kết nối
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            if (connection != null) {
                System.out.println("Kết nối cơ sở dữ liệu thành công!");
            }
        } catch (SQLException e) {
            System.err.println("Kết nối cơ sở dữ liệu thất bại!");
            e.printStackTrace();
        }
    }
}
