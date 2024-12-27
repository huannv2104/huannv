<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.model.User, com.model.Vehicle" %> 
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Xóa Người Dùng và Phương Tiện</title>
</head>
<body>
    <h1>Xóa Người Dùng</h1>
    <form action="deleteUser" method="post">
        <label for="userId">Nhập ID người dùng để xóa: </label>
        <input type="number" name="id" id="userId" required>
        <button type="submit">Xóa Người Dùng</button>
    </form>

    <h1>Xóa Phương Tiện</h1>
    <form action="deleteVehicle" method="post">
        <label for="vehicleId">Nhập ID phương tiện để xóa: </label>
        <input type="number" name="id" id="vehicleId" required>
        <button type="submit">Xóa Phương Tiện</button>
    </form>
</body>
</html>
