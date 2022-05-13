<%--
  Created by IntelliJ IDEA.
  User: 李寻欢
  Date: 2022/5/8
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>
        用户界面
    </title>
</head>
<body>
<h2>Studentindex</h2>
当前用户：${User.username}
<br>
<a href="${pageContext.request.contextPath}/logout">退出</a>
<br>
<table align="center" width="800px"  >
    <tr>
        <td>学号</td>
        <td>姓名</td>
        <td>性别</td>
        <td>年龄</td>
        <td>电话号码</td>
        <td>班级</td>
        <td>进行操作</td>
    </tr>
    <tr>
        <td>${Stu.id}</td>
        <td>${Stu.name}</td>
        <td>${Stu.gender}</td>
        <td>${Stu.age}</td>
        <td>${Stu.phone}</td>
        <td>${Stu.cla}</td>
        <td><a href="toupdate2?id=${Stu.id}">修改</a></td>

    </tr>

</table>
</body>
</html>
