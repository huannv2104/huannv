<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>User Management</title>
</head>
<body>
    <h1>Manage Users</h1>
    <form method="post" action="UserServlet">
        <input type="hidden" name="action" value="add">
        <input type="text" name="name" placeholder="Name" required>
        <input type="password" name="password" placeholder="Password" required>
        <button type="submit">Add User</button>
    </form>
    <h2>Existing Users</h2>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Password</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.password}</td>
                <td>
                    <form method="post" action="UserServlet" style="display:inline;">
                        <input type="hidden" name="action" value="delete">
                        <input type="hidden" name="id" value="${user.id}">
                        <button type="submit">Delete</button>
                    </form>
                    <form method="post" action="UserServlet" style="display:inline;">
                        <input type="hidden" name="action" value="update">
                        <input type="hidden" name="id" value="${user.id}">
                        <input type="text" name="name" placeholder="New Name" required>
                        <input type="password" name="password" placeholder="New Password" required>
                        <button type="submit">Update</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>