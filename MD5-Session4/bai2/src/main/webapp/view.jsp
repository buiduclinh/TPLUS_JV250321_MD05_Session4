<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2025/08/01
  Time: 13:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>StudentList</h1>
<table border="1">
    <thead>
    <tr>
        <th>No</th>
        <th>StudentId</th>
        <th>StudentName</th>
        <th>StudentAge</th>
        <th>Status</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${studentList}" var="student" varStatus="loop">
    <tr>
        <td>${loop.index+1}</td>
        <td>${student.id}</td>
        <td>${student.name}</td>
        <td>${student.age}</td>
        <td>${student.status?"active":"inactive"}</td>
        <td><a href="<%=request.getContextPath()%>/StudentServlet?action=initUpdateStudent&id=${student.id}">update</a>
        </td>
        <td><a href="<%=request.getContextPath()%>/StudentServlet?action=deleteStudent&id=${student.id}">delete</a>
        </td>
    </tr>
    </tbody>
    </c:forEach>
</table>
<a href="<%=request.getContextPath()%>/add.jsp">Add new student</a>
</body>
</html>
