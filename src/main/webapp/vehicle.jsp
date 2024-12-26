<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>Vehicle Management</title>
</head>
<body>
    <h1>Manage Vehicles</h1>
    <form method="post" action="VehicleServlet">
        <input type="hidden" name="action" value="add">
        <input type="text" name="name" placeholder="Vehicle Name" required>
        <input type="text" name="license_plate" placeholder="License Plate" required>
        <input type="number" name="user_id" placeholder="User ID" required>
        <button type="submit">Add Vehicle</button>
    </form>
    <h2>Existing Vehicles</h2>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>License Plate</th>
            <th>User ID</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="vehicle" items="${vehicles}">
            <tr>
                <td>${vehicle.id}</td>
                <td>${vehicle.name}</td>
                <td>${vehicle.licensePlate}</td>
                <td>${vehicle.userId}</td>
                <td>
                    <form method="post" action="VehicleServlet" style="display:inline;">
                        <input type="hidden" name="action" value="delete">
                        <input type="hidden" name="id" value="${vehicle.id}">
                        <button type="submit">Delete</button>
                    </form>
                    <form method="post" action="VehicleServlet" style="display:inline;">
                        <input type="hidden" name="action" value="update">
                        <input type="hidden" name="id" value="${vehicle.id}">
                        <input type="text" name="name" placeholder="New Name" required>
                        <input type="text" name="license_plate" placeholder="New License Plate" required>
                        <input type="number" name="user_id" placeholder="New User ID" required>
                        <button type="submit">Update</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>