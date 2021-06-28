
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
