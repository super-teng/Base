<%@ page import="validator.po.User" %><%--
  Created by IntelliJ IDEA.
  User: Super腾
  Date: 2017/1/10
  Time: 9:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>UserCenter</title>
</head>
<body>
<div align="center"><h1>welcome to userCenter</h1><br/>

    <p>
        <h2>单文件上传</h2><br/>
        <!--enc标签是不对所有文件内容进行编码，  文件上传中必须使用这个元素 -->
        <form action="uploadOne" method="post" enctype="multipart/form-data">
            <p><input type="file" name="file01"></p>
            <p><input type="submit" value="submit"></p>
        </form>
    </p>
    <p>
        <h2>多文件上传</h2><br/>
        <form action="moreUpload" method="post" enctype="multipart/form-data">
            <p><input type="file" name="file01"></p>
            <p><input type="file" name="file02"></p>
            <p><input type="submit" value="submit"></p>
        </form>
    </p>
    <p>
        <%
            User user = (User)session.getAttribute("user");
            System.out.println(user.getUsername());
            System.out.println(session.getAttribute("file"));
        %>
        <a href="download?filename=<%=session.getAttribute("file")%>">文件下载</a>
    </p>
    <p><h2><a href="logOut">logout</a></h2></p>
</div>
</body>
</html>
