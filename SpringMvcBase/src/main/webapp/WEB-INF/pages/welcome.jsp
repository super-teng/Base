<%--
  Created by IntelliJ IDEA.
  User: Super腾
  Date: 2017/1/8
  Time: 10:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<div align="center">

     <h1>${message}</h1>

    <form action="submit" method="post">
        username:<input name="username" type="text">
        password:<input name="password" type="password">
        <input type="submit" value="submit">

    </form><br/>
    <p><a href="register"/>注册<br/></p>
    <p><a href ="userCenter"/>用户中心</p>
    <p><a href = "exceptionTest"/>测试异常</p>
</div>

</div>
</body>
</html>
