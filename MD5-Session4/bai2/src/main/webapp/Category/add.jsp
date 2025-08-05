<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2025/08/01
  Time: 13:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="<%=request.getContextPath()%>/CategoryController?action=addCategory" method="post">

    <label for="categoryName"></label>
    <input type="text" id="categoryName" name="name" placeholder="Category-Name">
    <br>
    <label for="categoryDescription"></label>
    <input type="text" id="categoryDescription" name="description" placeholder="Category-Description">
    <br>

    <button type="submit">Submit</button>
</form>

</body>
</html>
