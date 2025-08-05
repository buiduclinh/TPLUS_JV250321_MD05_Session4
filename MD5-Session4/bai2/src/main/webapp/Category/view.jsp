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
        <th>CategoryID</th>
        <th>CategoryName</th>
        <th>CategoryDescription</th>
        <th>Status</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${categories}" var="category" varStatus="loop">
    <tr>
        <td>${loop.index+1}</td>
        <td>${category.id}</td>
        <td>${category.name}</td>
        <td>${category.description}</td>
        <td>${category.status?"active":"inactive"}</td>
        <td><a href="<%=request.getContextPath()%>/CategoryController?action=initUpdate&id=${category.id}">update</a>
        </td>
        <td><a href="<%=request.getContextPath()%>/CategoryController?action=deleteCategory&id=${category.id}">delete</a>
        </td>
    </tr>
    </tbody>
    </c:forEach>
</table>
<a href="<%=request.getContextPath()%>/Category/add.jsp">Add new category</a>
</body>
</html>
