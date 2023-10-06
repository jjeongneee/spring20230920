<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-10-06
  Time: 오후 3:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
    <style>
        .active {
            background-color: peachpuff;
            color: #eeeeee;
        }
    </style>
</head>
<body>
<h4>고객 목록</h4>
<table>
    <tr>
        <th>ID</th>
        <th>NAME</th>
    </tr>

    <c:forEach items="${customerList}" var="customer">
        <tr>
            <td>${customer.id}</td>
            <td>${customer.name}</td>
        </tr>
    </c:forEach>
</table>
<div>
<%--    맨 처음으로 맨 끝으로 보내는 버튼 만들기--%>
    <c:if test="${frontPage == fistPageNumber && prevPageNumber > 0}">
        <a href="/main22/sub3?p=${frontPage}">맨 처음</a>
    </c:if>
    <c:if test="${prevPageNumber > 0}">
        <a href="/main22/sub3?p=${prevPageNumber}">이전</a>
    </c:if>
    <c:forEach begin="${leftPageNumber}" end="${rightPageNumber}" var="pageNumber">
        <a
                <c:if test="${pageNumber == currentPage}">
                    class="active"
                </c:if>
                href="/main22/sub3?p=${pageNumber}">${pageNumber}</a>
        |
    </c:forEach>
    <c:if test="${lastPageNumber >= nextPageNumber}">
        <a href="/main22/sub3?p=${nextPageNumber}">다음</a>
    </c:if>
    <c:if test="${backPage == lastPageNumber && nextPageNumber <= lastPageNumber}">
        <a href="/main22/sub3?p=${backPage}">맨 끝</a>
    </c:if>
</div>

</body>
</html>
