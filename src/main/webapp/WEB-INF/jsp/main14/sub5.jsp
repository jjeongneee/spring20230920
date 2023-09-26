<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-09-26
  Time: 오후 3:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--내방식--%>
<h2>Get</h2>
<form action="/main14/sub6">
    <input type="text" name="username">
    <input type="text" name="password">
    <button>버튼</button>
</form>

<%--선생님 방식--%>
<form action="/main14/sub6" method="post">
    id :
    <input type="text" name="username">
    <br>
    password:
    <input type="password" name="password">
    <br>
    <button>로그인</button>
</form>
</body>
</html>
