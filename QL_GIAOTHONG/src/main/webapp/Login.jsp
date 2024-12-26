<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h1>Login</h1>
    <form action="/login" method="post">
        <label for="username">Username:</label>
        <input type="text" name="username" required/><br/><br/>
        <label for="password">Password:</label>
        <input type="password" name="password" required/><br/><br/>
        <input type="submit" value="Login"/>
    </form>
    <br/>
    <a href="Register.jsp">Don't have an account? Register here</a>
</body>
</html>
