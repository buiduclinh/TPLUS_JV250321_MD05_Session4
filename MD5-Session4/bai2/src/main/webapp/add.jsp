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

<form action="<%=request.getContextPath()%>/StudentServlet?action=addStudent" method="post">

    <label for="studentName"></label>
    <input type="text" id="studentName" name="name" placeholder="Stundent-Name">
    <br>
    <label for="studentAge"></label>
    <input type="text" id="studentAge" name="age" placeholder="Stundent-Age">
    <br>

    <button type="submit">Submit</button>
</form>

</body>
</html>
