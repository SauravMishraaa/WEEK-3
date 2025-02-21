<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <title>Faculty Login</title>
</head>
<body>
    <h2>Faculty Login</h2>
    <form action="validate-login" method="post">
        <label>Email:</label>
        <input type="text" name="email" required />
        <br><br>
        <label>Password:</label>
        <input type="password" name="pass" required />
        <br><br>
        <input type="submit" value="Login">
    </form>
    <c:if test="${not empty error}">
        <p style="color: red">${error}</p>
    </c:if>
</body>
</html>
