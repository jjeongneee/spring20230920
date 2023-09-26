<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-09-26
  Time: 오후 3:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>빈칸을 입력하시오</h1>
<h3>post로 입력값 받기</h3>
<form action="/main14/sub4" method="post">
<%--     내 방식  --%>
    <div>
        title :
        <input type="text" name="title">
    </div>
    <div>
        content :
        <input type="text" name="content">
    </div>
    <button>전송</button>
</form>

<h3>post 전송</h3>
<form action="/main14/sub4" method="post">
    제목 :
    <input type="text" name="title">
    <br>
    <textarea name="content" placeholder="본문" id="" cols="30" rows="10"></textarea>
    <br>
    <button>전송</button>

</body>
</html>
