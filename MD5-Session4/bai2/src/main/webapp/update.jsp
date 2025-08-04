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
<form action="<%=request.getContextPath()%>/StudentServlet?action=updateStudent" method="post">
    <label for="studentId"></label>
    <input type="text" id="studentId" name="studentId" value="${student.id}" readonly>
    <br>
    <label for="studentName"></label>
    <input type="text" id="studentName" name="studentName" value="${student.name}">
    <br>
    <label for="studentAge"></label>
    <input type="text" id="studentAge" name="studentAge" value="${student.age}">
    <br>
    <label>studentAct:</label><br>
    <input type="radio" id="active" name="studentAct" value="true" ${student.status?"checked":""}>
    <label for="active">Active</label>
    <br>
    <input type="radio" id="deactive" name="studentAct" value="false" ${student.status?"":"checked"}>
    <label for="deactive">Deactive</label>
    <br>
    <button type="submit">Submit</button>
</form>
</body>
</html>
