<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-10-10
  Time: 오전 11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
    <style>
        table{
            border-collapse: collapse;
        }
        th {
            background-color: peachpuff;
        }
        table, th, td {
            border: 1px solid black;
        }
    </style>
</head>
<body>
<h4>직원 조회</h4>
<form action="">
  <div>
    검색조건
<%--    select>option[value]*3--%>
    <select name="t">
      <option value="lname" ${searchType == 'lname' ? 'selected' : ''}>Last Name</option>
      <option value="fname" ${searchType == 'fname' ? 'selected' : ''}>First Name</option>
      <option value="note"  ${searchType == 'note' ? 'selected' : ''}>Notes</option>
    </select>
  </div>
  <div>
    검색어
<%--    input[name][value]--%>
    <input type="text" name="k" value="${keyword}">
  </div>
  <div>
    <button>조회</button>
  </div>
</form>

<hr>
<table>
    <tr>
        <th>성</th>
        <th>이름</th>
        <th>메모</th>
    </tr>
    <c:forEach items="${employees}" var="employee">
        <tr>
            <td>${employee.LastName}</td>
            <td>${employee.FirstName}</td>
            <td>${employee.Notes}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
