<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Faculty Page</title>
</head>
<body>
    <h2>Welcome, ${facultyName}!</h2>
    
    <h3>Your Assigned Courses:</h3>
    <table border="1">
        <tr>
            <th>Course ID</th>
            <th>Course Name</th>
            <th>Duration</th>
        </tr>
        <c:forEach var="course" items="${courses}">
            <tr>
                <td>${course.id}</td>
                <td>${course.name}</td>
                <td>${course.duration}</td>
            </tr>
        </c:forEach>
    </table>
    
    <br>
    <a href="logout">Logout</a>
</body>
</html>
