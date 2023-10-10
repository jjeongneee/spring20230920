<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-10-10
  Time: 오전 10:39
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
            background-color: skyblue;
        }
        table, th, td {
            border: 1px solid black;
        }
    </style>
</head>
<body>
<h4>고객명 조회</h4>
<%--<form>: 검색 폼을 나타냅니다. 검색 조건(searchType)과 검색어(keyword)를 입력할 수 있으며, "조회" 버튼을 누르면 폼이 서버로 제출됩니다.--%>
<form action="">
  <div>
    검색조건
<%--      ${searchType}, ${keyword}: EL(Expression Language)을 사용하여 모델에 담겨 있는 searchType과 keyword 값을 출력합니다.--%>
    <select name="st">
        <option value="name1" ${searchType == 'name1' ? 'selected' : ''}>고객명</option>
        <option value="name2" ${searchType == 'name2' ? 'selected' : ''}>계약명</option>
    </select>
  </div>
  <div>
       검색어
      <input type="text" name="k" value="${keyword}">
  </div>
  <div>
      <button>조회</button>
  </div>
</form>
<%--<table>: 검색 결과를 표시하기 위한 테이블입니다. 테이블의 각 행에는 검색된 고객 정보가 표시됩니다.--%>
<table>
    <tr>
        <th>고객명</th>
        <th>계약명</th>
    </tr>
<%--    <c:forEach>: JSTL의 forEach 태그를 사용하여 customers 리스트를 순회하면서 각 고객의 정보를 출력합니다.--%>
    <c:forEach items="${customers}" var="customer">
        <tr>
            <td>${customer.customerName}</td>
            <td>${customer.contactName}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
