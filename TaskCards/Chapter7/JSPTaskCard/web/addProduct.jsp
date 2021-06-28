
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加产品</title>
</head>
<body>
    <form action="/addProduct" method="post">
        <input type="text" name="productName" placeholder="产品名称"><br>
        <input type="text" name="price" placeholder="价格"><br>
        <input type="text" name="description" placeholder="描述"><br>
        <button type="submit">添加</button>
    </form>
    <form action="/productList" method="post">
        <button type="submit">返回产品列表</button>
    </form>
</body>
</html>
