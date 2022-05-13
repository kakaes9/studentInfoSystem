<%--
  Created by IntelliJ IDEA.
  User: 李寻欢
  Date: 2022/5/8
  Time: 18:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>注册</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/RegisterUser" method="post">
    学号：&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="id" value=""/><br />
    用户名：<input type="text" name="username" value=""/><br />
    密&nbsp;&nbsp;&nbsp;码：&nbsp;&nbsp;<input type="password" name="password" value=""/><br />
    <input type="submit" value="注册"/>
    <button formaction="toLogin">登录</button>
</form>
<br>
${msg}
</body>
</html>
