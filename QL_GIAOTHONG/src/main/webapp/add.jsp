<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.model.User, com.model.Vehicle" %> 
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Thêm Người Dùng và Phương Tiện</title>
</head>
<body>
    <h1>Thêm Người Dùng</h1>
    <form action="addUser" method="post">
        <input type="text" name="username" placeholder="Tên người dùng" required>
        <input type="password" name="password" placeholder="Mật khẩu" required>
        <button type="submit">Thêm Người Dùng</button>
    </form>

    <h1>Thêm Phương Tiện</h1>
    <form action="addVehicle" method="post">
        <input type="text" name="vehicleName" placeholder="Tên phương tiện" required>
        <input type="text" name="licensePlate" placeholder="Biển số xe" required>
        <input type="number" name="userId" placeholder="ID người dùng" required>
        <button type="submit">Thêm Phương Tiện</button>
    </form>
</body>
</html>
