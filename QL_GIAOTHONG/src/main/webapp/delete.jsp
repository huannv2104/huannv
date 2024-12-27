<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Xóa Người Dùng và Phương Tiện</title>
</head>
<body>
    <h2>Xóa Người Dùng</h2>
    <form action="deleteUser" method="post">
        <label for="userId">Nhập ID người dùng để xóa: </label>
        <input type="number" name="userId" id="userId" required>
        <button type="submit">Xóa Người Dùng</button>
    </form>

    <h2>Xóa Phương Tiện</h2>
    <form action="deleteVehicle" method="post">
        <label for="vehicleId">Nhập ID phương tiện để xóa: </label>
        <input type="number" name="vehicleId" id="vehicleId" required>
        <button type="submit">Xóa Phương Tiện</button>
    </form>
</body>
</html>