<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
    <h1>Register</h1>
    <form action="/register" method="post">
        <label for="username">Username:</label>
        <input type="text" name="username" required/><br/><br/>
        <label for="password">Password:</label>
        <input type="password" name="password" required/><br/><br/>
        <input type="submit" value="Register"/>
    </form>
    <br/>
    <a href="Login.jsp">Already have an account? Login here</a>
</body>
</html>
