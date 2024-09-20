<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 9/20/2024
  Time: 7:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Danh sachs danh muc </h1>
    <table width="500px" border="1px">
        <tr>
            <td>ID</td>
            <td>Name</td>
            <td>Status</td>
        </tr>
        <c:forEach items="${categories}" var="cate">
            <tr>
                <td>${cate.categoryId}</td>
                <td>${cate.categoryName}</td>
                <td>${cate.categoryStatus}</td>
            </tr>
        </c:forEach>

    </table>
</body>
</html>
