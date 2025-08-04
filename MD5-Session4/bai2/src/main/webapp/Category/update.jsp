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
<form action="<%=request.getContextPath()%>/CategoryController?action=updateCategory" method="post">
    <label for="categoryId"></label>
    <input type="text" id="categoryId" name="studentId" value="${category.id}" readonly>
    <br>
    <label for="categoryName"></label>
    <input type="text" id="categoryName" name="categoryName" value="${category.name}">
    <br>
    <label for="categoryDescription"></label>
    <input type="text" id="categoryDescription" name="categoryDescription" value="${category.description}">
    <br>
    <label>categoryAct:</label><br>
    <input type="radio" id="active" name="categoryAct" value="true" ${category.status?"checked":""}>
    <label for="active">Active</label>
    <br>
    <input type="radio" id="deactive" name="categoryAct" value="false" ${category.status?"":"checked"}>
    <label for="deactive">Deactive</label>
    <br>
    <button type="submit">Submit</button>
</form>
</body>
</html>
