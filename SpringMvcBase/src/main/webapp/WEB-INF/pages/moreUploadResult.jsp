<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Super腾
  Date: 2017/1/11
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MoreUploadResult</title>
</head>
<body>
    <%
        List<String> fileList = (List<String>)request.getAttribute("files");
        int i = 1;
        for(String url : fileList){
            System.out.println("look "+i);
            %>
    <a href="<%=url%>">
            <img src="<%=url%>">
    </a>
    <%
        }
    %>
</body>
</html>
