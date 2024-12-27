<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, java.util.*" %>
<%@ page import="com.java.DatabaseConnection" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Danh Sách Người Dùng và Phương Tiện</title>
</head>
<body>
    <h1>Danh Sách Người Dùng</h1>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Tên người dùng</th>
                <th>Mật khẩu</th>
            </tr>
        </thead>
        <tbody>
            <%
                // Fetch users from the database
                List<String> users = new ArrayList<>();
                try (Connection conn = DatabaseConnection.getConnection()) {
                    if (conn != null) {
                        String sql = "SELECT id, username, password FROM users";
                        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
                            while (rs.next()) {
                                users.add(rs.getInt("id") + ": " + rs.getString("username") + ": " + rs.getString("password"));
                            }
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                // Display users in the table
                for (String user : users) {
            %>
                <tr>
                    <td><%= user.split(":")[0] %></td>
                    <td><%= user.split(":")[1] %></td>
                    <td><%= user.split(":")[2] %></td>
                </tr>
            <% } %>
        </tbody>
    </table>

    <h1>Danh Sách Phương Tiện</h1>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Tên phương tiện</th>
                <th>Biển số xe</th>
                <th>ID Người Dùng</th>
            </tr>
        </thead>
        <tbody>
            <%
                // Fetch vehicles from the database
                List<String> vehicles = new ArrayList<>();
                try (Connection conn = DatabaseConnection.getConnection()) {
                    if (conn != null) {
                        String sql = "SELECT id, vehicle_name, license_plate, user_id FROM vehicles";
                        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
                            while (rs.next()) {
                                vehicles.add(rs.getInt("id") + ": " + rs.getString("vehicle_name") + ": " + rs.getString("license_plate") + ": " + rs.getInt("user_id"));
                            }
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                // Display vehicles in the table
                for (String vehicle : vehicles) {
            %>
                <tr>
                    <td><%= vehicle.split(":")[0] %></td>
                    <td><%= vehicle.split(":")[1] %></td>
                    <td><%= vehicle.split(":")[2] %></td>
                    <td><%= vehicle.split(":")[3] %></td>
                </tr>
            <% } %>
        </tbody>
    </table>
</body>
</html>
