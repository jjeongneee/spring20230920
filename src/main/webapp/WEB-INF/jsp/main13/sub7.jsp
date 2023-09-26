<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-09-26
  Time: 오후 12:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>회원 가입 하실래요?</h1>
<form action="/main13/sub8">
    <%--    div*7>label[for=input$]+input#input$[name][type]--%>
    <div>
        <label for="input1">아이디</label>
        <input type="text" id="input1" name="id">
    </div>
    <div>
        <label for="input2">이름</label>
        <input type="text" id="input2" name="name">
    </div>
    <div>
        <label for="input3">주소</label>
        <input type="text" id="input3" name="address">
    </div>
    <div>
        <label for="input4">약속일시</label>
        <input type="datetime-local" id="input4" name="schedule">
    </div>
    <div>
        <label for="input5">할일1</label>
        <input type="checkbox" id="input5" name="todos" value="lunch">
    </div>
    <div>
        <label for="input6">할일2</label>
        <input type="checkbox" id="input6" name="todos" value="go home">
    </div>
    <div>
        <label for="input7">할일3</label>
        <input type="checkbox" id="input7" name="todos" value="travel">
    </div>
    <button>회원가입</button>
</form>
</body>
</html>
