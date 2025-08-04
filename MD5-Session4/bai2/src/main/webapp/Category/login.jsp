<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2025/08/04
  Time: 18:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/CategoryController?action=login" method="post">
    <label for="username"></label>
    <input id="username" name="username" type="text" placeholder="username">
    <label for="password"></label>
    <input id="password" name="password" type="password" placeholder="password">
    <button type="submit">Sign In</button>
</form>
</body>
</html>
