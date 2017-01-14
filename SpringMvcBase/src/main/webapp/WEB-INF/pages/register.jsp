<%--
  Created by IntelliJ IDEA.
  User: Super腾
  Date: 2017/1/9
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
    <div align="center">
        <form action="doRegister" method="post">

            <p>
                ${ERR_username}
                username:<input name="username" type="text">  </p>
            <p>
                ${ERR_password}
                password:<input name="password" type="password"></p>
            <p>
                ${ERR_realName}
                realName:<input name="realName" type="text"></p>
            <p>
                ${ERR_age}
                age:<input name="age"type="text"></p>
            <p>
                ${ERR_email}
                email:<input name="email" type="text"></p>
            <p><input type="submit" value="submit"></p>
        </form>
    </div>
</body>
</html>
