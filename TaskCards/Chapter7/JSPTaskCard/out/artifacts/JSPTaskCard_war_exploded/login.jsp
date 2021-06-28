<%--
  Created by IntelliJ IDEA.
  User: 许逍遥
  Date: 2021/6/25
  Time: 18:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>

    <form action="/login" method="post">
        <input type="text" name="username" placeholder="用户名"><br>
        <input type="password" name="password" placeholder="密码"><br>
        <input type="submit" value="登录"><br>
    </form>

    <button><a href="register.jsp">前往注册</a></button>

</body>
</html>
