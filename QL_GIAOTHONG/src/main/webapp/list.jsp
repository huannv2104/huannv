<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.model.User, com.model.Vehicle" %> 
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Danh sách Người Dùng và Phương Tiện</title>
</head>
<body>
    <h1>Danh sách Người Dùng</h1>
    <%
        List<User> usersList = (List<User>) request.getAttribute("users");
        if (usersList != null && !usersList.isEmpty()) {
            for (User user : usersList) {
    %>
        <p>ID: <%= user.getUserId() %>, Tên: <%= user.getUsername() %>, Mật khẩu: <%= user.getPassword() %>
        <form action="deleteUser" method="post">
            <input type="hidden" name="id" value="<%= user.getUserId() %>">
            <button type="submit">Xóa</button>
        </form>
        </p>
    <%
            }
        } else {
            out.println("<p>Không có người dùng nào.</p>");
        }
    %>

    <h1>Danh sách Phương Tiện</h1>
    <%
        List<Vehicle> vehiclesList = (List<Vehicle>) request.getAttribute("vehicles");
        if (vehiclesList != null && !vehiclesList.isEmpty()) {
            for (Vehicle vehicle : vehiclesList) {
    %>
        <p>Tên: <%= vehicle.getVehicleName() %>, Biển số: <%= vehicle.getLicensePlate() %>
        <form action="deleteVehicle" method="post">
            <input type="hidden" name="id" value="<%= vehicle.getVehicleId() %>">
            <button type="submit">Xóa</button>
        </form>
        </p>
    <%
            }
        } else {
            out.println("<p>Không có phương tiện nào.</p>");
        }
    %>
</body>
</html>
