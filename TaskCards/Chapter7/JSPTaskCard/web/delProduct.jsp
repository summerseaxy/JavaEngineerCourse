
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>删除产品</title>
</head>
<body>
    <form action="/delProduct" method="post">
        <input type="text" name="id" placeholder="id"><br>
        <button type="submit">删除</button>
    </form>
    <form action="/productList" method="post">
        <button type="submit">返回产品列表</button>
    </form>
</body>
</html>
