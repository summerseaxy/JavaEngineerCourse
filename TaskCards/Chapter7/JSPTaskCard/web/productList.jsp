<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>产品列表</title>
</head>
<body>
    <table border="1">
        <tr>
            <td>id</td>
            <td>产品名称</td>
            <td>产品价格</td>
            <td>产品描述</td>
        </tr>

        <c:forEach var="product" items="${productList}">
            <tr>
                <td>${product.id}</td>
                <td>${product.productName}</td>
                <td>${product.price}</td>
                <td>${product.description}</td>
            </tr>
        </c:forEach>
    </table>

    <button><a href="addProduct.jsp">添加产品</a></button>
    <button><a href="delProduct.jsp">删除产品</a></button>
</body>
</html>
